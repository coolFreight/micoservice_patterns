package accounting.mesaging;

import accounting.avro.FoodOrder;
import accounting.domain.PaymentInfo;
import accounting.service.PaymentService;
import io.micronaut.configuration.kafka.annotation.KafkaClient;
import io.micronaut.configuration.kafka.annotation.KafkaKey;
import io.micronaut.configuration.kafka.annotation.KafkaListener;
import io.micronaut.configuration.kafka.annotation.Topic;
import io.micronaut.context.annotation.Property;
import io.micronaut.data.repository.PageableRepository;
import jakarta.inject.Inject;
import org.apache.kafka.clients.producer.ProducerConfig;
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
                        FoodOrder order) {

        LOGGER.info("Received an order {}, kafka-key {}", order, key);
        paymentService.pendingAuthorization(new PaymentInfo(order.getName(), BigDecimal.valueOf(25), order.getOrderId()));
    }
}
