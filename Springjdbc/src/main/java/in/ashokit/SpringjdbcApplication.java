package in.ashokit;

import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import in.ashokit.config.Appconfig;
import in.ashokit.dao.Studentdao;
import in.ashokit.dto.Student;

@SpringBootApplication
public class SpringjdbcApplication {

	public static void main(String[] args) {
		ApplicationContext ctxt = new AnnotationConfigApplicationContext(Appconfig.class);

		Studentdao dao = ctxt.getBean(Studentdao.class);

		
		 Student s = new Student(); s.setCity("Hyderbad"); s.setName("Sanjay");
		 
		 
		// int cnt = dao.save(s);
		 
		// System.out.println("Rows Effected :: " + cnt);
		 
		
		//List<Student> all = dao.findAll();
		//all.forEach(n->System.out.println(n));
		 
		 System.out.println(dao.findById(1));
	}

}
