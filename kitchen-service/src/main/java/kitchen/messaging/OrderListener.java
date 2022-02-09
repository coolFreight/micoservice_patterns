package kitchen.messaging;

import io.micronaut.configuration.kafka.annotation.KafkaKey;
import io.micronaut.configuration.kafka.annotation.KafkaListener;
import io.micronaut.configuration.kafka.annotation.Topic;
import kitchen.mesages.FoodOrder;
import kitchen.domain.KitchenTicket;
import kitchen.service.KitchenService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@KafkaListener(
        groupId = "kitchen-orders"
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
        LOGGER.info("Received an order for : {} ", order);
        kitchenService.createTicket(new KitchenTicket(order.getOrderId()));
    }

}
