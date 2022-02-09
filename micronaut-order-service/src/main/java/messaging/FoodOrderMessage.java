package messaging;

import java.util.List;
import java.util.Objects;

public class FoodOrderMessage implements JVROMessageType {

    private String orderId;

    private String status;

    private String name;

    private List<OrderItemMessage> orderItems;

    public FoodOrderMessage(String status, String orderId, String name, List<OrderItemMessage> orderItems) {
        this.status = status;
        this.orderId = orderId;
        this.name = name;
        this.orderItems = orderItems;
    }

    public String getStatus() {
        return status;
    }

    public String getOrderId() {
        return orderId;
    }

    public String getName() {
        return name;
    }

    public List<OrderItemMessage> getOrderItems() {
        return orderItems;
    }

    @Override
    public String toString() {
        return "Order{" +
                "status='" + status + '\'' +
                ", orderId='" + orderId + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        FoodOrderMessage foodOrder = (FoodOrderMessage) o;
        return Objects.equals(orderId, foodOrder.orderId) && Objects.equals(status, foodOrder.status) && Objects.equals(name, foodOrder.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(orderId, status, name);
    }



}
