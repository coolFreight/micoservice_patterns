package consumer.db;

import io.micronaut.core.annotation.NonNull;
import io.micronaut.data.annotation.Id;
import io.micronaut.data.exceptions.DataAccessException;
import io.micronaut.data.jdbc.annotation.JdbcRepository;
import io.micronaut.data.model.query.builder.sql.Dialect;
import io.micronaut.data.repository.PageableRepository;

import javax.transaction.Transactional;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.UUID;

@JdbcRepository(dialect = Dialect.POSTGRES)
public interface ConsumerRepository extends PageableRepository<Consumer, String> {

    Consumer save(@NonNull @NotBlank String consumerOrderId, @NonNull @NotBlank boolean consumerVerified, @NonNull @NotBlank String name, @NonNull @NotBlank String orderId);

    @Transactional
    default Consumer createConsumerOrder(@NonNull @NotBlank boolean consumerVerified, @NonNull @NotBlank String name, @NonNull @NotBlank String orderId) {
       return  save(UUID.randomUUID().toString(), consumerVerified, name, orderId);
    }

    int update(@NonNull @NotNull @Id String consumerOrderId, @NonNull @NotBlank String consumerVerified);
}
