package orders;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;
import orders.api.OrderItemRequest;

import java.io.IOException;


public class OrderItemDeserializer extends StdDeserializer<OrderItemRequest> {

    public OrderItemDeserializer() {
        this(null);
    }

    public OrderItemDeserializer(Class<OrderItemRequest> t) {
        super(t);
    }

    @Override
    public OrderItemRequest deserialize(JsonParser jp, DeserializationContext ctxt) throws IOException {
        return jp.getCodec().readValue(jp, OrderItemRequest.class);
    }
}
