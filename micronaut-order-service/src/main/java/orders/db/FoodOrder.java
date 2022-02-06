package orders.db;

import io.micronaut.data.annotation.Id;
import io.micronaut.data.annotation.MappedEntity;
import io.micronaut.data.annotation.Relation;

import java.util.List;
import java.util.Objects;

@MappedEntity
public class FoodOrder {

    @Id
    private String orderId;

    private String status;

    private String name;

    @Relation(value = Relation.Kind.ONE_TO_MANY, cascade = Relation.Cascade.PERSIST, mappedBy = "foodOrder")
    private List<OrderItem> orderItems;

    public FoodOrder(String status, String orderId, String name, List<OrderItem> orderItems) {
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

    public List<OrderItem> getOrderItems() {
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
        FoodOrder foodOrder = (FoodOrder) o;
//        JdbiFactory f = new JdbiFactory();

        return Objects.equals(orderId, foodOrder.orderId) && Objects.equals(status, foodOrder.status) && Objects.equals(name, foodOrder.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(orderId, status, name);
    }



}
