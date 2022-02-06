package orders.messaging;

import io.micronaut.context.annotation.Property;
import jakarta.annotation.PostConstruct;
import orders.db.FoodOrder;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.Producer;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.clients.producer.RecordMetadata;
import org.slf4j.LoggerFactory;

import javax.inject.Singleton;
import java.io.IOException;
import java.util.Map;
import java.util.concurrent.Future;

@Singleton
public class OrderServicePublisher {
    private static final org.slf4j.Logger LOGGER = LoggerFactory.getLogger(OrderServicePublisher.class);

    private Producer p;
    private final static String ORDERS_TOPIC = "orders";

    @Property(name = "kafka-producer")
    Map<String, String> kafkaProperties;

    @PostConstruct
    public void init() throws IOException {
        LOGGER.info("properties are {} ", kafkaProperties);
        p = new KafkaProducer(kafkaProperties);
    }

    public Future<RecordMetadata> publishOrderEvent(FoodOrder order) {
        LOGGER.info("Published order event of for order {} ", order.getOrderId());
        return p.send(new ProducerRecord<>(ORDERS_TOPIC, order.getOrderId() + "", order));
    }
}


