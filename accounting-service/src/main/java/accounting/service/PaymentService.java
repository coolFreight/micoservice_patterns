package accounting.service;

import accounting.avro.PaymentAcceptedEvent;
import accounting.avro.PaymentPendingAuthorizationEvent;
import accounting.db.PaymentRepository;
import accounting.domain.PaymentInfo;
import accounting.mesaging.PaymentEventPublisher;
import jakarta.inject.Inject;
import jakarta.inject.Singleton;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.transaction.Transactional;

@Singleton
public class PaymentService {

    Logger LOGGER = LoggerFactory.getLogger(PaymentService.class);

    @Inject
    private PaymentEventPublisher paymentStatusPublisher;

    @Inject
    private PaymentRepository paymentRepository;

    @Transactional
    public void pendingAuthorization(PaymentInfo paymentInfo) {

        ///Here an external call to a payment service to verify funds
        ///Design asynchronous approach that will allow the client to return a response within 4 hour max time
        LOGGER.info("Authorizing payment for order {}", paymentInfo.getOrderId());
        paymentRepository.createOrderPayment(paymentInfo.getConsumerId(), "PENDING_AUTHORIZATION", paymentInfo.getOrderId());
        paymentStatusPublisher.publishPaymentEvent(new PaymentPendingAuthorizationEvent(paymentInfo.getConsumerId(), paymentInfo.getOrderId()));
    }


    public void authorizeClientCard(PaymentInfo paymentInfo) {
         LOGGER.info("Consumer {} payment has been accepted.", paymentInfo.getConsumerId());
         paymentStatusPublisher.publishPaymentEvent(new PaymentAcceptedEvent(paymentInfo.getConsumerId(), paymentInfo.getOrderId()));
    }
}
