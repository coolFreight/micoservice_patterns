package accounting.db;


import io.micronaut.data.annotation.Id;
import io.micronaut.data.annotation.MappedEntity;

@MappedEntity
public class Payment {

    private String consumerId;
    private String cardStatus;

    @Id
    private String orderId;

    public Payment(String consumerId, String cardStatus, String orderId) {
        this.consumerId = consumerId;
        this.cardStatus = cardStatus;
        this.orderId = orderId;
    }


    public String getConsumerId() {
        return consumerId;
    }

    public String getCardStatus() {
        return cardStatus;
    }

    public String getOrderId() {
        return orderId;
    }
}
