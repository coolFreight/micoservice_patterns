package orders.app;

import io.micronaut.context.event.ApplicationEventListener;
import io.micronaut.context.event.StartupEvent;

public class OrderServiceStartup  implements ApplicationEventListener<StartupEvent> {


    @Override
    public void onApplicationEvent(StartupEvent event) {




        System.out.println("Startup was done");
    }
}
