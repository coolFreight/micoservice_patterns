package orders.resource;

import io.micronaut.data.exceptions.DataAccessException;
import io.micronaut.http.HttpResponse;
import io.micronaut.http.MediaType;
import io.micronaut.http.annotation.Body;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Post;
import io.micronaut.scheduling.TaskExecutors;
import io.micronaut.scheduling.annotation.ExecuteOn;
import orders.api.OrderRequest;
import orders.db.FoodOrder;
import orders.service.OrderService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.net.URI;

@ExecuteOn(TaskExecutors.IO)
@Controller("/order")
public class OrderController {
    Logger logger = LoggerFactory.getLogger(OrderController.class);

    private final OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @Post(value = "/create")
    public HttpResponse<FoodOrder> createOrder(@Body OrderRequest order) {
        logger.info("Request to create a new order {}", order);
        try {
            var foodOrder = orderService.createOrder(order);
            return HttpResponse
                    .created(foodOrder)
                    .headers(headers -> headers.location(location(foodOrder.getOrderId())));
        } catch (DataAccessException dae) {
            logger.error("Error creating order ", dae);
            return HttpResponse.serverError();
        }
    }

    protected URI location(String id) {
        return URI.create("/order/" + id);
    }

    protected URI location(FoodOrder order) {
        return location(order.getOrderId());
    }
}
