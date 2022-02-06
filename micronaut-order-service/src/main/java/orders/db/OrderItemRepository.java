package orders.db;

import io.micronaut.core.annotation.NonNull;
import io.micronaut.data.annotation.Id;

import javax.transaction.Transactional;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;


public interface OrderItemRepository{

    OrderItem save(@NonNull @NotBlank String orderId, @NonNull @NotBlank String id,
                   @NonNull @NotBlank String name, int quantity);

    @Transactional
    default OrderItem createOrder(@NonNull @NotBlank OrderItem item) {
       return save(item.getOrder_id(), item.getId(), item.getName(), item.getQuantity());
    }

    int update(@NonNull @NotNull @Id String id, @NonNull @NotBlank String name, int quantity);
}
