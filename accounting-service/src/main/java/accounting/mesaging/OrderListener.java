package accounting.mesaging;

import accounting.avro.FoodOrder;
import io.micronaut.configuration.kafka.annotation.KafkaClient;
import io.micronaut.configuration.kafka.annotation.KafkaKey;
import io.micronaut.configuration.kafka.annotation.KafkaListener;
import io.micronaut.configuration.kafka.annotation.Topic;
import io.micronaut.context.annotation.Property;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


@KafkaListener(
        groupId = "kitchen-orders"
)
public class OrderListener {
    Logger LOGGER = LoggerFactory.getLogger(OrderListener.class);

    @Topic("orders")
    public void receive(@KafkaKey String key,
                        FoodOrder order) {

        LOGGER.info("Received an order {}, kafka-key {}", order, key);
    }
}
