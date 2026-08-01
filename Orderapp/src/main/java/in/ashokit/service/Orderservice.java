package in.ashokit.service;

import java.util.List;

import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import in.ashokit.dto.Orderevent;
import in.ashokit.entity.Order;
import in.ashokit.repo.Orderrepo;

@Service
public class Orderservice {

	

	    private final Orderrepo orderRepository;
	    private final KafkaTemplate<String, Object> kafkaTemplate;

	    public Orderservice(Orderrepo orderRepository, KafkaTemplate<String, Object> kafkaTemplate) {
	        this.orderRepository = orderRepository;
	        this.kafkaTemplate = kafkaTemplate;
	    }

	    public Order placeOrder(Order order) {
	        Order savedOrder = orderRepository.save(order);
	        
	     // Map entity → DTO
	        Orderevent event = new Orderevent();
	        event.setOrderitem(savedOrder.getOrderitem());
	        event.setQuantity(savedOrder.getQuantity());

	        // Publish DTO instead of entity
	        kafkaTemplate.send("order-events", event);  // publish event
	        return savedOrder;
	    }
	    
	    public List<Order>  getallorders() {
	        List<Order> orders = orderRepository.findAll();
	         
	        return orders;
	    }
	    
	    public Order getOrder(Integer id) {
	        
	        
	        return orderRepository.findById(id)
	        	    .orElseThrow(() -> new RuntimeException("Order not found"));

	    }
	    
	    public Order updateorder(Order order) {
	        Order getorder = orderRepository.save(order);
	        return getorder;
	    }
	    
	    public String deleteorder(Integer id) {
	        orderRepository.deleteById(id);
	       // kafkaTemplate.send("order-events", savedOrder); // publish event
	        return "order deleted";
	    }
	}


