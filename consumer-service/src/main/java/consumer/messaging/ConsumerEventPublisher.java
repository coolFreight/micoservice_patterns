package consumer.messaging;

import consumer.avro.ConsumerVerified;
import io.micronaut.configuration.kafka.annotation.KafkaClient;
import io.micronaut.configuration.kafka.annotation.KafkaKey;
import io.micronaut.configuration.kafka.annotation.Topic;

@KafkaClient
public interface ConsumerEventPublisher {

    @Topic("orders")
    void publishOrder(@KafkaKey String orderId, ConsumerVerified order);
}
