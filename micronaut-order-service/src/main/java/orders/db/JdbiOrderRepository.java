package orders.db;

import org.jdbi.v3.sqlobject.customizer.BindBean;
import org.jdbi.v3.sqlobject.statement.SqlUpdate;
import org.jdbi.v3.sqlobject.transaction.Transaction;

import java.util.List;
import java.util.UUID;

public interface JdbiOrderRepository {


    @SqlUpdate("insert into food_order (order_id, status, name) values (:order_id, :status, :name)")
    void insertOrder(String order_id, String status, String name);

    @SqlUpdate("insert into order_item (id, name, quantity, order_id) values (:id, :name, :quantity, :order_id)")
    void insertOrderItems(@BindBean OrderItem orderItem);

    @Transaction
    default FoodOrder persistOrder(String name, List<OrderItem> orderItems) {
        var orderId = UUID.randomUUID().toString();
        insertOrder(orderId, "PENDING", name);
        orderItems.stream()
                .forEach( orderItem -> insertOrderItems(orderItem));
        return  new FoodOrder("PENDING", orderId, name, orderItems);
    }
}
