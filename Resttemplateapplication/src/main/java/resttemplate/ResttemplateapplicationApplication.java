package resttemplate;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class ResttemplateapplicationApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext context=SpringApplication.run(ResttemplateapplicationApplication.class, args);
		
		Productservice ps=context.getBean(Productservice.class);
		
		ps.getproductdetails();
	}

}
