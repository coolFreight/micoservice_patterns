package accounting.mesaging;

import accounting.avro.PaymentPendingAuthorizationEvent;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.kafka.common.serialization.Deserializer;
import org.apache.kafka.common.serialization.Serializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Map;

public class PaymentPendingSerializer implements Serializer<PaymentPendingAuthorizationEvent>, Deserializer<PaymentPendingAuthorizationEvent> {
    private static final Logger LOGGER = LoggerFactory.getLogger(PaymentPendingSerializer.class);

    private ObjectMapper mapper =  new ObjectMapper();

    @Override
    public PaymentPendingAuthorizationEvent deserialize(String topic, byte[] data) {
        return null;
    }

    @Override
    public void configure(Map<String, ?> configs, boolean isKey) {

    }

    @Override
    public byte[] serialize(String topic, PaymentPendingAuthorizationEvent order) {
        try {
            return mapper.writeValueAsBytes(order);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
            return new byte[0];
        }
    }

    @Override
    public void close() {
        LOGGER.info("Should be doing some deserialized clean up[");
    }
}
