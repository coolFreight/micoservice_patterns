package messaging;

import accounting.domain.PaymentInfo;
import accounting.service.PaymentService;
import io.micronaut.configuration.kafka.annotation.KafkaKey;
import io.micronaut.configuration.kafka.annotation.KafkaListener;
import io.micronaut.configuration.kafka.annotation.Topic;
import jakarta.inject.Inject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.math.BigDecimal;


@KafkaListener(
        groupId = "accounting-orders"
)
public class OrderListener {
    Logger LOGGER = LoggerFactory.getLogger(OrderListener.class);

    @Inject
    private PaymentService paymentService;

    @Topic("orders")
    public void receive(@KafkaKey String key,
                        FoodOrderMessage order) {

        LOGGER.info("Received an order {}, kafka-key {}", order, key);
        paymentService.pendingAuthorization(new PaymentInfo(order.getName(), BigDecimal.valueOf(25), order.getOrderId()));
    }
}
