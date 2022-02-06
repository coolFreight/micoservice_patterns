package orders.messaging;

import io.micronaut.configuration.kafka.annotation.KafkaClient;
import io.micronaut.configuration.kafka.annotation.KafkaKey;
import io.micronaut.configuration.kafka.annotation.Topic;
import orders.api.FoodOrder;

@KafkaClient
public interface OrderPublisher {

    @Topic("orders")
    void publishOrder(@KafkaKey String orderId, FoodOrder order);
}
