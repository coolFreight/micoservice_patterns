package consumer.avro;

import io.micronaut.data.annotation.Id;
import io.micronaut.data.annotation.MappedEntity;

import java.util.Objects;

@MappedEntity
public class FoodOrder {

    @Id
    private String orderId;

    private String status;

    private String name;

    public FoodOrder(String status, String orderId, String name) {
        this.status = status;
        this.orderId = orderId;
        this.name = name;
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
        FoodOrder foodOrder = (FoodOrder) o;
        return Objects.equals(orderId, foodOrder.orderId) && Objects.equals(status, foodOrder.status) && Objects.equals(name, foodOrder.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(orderId, status, name);
    }
}
