package in.ashokit;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

@SpringBootApplication
public class AutowiringappApplication {

	public static void main(String[] args) {
		
		ApplicationContext ctxt = new AnnotationConfigApplicationContext(Appconfig.class);
		
		Shippingcart sc=ctxt.getBean(Shippingcart.class);
		
		sc.placeorder();
	}

}
