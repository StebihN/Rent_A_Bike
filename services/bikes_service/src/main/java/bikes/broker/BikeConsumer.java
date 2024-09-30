package bikes.broker;


import bikes.services.BikeService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.quarkus.runtime.ShutdownEvent;
import io.quarkus.runtime.StartupEvent;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.enterprise.event.Observes;
import jakarta.inject.Inject;

import jakarta.jms.*;


import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;


@ApplicationScoped
public class BikeConsumer implements Runnable {
    @Inject
    ConnectionFactory connectionFactory;

    @Inject
    BikeService bikeService;

    private final ExecutorService scheduler = Executors.newSingleThreadExecutor();


    void onStart(@Observes StartupEvent ev) {
        scheduler.submit(this);
    }

    void onStop(@Observes ShutdownEvent ev){
        scheduler.shutdown();
    }

    @Override
    public void run() {
        try (JMSContext context = connectionFactory.createContext(JMSContext.AUTO_ACKNOWLEDGE)) {
            JMSConsumer consumer = context.createConsumer(context.createQueue("bikes"));
            while (true) {
                Message receivedMessage = consumer.receive();
                if (receivedMessage == null) {
                    return;
                }

                try {
                    ObjectMapper objectMapper = new ObjectMapper();
                    BikeMessage message = objectMapper.readValue(receivedMessage.getBody(String.class), BikeMessage.class);
                    bikeService.changeLocation(message);

                } catch (JsonProcessingException e) {
                    throw new RuntimeException(e);
                }
            }
        } catch (JMSException e) {
            throw new RuntimeException(e);
        }
    }
}

