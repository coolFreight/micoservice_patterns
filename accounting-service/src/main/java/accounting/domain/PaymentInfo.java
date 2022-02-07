package accounting.domain;

import java.math.BigDecimal;

public class PaymentInfo {
    private String consumerId;
    private BigDecimal cost;
    private String orderId;

    public PaymentInfo(String consumerId, BigDecimal cost, String orderId) {
        this.consumerId = consumerId;
        this.cost = cost;
        this.orderId = orderId;
    }

    public String getOrderId() {
        return orderId;
    }

    public BigDecimal getCost() {
        return cost;
    }

    public String getConsumerId() {
        return consumerId;
    }
}
