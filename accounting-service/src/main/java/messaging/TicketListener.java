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
        groupId = "kitchen-ticket-consumer-accounting"
)
public class TicketListener {
    Logger LOGGER = LoggerFactory.getLogger(TicketListener.class);

    @Inject
    private PaymentService paymentService;

    @Topic("kitchen-tickets")
    public void receive(@KafkaKey String key,
                        KitchenTicketCreatedEvent ticket) {

        LOGGER.info("Received a kitchen-ticket {}, kafka-key {}", ticket, key);
        paymentService.pendingAuthorization(new PaymentInfo(ticket.getOrderId(), BigDecimal.valueOf(25), ticket.getOrderId()));
    }
}
