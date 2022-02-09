package messaging;

import io.micronaut.configuration.kafka.annotation.KafkaClient;
import io.micronaut.configuration.kafka.annotation.KafkaKey;
import io.micronaut.configuration.kafka.annotation.Topic;

@KafkaClient
public interface OrderPublisher {

    @Topic("orders")
    void publishOrder(@KafkaKey String orderId, FoodOrderMessage order);
}
