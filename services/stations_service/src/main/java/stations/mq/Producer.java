package stations.mq;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.jms.annotation.EnableJms;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Component;

@Component
@EnableJms
public class Producer {

    @Autowired
    JmsTemplate jmsTemplate;

    @Value("bikes")
    String queue;

    public void sendMessage(BikeMessage msg){
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            String bikeJson = objectMapper.writeValueAsString(msg);
            jmsTemplate.convertAndSend(queue, bikeJson);
        }catch (JsonProcessingException e) {
        }
    }
}
