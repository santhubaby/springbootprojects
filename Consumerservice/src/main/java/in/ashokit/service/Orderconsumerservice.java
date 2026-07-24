package in.ashokit.service;
import com.fasterxml.jackson.databind.ObjectMapper;

import in.ashokit.dto.Orderevent;
import in.ashokit.entity.Consumerorder;
import in.ashokit.repo.Consumerrepo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class Orderconsumerservice {
	

	    @Autowired
	    private Consumerrepo consumerOrderRepository;

	    @KafkaListener(topics = "order-events", groupId = "order-consumer-group")
	    public void consumeOrderEvent(String message)
	    /***message=jsonstring{
	    "orderitem": "Laptop",
	    "quantity": 2
	  }***/
	    

	    {
	        try 
	        {
	            ObjectMapper mapper = new ObjectMapper();
	            Orderevent event = mapper.readValue(message, Orderevent.class);

	            System.out.println("Consumed event: Product=" 
	                + event.getOrderitem() + ", Quantity=" + event.getQuantity());

	            Optional<Consumerorder> optionalOrder = consumerOrderRepository.findByOrderitem(event.getOrderitem());

	            if (optionalOrder.isPresent()) {
	                Consumerorder consumerOrder = optionalOrder.get();
	                consumerOrder.setTotalOrders(consumerOrder.getTotalOrders() + event.getQuantity());
	                consumerOrderRepository.save(consumerOrder);
	            } else {
	                Consumerorder newOrder = new Consumerorder();
	                newOrder.setOrderitem(event.getOrderitem());
	                newOrder.setTotalOrders(event.getQuantity());
	                consumerOrderRepository.save(newOrder);
	            }

	        } 
	        
	        catch (Exception e) {
	            e.printStackTrace();
	        }
	  
	    }
	    
	}




