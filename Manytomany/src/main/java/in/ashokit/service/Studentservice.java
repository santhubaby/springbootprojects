package in.ashokit.service;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import in.ashokit.entity.Course;
import in.ashokit.entity.Student;
import in.ashokit.repo.Courserepo;
import in.ashokit.repo.Studentrepo;

@Service
public class Studentservice {
	
	@Autowired
	private Courserepo crepo;
	
	@Autowired
	private Studentrepo srepo;

	public void savestudents()
	{
		Student s1= new Student();
		Course course1= new  Course();

		course1.setCoursename("java");
		course1.setCoursefee(900.00);
		Course course2= new  Course();
	
		course2.setCoursename("sql");
		course2.setCoursefee(1000.00);
		
		crepo.saveAll(Arrays.asList(course1,course2));
		Set<Course> ces = new HashSet<>();
		ces.add(course1);
		ces.add(course2);

	
		s1.setName("santhu");
		s1.setCourses(ces);
		
		Student s2= new Student();
		Course course3= new  Course();
		
		course3.setCoursename("java");
		course3.setCoursefee(800.00);
		Course course4= new  Course();
	
		course4.setCoursename("aws");
		course4.setCoursefee(6000.00);
		
		crepo.saveAll(Arrays.asList(course3,course4));

		Set<Course> ces1 = new HashSet<>();
		ces1.add(course3);
		ces1.add(course4);

		s2.setName("ravi");
		s2.setCourses(ces1);
		
		srepo.saveAll(Arrays.asList(s1,s2));
	}
	
	public List<Student> getstudents()
	{
		return srepo.findAll();
	}
	
	public Optional<Student> getstudentbyid(int id)
	{
		return srepo.findById(id);
	}
	
	public Optional<Course> getcoursebyid(int id)
	{
		return crepo.findById(id);
	}
	
	public void getcourseandassociatedstudents(int courseid)
	{
		 Course c=getcoursebyid(courseid).get();
		 for(Student s:c.getStudents())
		 {
			 System.out.println(s);
		 }

	}
	public void deletebyid(int id)
	{
		srepo.deleteById(id);
	}
}

