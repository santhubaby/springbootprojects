package in.ashokit;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import in.ashokit.config.Appconfig;
import in.ashokit.entity.Employee;
import in.ashokit.service.Empservice;

public class OrmappApplication {

	public static void main(String[] args) {

		Employee e = new Employee();
		e.setEmpId(103);
		e.setEmpName("Charan");
		e.setEmpSalary(35000.00);

		ApplicationContext ctxt = 
				new AnnotationConfigApplicationContext(Appconfig.class);

		Empservice es = ctxt.getBean(Empservice.class);

		//es.saveEmployee(e);

		// es.saveOrUpdateEmployee(e);

		// es.getEmps();

		 es.getEmpById(103);
		
		//es.getEmpsByName("Ashok");
	}

}