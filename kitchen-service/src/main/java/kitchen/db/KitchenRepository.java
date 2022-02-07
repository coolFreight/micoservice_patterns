package kitchen.db;

import org.jdbi.v3.sqlobject.customizer.BindBean;
import org.jdbi.v3.sqlobject.statement.SqlUpdate;

public interface KitchenRepository {

    @SqlUpdate("insert into ticket (ticket_id, order_id, status) values (:ticketId, :orderId, :status)")
    void persist(@BindBean Ticket ticket);
}
