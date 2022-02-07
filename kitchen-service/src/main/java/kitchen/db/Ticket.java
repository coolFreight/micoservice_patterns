package kitchen.db;

public class Ticket {
    private String ticketId;
    private String orderId;
    private String status;

    public Ticket(String ticket_id, String order_id, String status) {
        this.ticketId = ticket_id;
        this.orderId = order_id;
        this.status = status;
    }

    public String getTicketId() {
        return ticketId;
    }

    public String getOrderId() {
        return orderId;
    }

    public String getStatus() {
        return status;
    }
}
