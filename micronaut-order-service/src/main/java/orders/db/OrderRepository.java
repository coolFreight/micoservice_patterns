package orders.db;

import io.micronaut.core.annotation.NonNull;
import io.micronaut.data.annotation.Id;
import io.micronaut.data.jdbc.annotation.JdbcRepository;
import io.micronaut.data.model.query.builder.sql.Dialect;
import io.micronaut.data.repository.PageableRepository;
import orders.api.FoodOrder;
import orders.api.OrderItem;
import orders.api.OrderRequest;

import javax.transaction.Transactional;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.List;


@JdbcRepository(dialect = Dialect.POSTGRES)
public interface OrderRepository extends PageableRepository<FoodOrder, String> {

    FoodOrder save(@NonNull @NotBlank String orderId, @NonNull @NotBlank String status,
                   @NonNull @NotBlank String name, @NonNull List<OrderItem> orderItems);

    @Transactional
    default FoodOrder createOrder(@NonNull @NotBlank OrderRequest orderRequest) {
//        var orderId = UUID.randomUUID().toString();
//       return save(orderId, "PENDING", orderRequest.getCustomerId(), orderRequest
//               .getOrderItems()
//               .stream()
//               .map(oi -> new OrderItem(orderId, oi.getId(), oi.getName(), oi.getQuantity())).collect(Collectors.toList()));
        return null;
    }

    int update(@NonNull @NotNull @Id String orderId, @NonNull @NotBlank String status, @NonNull @NotBlank String name);
}
