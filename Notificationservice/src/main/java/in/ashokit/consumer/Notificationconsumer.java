package in.ashokit.consumer;

import com.fasterxml.jackson.databind.ObjectMapper;
import in.ashokit.dto.Orderevent;
import in.ashokit.service.Notificationservice;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class Notificationconsumer {
    private final Notificationservice notificationService;
    private final ObjectMapper objectMapper = new ObjectMapper();

    public Notificationconsumer(Notificationservice notificationService) {
        this.notificationService = notificationService;
    }

    @KafkaListener(topics = "order-events", groupId = "notification-service-group")
    public void consume(String message) {
        try {
            Orderevent event = objectMapper.readValue(message, Orderevent.class);
            notificationService.sendOrderPlacedNotification(event);
            System.out.println("Notification sent for item: " + event.getOrderitem());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

