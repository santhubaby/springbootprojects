package in.ashokit;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import in.ashokit.model.Student;
import in.ashokit.service.Studentimpl;

@SpringBootApplication
public class Redisapp1Application {

	public static void main(String[] args) {
		ConfigurableApplicationContext ctxt= SpringApplication.run(Redisapp1Application.class, args);
		
		Studentimpl bean =ctxt.getBean(Studentimpl.class);
		
		//bean.addstudent(new Student("5b5","santhu","female"));
		//bean.addstudent(new Student("5b6","ravi","male"));
		bean.addstudent(new Student("5b3","jyotsna","female"));
      
		//bean.getallstudents().forEach((k,v)->System.out.println(k + "-" + v));
	}

}
