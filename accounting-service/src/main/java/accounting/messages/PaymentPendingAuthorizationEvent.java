package accounting.messages;

import messaging.JVROMessageType;

public class PaymentPendingAuthorizationEvent implements JVROMessageType {

    private String consumerId;
    private String orderId;

    public PaymentPendingAuthorizationEvent(String consumerId, String orderId) {
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
