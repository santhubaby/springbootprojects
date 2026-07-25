package in.ashokit;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import in.ashokit.service.Userservice;

@SpringBootApplication
public class DatajparepoApplication {

	public static void main(String[] args) throws Exception {
		ConfigurableApplicationContext context = SpringApplication.run(DatajparepoApplication.class, args);

		Userservice bean = context.getBean(Userservice.class);

		// bean.getUserswithSort();

		// bean.getUserswithPagination();

		// bean.qbe();

		//bean.saveUsers();
	}

}