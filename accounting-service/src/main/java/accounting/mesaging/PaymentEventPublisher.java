package accounting.mesaging;

import accounting.avro.PaymentAcceptedEvent;
import accounting.avro.PaymentDeniedEvent;
import accounting.avro.PaymentPendingAuthorizationEvent;
import io.micronaut.configuration.kafka.annotation.KafkaClient;
import io.micronaut.configuration.kafka.annotation.Topic;

@KafkaClient
public interface PaymentEventPublisher {

    @Topic("payments")
    void publishPaymentEvent(PaymentAcceptedEvent event);

    @Topic("payments")
    void publishPaymentEvent(PaymentDeniedEvent event);

    @Topic("payment")
    void publishPaymentEvent(PaymentPendingAuthorizationEvent event);
}
