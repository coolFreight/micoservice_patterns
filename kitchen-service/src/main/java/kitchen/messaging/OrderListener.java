package kitchen.messaging;

import io.micronaut.configuration.kafka.annotation.KafkaClient;
import io.micronaut.configuration.kafka.annotation.KafkaKey;
import io.micronaut.configuration.kafka.annotation.KafkaListener;
import io.micronaut.configuration.kafka.annotation.Topic;
import kitchen.avro.FoodOrder;
import kitchen.service.KitchenService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@KafkaListener(
        groupId = "consumer-orders"
)
public class OrderListener {
    Logger LOGGER = LoggerFactory.getLogger(OrderListener.class);

    private KitchenService kitchenService;

    public OrderListener(KitchenService kitchenService) {
        this.kitchenService = kitchenService;
    }


    @Topic("orders")
    public void receive(@KafkaKey String key,
                        FoodOrder order) {
//        LOGGER.info("Consumer verified: {} ", KitchenService.validateOrder();
    }

}
