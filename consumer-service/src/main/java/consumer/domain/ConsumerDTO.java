package consumer.domain;

import java.util.Objects;

public class ConsumerDTO {

    private String name;

    private boolean status;

    private String orderId;

    public ConsumerDTO(String name, boolean status, String orderId) {
        this.name = name;
        this.status = status;
        this.orderId = orderId;
    }


    public String getName() {
        return name;
    }

    public boolean isStatus() {
        return status;
    }

    public String getOrderId() {
        return orderId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ConsumerDTO consumer = (ConsumerDTO) o;
        return status == consumer.status && Objects.equals(name, consumer.name) && Objects.equals(orderId, consumer.orderId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, status, orderId);
    }
}
