package kitchen.messaging;

import io.micronaut.configuration.kafka.annotation.KafkaClient;
import io.micronaut.configuration.kafka.annotation.KafkaKey;
import io.micronaut.configuration.kafka.annotation.Topic;


@KafkaClient
public interface KitchenTicketPublisher {

    @Topic("kitchen-tickets")
    <T> void publishOrder(@KafkaKey String orderId, T ticketEvent);
}
