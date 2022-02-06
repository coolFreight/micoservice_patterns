package consumer.avro;

public class ConsumerVerified {

    private boolean verified;

    private String consumerName;

    public ConsumerVerified(boolean verified, String consumerName) {
        this.verified = verified;
        this.consumerName = consumerName;
    }

    public boolean isVerified() {
        return verified;
    }

    public String getConsumerName() {
        return consumerName;
    }
}
