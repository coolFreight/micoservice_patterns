package orders.app;

import io.micronaut.configuration.jdbi.JdbiFactory;
import io.micronaut.context.event.ApplicationEventListener;
import io.micronaut.context.event.StartupEvent;
import org.jdbi.v3.core.Jdbi;

import javax.inject.Inject;
import javax.sql.DataSource;

public class OrderServiceStartup  implements ApplicationEventListener<StartupEvent> {


    @Override
    public void onApplicationEvent(StartupEvent event) {




        System.out.println("Startup was done");
    }
}
