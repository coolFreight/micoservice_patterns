package kitchen.messaging;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import kitchen.mesages.JVROMessage;
import org.apache.kafka.common.header.Headers;
import org.apache.kafka.common.serialization.Deserializer;
import org.apache.kafka.common.serialization.Serializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Map;

public class TicketEventSerializer implements Serializer<JVROMessage>, Deserializer<JVROMessage> {
    private static final Logger LOGGER = LoggerFactory.getLogger(TicketEventSerializer.class);

    private ObjectMapper mapper =  new ObjectMapper();

    @Override
    public JVROMessage deserialize(String topic, byte[] data) {
        return null;
    }

    @Override
    public void configure(Map<String, ?> configs, boolean isKey) {

    }

    @Override
    public byte[] serialize(String topic, JVROMessage event) {
        try {
            return mapper.writeValueAsBytes(event);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
            return new byte[0];
        }
    }

    @Override
    public byte[] serialize(String topic, Headers headers, JVROMessage data) {
        return Serializer.super.serialize(topic, headers, data);
    }


    @Override
    public void close() {
        LOGGER.info("Should be doing some deserialized clean up[");
    }
}
