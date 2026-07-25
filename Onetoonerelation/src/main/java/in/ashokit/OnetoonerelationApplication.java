package in.ashokit;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import in.ashokit.service.Personservice;

@SpringBootApplication
public class OnetoonerelationApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext context = SpringApplication.run(OnetoonerelationApplication.class, args);

		Personservice personService = context.getBean(Personservice.class);

		//personService.savePersonWithPassport();

		System.out.println(personService.getPerson(1).get()); // parent + child

	    System.out.println(personService.getPassport(1).get()); // child + parent

		// personService.deletePerson(1); // parent + child

		//personService.deletePassport(1); // child + parent
	}
}


