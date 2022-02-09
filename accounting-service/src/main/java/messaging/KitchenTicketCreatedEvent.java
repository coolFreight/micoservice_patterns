package messaging;

public class KitchenTicketCreatedEvent {

    private String orderId;

    public KitchenTicketCreatedEvent(String orderId) {
        this.orderId = orderId;
    }


    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }
}
