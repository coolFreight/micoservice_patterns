package orders.service;


import orders.api.OrderRequest;
import orders.api.FoodOrder;
import orders.db.JdbiOrderRepository;
import orders.api.OrderItem;
import messaging.FoodOrderMessage;
import messaging.OrderItemMessage;
import messaging.OrderPublisher;
import org.slf4j.LoggerFactory;

import javax.inject.Inject;
import javax.inject.Singleton;
import javax.transaction.Transactional;
import java.util.UUID;
import java.util.stream.Collectors;

@Singleton
public class OrderService {
    private static final org.slf4j.Logger LOGGER = LoggerFactory.getLogger(OrderService.class);

    @Inject
    private JdbiOrderRepository orderRepository;

    private final OrderPublisher orderPublisher;

    public OrderService(OrderPublisher orderPublisher) {
        this.orderPublisher = orderPublisher;
    }

    @Transactional
    public FoodOrder createOrder(OrderRequest foodOrderRequest) {
        LOGGER.info("Creating a new order {} ", foodOrderRequest);
        var orderId = UUID.randomUUID().toString();
        var foodOrder = orderRepository.persistOrder(foodOrderRequest.getCustomerId(), foodOrderRequest
                .getOrderItems()
                .stream()
                .map(orderItemRequest -> new OrderItem(orderId, orderItemRequest.getId(), orderItemRequest.getName(), orderItemRequest.getQuantity())).collect(Collectors.toList()));

        orderPublisher.publishOrder(foodOrder.getOrderId(), new FoodOrderMessage(foodOrder.getStatus(), foodOrder.getOrderId(), foodOrder.getName(), foodOrderRequest
                .getOrderItems()
                .stream()
                .map(oir -> new OrderItemMessage(orderId, oir.getId(), oir.getName(), oir.getQuantity()))
                .collect(Collectors.toList())));
        return foodOrder;
    }
}
