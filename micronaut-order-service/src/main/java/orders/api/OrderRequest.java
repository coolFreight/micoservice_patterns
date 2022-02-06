package orders.api;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import orders.OrderItemDeserializer;

import java.util.ArrayList;
import java.util.List;

public class OrderRequest {
    private String customerId;

    @JsonDeserialize(contentUsing = OrderItemDeserializer.class)
    private List<OrderItemRequest> orderItems = new ArrayList<>();

    public OrderRequest(){}

    public OrderRequest(String customerId, List<OrderItemRequest> orderItems) {
        this.customerId = customerId;
        this.orderItems = orderItems;
    }

    public OrderRequest(String customerId) {
        this.customerId = customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }


    public String getCustomerId() {
        return customerId;
    }

    public List<OrderItemRequest> getOrderItems() {
        return orderItems;
    }

    @Override
    public String toString() {
        return "OrderRequest{" +
                "customerId='" + customerId + '\'' +
                ", orderItems=" + orderItems +
                '}';
    }
}
