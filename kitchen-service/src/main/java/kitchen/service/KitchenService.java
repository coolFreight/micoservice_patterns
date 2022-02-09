package kitchen.service;


import kitchen.db.KitchenRepository;
import kitchen.db.Ticket;
import kitchen.domain.KitchenTicket;
import kitchen.mesages.KitchenTicketCreatedEvent;
import kitchen.messaging.KitchenTicketPublisher;
import org.slf4j.LoggerFactory;

import javax.inject.Inject;
import javax.inject.Singleton;
import javax.transaction.Transactional;
import java.util.UUID;

@Singleton
public class KitchenService {
    private static final org.slf4j.Logger LOGGER = LoggerFactory.getLogger(KitchenService.class);

    @Inject
    private KitchenRepository kitchenRepository;

    @Inject
    private KitchenTicketPublisher ticketPublisher;

    @Transactional
    public void createTicket(KitchenTicket ticket) {
        LOGGER.info("Creating ticket for {}", ticket);
        kitchenRepository.persist(new Ticket(UUID.randomUUID().toString(), ticket.getOrderId(), "CREATE_PENDING"));
        ticketPublisher.publishOrder(ticket.getOrderId(), new KitchenTicketCreatedEvent(ticket.getOrderId()));
    }
}
