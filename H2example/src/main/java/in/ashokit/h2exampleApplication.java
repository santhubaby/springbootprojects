package in.ashokit;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import in.ashokit.service.Productservice;

@SpringBootApplication
public class h2exampleApplication {

	public static void main(String[] args) throws Exception {

		ConfigurableApplicationContext context = SpringApplication.run(h2exampleApplication.class, args);

		Productservice service = context.getBean(Productservice.class);

		service.saveProduct();

		Thread.sleep(30000);

	   service.updateProduct();
	}

}