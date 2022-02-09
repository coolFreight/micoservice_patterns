package accounting.messages;

import io.micronaut.data.annotation.MappedEntity;

@MappedEntity
public class OrderItem {

    private String order_id;
    private String id;
    private String name;
    private int quantity;

    public OrderItem(String order_id, String id, String name, int quantity) {
        this.order_id = order_id;
        this.id = id;
        this.name = name;
        this.quantity = quantity;
    }

    public String getOrder_id() {
        return order_id;
    }

    public void setOrder_id(String order_id) {
        this.order_id = order_id;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }




    @Override
    public String toString() {
        return "OrderItem{" +
                "orderId='" + order_id + '\'' +
                ", id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", quantity=" + quantity +
                '}';
    }
}
