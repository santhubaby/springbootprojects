package in.ashokit;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import in.ashokit.config.Appconfig;
import in.ashokit.service.Userservice;


public class AutowiringexampleApplication {

	public static void main(String[] args) {
		// Starting IOC Container
				ApplicationContext ctxt = new AnnotationConfigApplicationContext(Appconfig.class);

				// get bean obj from ioc
				Userservice bean = ctxt.getBean(Userservice.class);

				// call bean method
				bean.printName();

	}

}
