package consumer.service;

import consumer.db.ConsumerRepository;
import consumer.domain.ConsumerDTO;
import jakarta.inject.Singleton;

@Singleton
public class ConsumerService {

    private ConsumerRepository consumerRepository;

    public ConsumerService(ConsumerRepository consumerRepository) {
        this.consumerRepository = consumerRepository;
    }

    public ConsumerDTO verifyConsumer(String name, String orderId) {
        ConsumerDTO consumer = null;
        if (name.contains("XXX")) {
            consumer = new ConsumerDTO(name, false, orderId);
        } else {
            consumer = new ConsumerDTO(name, true, orderId);
        }
        consumerRepository.createConsumerOrder(consumer.isStatus(), consumer.getName(), consumer.getName());
        return consumer;
    }
}
