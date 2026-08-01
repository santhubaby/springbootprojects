package in.ashokit.repo;

import java.util.Map;
import java.util.Optional;

import in.ashokit.model.Student;

public interface Istudent {
	
	public void addstudent(Student s);
	
	public void  modifystudent(Student s);
	
	public  Student getstudent(int id);
	
	public Map<String,Student> getallstudents();
	
	public void removestudent(int id);
	
	
	

}
