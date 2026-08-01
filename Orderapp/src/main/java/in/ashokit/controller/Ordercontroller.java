package in.ashokit.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import in.ashokit.entity.Order;
import in.ashokit.service.Orderservice;

@RestController
@RequestMapping("/orders")
public class Ordercontroller {

	
        private final Orderservice orderService;
	    public Ordercontroller(Orderservice orderService) {
	        this.orderService = orderService;
	    }

	    @PostMapping("/createorder")
	    public ResponseEntity<Order> createOrder(@RequestBody Order order) {
	    	
	    	Order odr=orderService.placeOrder(order);
	        return new  ResponseEntity<Order>(odr,HttpStatus.CREATED);
	    }
	    
	    @GetMapping("/admin/getorders")
	    public ResponseEntity<List<Order>> listorders() {
	    	
	    	List<Order> odr=orderService.getallorders();
	        return new  ResponseEntity<List<Order>>(odr,HttpStatus.OK);
	    }
	    
	    @PutMapping("/admin/updateorder")
	    public ResponseEntity<Order> updateOrder(@RequestBody Order order) {
	    	
	    	Order odr=orderService.updateorder(order);
	        return new  ResponseEntity<Order>(odr,HttpStatus.OK);
	    }
	    
	    @GetMapping("/admin/getorder/{id}")
	    public ResponseEntity<Order> getorder(@PathVariable Integer id) {
	    	
	    	Order odr=orderService.getOrder(id);
	        return new  ResponseEntity<Order>(odr,HttpStatus.OK);
	    }
	    
	    
	    @DeleteMapping("/admin/deleteorder/{id}")
	    public String  deleteOrder(@PathVariable Integer id) {
	    	
	    	String odr=orderService.deleteorder(id);
	        return new  String(odr);
	    }
	    
	    
	}



