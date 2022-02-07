package kitchen.domain;

public class KitchenTicket {

    private String orderId;

    public KitchenTicket(String orderId) {
        this.orderId = orderId;
    }

    public String getOrderId() {
        return orderId;
    }

    @Override
    public String toString() {
        return "KitchenTicket{" +
                "orderId='" + orderId + '\'' +
                '}';
    }
}
