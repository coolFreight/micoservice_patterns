package kitchen.db;

import io.micronaut.configuration.jdbi.JdbiFactory;
import io.micronaut.context.annotation.Factory;
import jakarta.inject.Inject;
import jakarta.inject.Singleton;
import org.jdbi.v3.core.Jdbi;
import org.jdbi.v3.postgres.PostgresPlugin;

import javax.sql.DataSource;

@Factory
public class DatabaseJdbiFactory {

    @Inject
    private DataSource postgres;

    @Singleton
    KitchenRepository kitchenRepository(){
        Jdbi jdbi = new JdbiFactory().jdbi(postgres, null, null, null);
        jdbi.installPlugin(new PostgresPlugin());
        KitchenRepository kitchenRepository = jdbi.onDemand(KitchenRepository.class);
        return kitchenRepository;
    }
}
