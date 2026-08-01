package in.ashokit;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import in.ashokit.config.Appconfig;
import in.ashokit.entity.Student;
import in.ashokit.service.Studentservice;

@SpringBootApplication
public class OrmexampleApplication {

	public static void main(String[] args) {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(Appconfig.class);

		Studentservice service = context.getBean(Studentservice.class);

		// Save student
		//service.addStudent(new Student( "Kumar", "Delhi"));
		//service.addStudent(new Student( "Pragathi", "Chennai"));

		// Fetch students
		service.listStudents().forEach(s -> System.out.println(s.getId() + " " + s.getName() + " " + s.getCity()));

		context.close();
	}

}
