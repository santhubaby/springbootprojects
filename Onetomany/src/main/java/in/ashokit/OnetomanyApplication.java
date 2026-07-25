package in.ashokit;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import in.ashokit.service.Employeeservice;

@SpringBootApplication
public class OnetomanyApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext context = SpringApplication.run(OnetomanyApplication.class, args);

		Employeeservice bean = context.getBean(Employeeservice.class);

		// bean.saveEmpWithAddressList();

		// System.out.println(bean.getEmp(1).get());

		// System.out.println(bean.getAddr(1).get());

		 bean.deleteAddress(2);

		bean.deleteEmp(1);
	}

}