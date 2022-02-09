package messaging;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.kafka.common.header.Headers;
import org.apache.kafka.common.serialization.Deserializer;
import org.apache.kafka.common.serialization.Serializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.util.Map;

public class PaymentPendingSerializer<T extends JVROMessageType> implements Serializer<JVROMessageType>, Deserializer<T> {
    private static final Logger LOGGER = LoggerFactory.getLogger(PaymentPendingSerializer.class);

    private ObjectMapper mapper = new ObjectMapper();

    @Override
    public T deserialize(String topic, byte[] data) {
        var message = mapper.readerFor(JVROMessage.class);
        T in = null;
        try {
            JVROMessage jvroMessage = message.readValue(data, JVROMessage.class);
            var clazzReader = mapper.readerFor(jvroMessage.getClazzType());
            in = (T) clazzReader.readValue(jvroMessage.getData(), jvroMessage.getClazzType());
            LOGGER.info("I got this {}", in);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return in;
    }

    @Override
    public T deserialize(String topic, Headers headers, byte[] data) {
        return Deserializer.super.deserialize(topic, headers, data);
    }

    @Override
    public void configure(Map<String, ?> configs, boolean isKey) {

    }

    @Override
    public byte[] serialize(String topic, JVROMessageType obj) {
        try {
            var message = new JVROMessage(mapper.writeValueAsBytes(obj), obj.getClass());
            return mapper.writeValueAsBytes(message);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
            throw new RuntimeException("Invalid message type");
        }
    }

    @Override
    public void close() {
        LOGGER.info("Should be doing some deserialized clean up[");
    }
}
