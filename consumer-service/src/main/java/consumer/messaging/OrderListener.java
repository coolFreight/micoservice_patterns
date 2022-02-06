package consumer.messaging;

import consumer.avro.FoodOrder;
import consumer.service.ConsumerService;
import io.micronaut.configuration.kafka.annotation.KafkaKey;
import io.micronaut.configuration.kafka.annotation.KafkaListener;
import io.micronaut.configuration.kafka.annotation.Topic;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


@KafkaListener(
        groupId = "consumer-orders"
)
public class OrderListener {
    Logger LOGGER = LoggerFactory.getLogger(OrderListener.class);

    private final ConsumerService consumerService;

    public OrderListener(ConsumerService consumerService) {
        this.consumerService = consumerService;
    }

    @Topic("orders")
    public void receive(@KafkaKey String key,
                        FoodOrder order) {
        LOGGER.info("Consumer verified: {} ", consumerService.verifyConsumer(order.getName(), order.getOrderId()));
    }
}
