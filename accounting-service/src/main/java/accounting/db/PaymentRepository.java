package accounting.db;

import io.micronaut.core.annotation.NonNull;
import io.micronaut.data.annotation.Id;
import io.micronaut.data.jdbc.annotation.JdbcRepository;
import io.micronaut.data.model.query.builder.sql.Dialect;
import io.micronaut.data.repository.PageableRepository;

import javax.validation.constraints.NotBlank;

@JdbcRepository(dialect = Dialect.POSTGRES)
public interface PaymentRepository extends PageableRepository<Payment, String> {

    Payment save(@NonNull @NotBlank String consumerId, @NonNull @NotBlank String cardStatus, @NonNull @NotBlank String orderId);

    default Payment createOrderPayment(@NonNull @NotBlank String consumerId, @NonNull @NotBlank String cardStatus, @NonNull @NotBlank String orderId) {
       return  save(consumerId, cardStatus, orderId);
    }

    int update(@NonNull @NotBlank @Id String orderId, @NonNull @NotBlank String cardStatus);
}
