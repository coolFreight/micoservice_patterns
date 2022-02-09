package kitchen.mesages;

public class KitchenTicketCreatedEvent implements JVROMessage{

    private String orderId;

    public KitchenTicketCreatedEvent(String orderId) {
        this.orderId = orderId;
    }


    public String getOrderId() {
        return orderId;
    }
}
