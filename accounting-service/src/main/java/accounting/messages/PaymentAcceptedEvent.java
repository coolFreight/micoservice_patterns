package accounting.messages;

public class PaymentAcceptedEvent {

    private String consumerId;
    private String orderId;

    public PaymentAcceptedEvent(String consumerId, String orderId) {
        this.consumerId = consumerId;
        this.orderId = orderId;
    }

    public String getConsumerId() {
        return consumerId;
    }

    public String getOrderId() {
        return orderId;
    }
}
