package orders.db;

import io.micronaut.configuration.jdbi.JdbiFactory;
import io.micronaut.context.annotation.Factory;
import jakarta.inject.Singleton;
import org.jdbi.v3.core.Jdbi;
import org.jdbi.v3.postgres.PostgresPlugin;

import javax.inject.Inject;
import javax.sql.DataSource;

@Factory
public class DatabaseJdbiFactory {

    @Inject
    private DataSource postgres;



    @Singleton
    JdbiOrderRepository orderRepository(){
        Jdbi jdbi = new JdbiFactory().jdbi(postgres, null, null, null);
        jdbi.installPlugin(new PostgresPlugin());
        JdbiOrderRepository orderRepository = jdbi.onDemand(JdbiOrderRepository.class);
        return orderRepository;
    }
}
