package in.ashokit;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;


public class InjectionexampleApplication {

	public static void main(String[] args) {
		
		ApplicationContext ctxt= new AnnotationConfigApplicationContext(Appconfig.class);
		
       Car car=ctxt.getBean(Car.class);
       
       car.drive();
	}

}
