package consumer.db;

import io.micronaut.data.annotation.Id;
import io.micronaut.data.annotation.MappedEntity;

@MappedEntity
public class Consumer {

    @Id
    private String consumerOrderId;

    private boolean consumerVerified;

    private String orderId;

    private String name;

    public Consumer(String consumerOrderId, boolean consumerVerified, String name, String orderId) {
        this.consumerOrderId = consumerOrderId;
        this.consumerVerified = consumerVerified;
        this.name = name;
        this.orderId = orderId;
    }

    public String getConsumerOrderId() {
        return consumerOrderId;
    }

    public boolean isConsumerVerified() {
        return consumerVerified;
    }

    public String getName() {
        return name;
    }

    public String getOrderId() {
        return orderId;
    }
}
