package in.ashokit;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import in.ashokit.entity.Course;
import in.ashokit.entity.Student;
import in.ashokit.service.Studentservice;

@SpringBootApplication
public class ManytomanyApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext ctxt =SpringApplication.run(ManytomanyApplication.class, args);
		
		Studentservice sv= ctxt.getBean(Studentservice.class);
		
	    //sv.savestudents();
	   System.out.println(sv.getstudentbyid(2).get());
	    
	   //sv.getstudents().forEach(n->System.out.println(n));
		
		// System.out.println(sv.getcoursebyid(1).get());
		sv.getcourseandassociatedstudents(1);
		

	}

}
