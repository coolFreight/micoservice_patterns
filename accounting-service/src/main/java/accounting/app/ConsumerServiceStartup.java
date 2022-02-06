package accounting.app;

import io.micronaut.context.event.ApplicationEventListener;
import io.micronaut.context.event.StartupEvent;
import org.flywaydb.core.Flyway;

public class ConsumerServiceStartup implements ApplicationEventListener<StartupEvent> {

    @Override
    public void onApplicationEvent(StartupEvent event) {
        Flyway flyway = Flyway.configure().dataSource("jdbc:postgresql://localhost:6003/consumer_service", "postgres", "mysecretpassword").load();
        flyway.migrate();


        System.out.println("Startup was done");
    }
}
