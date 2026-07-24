package in.ashokit.service;


import in.ashokit.dto.Orderevent;
import org.springframework.stereotype.Service;

@Service
public class Notificationservice {
    private final Javamailservice emailService;

    public Notificationservice(Javamailservice emailService) {
        this.emailService = emailService;
    }

    public void sendOrderPlacedNotification(Orderevent event) {
        String subject = "Order Placed: " + event.getOrderitem();
        String body = "Your order for " + event.getQuantity() + " x " + event.getOrderitem() + " has been placed.";
        emailService.sendEmail("munthasanthoshi@gmail.com", subject, body);
    }
}
