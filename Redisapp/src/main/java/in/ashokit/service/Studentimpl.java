package in.ashokit.service;

import java.util.Map;

import org.springframework.data.redis.core.HashOperations;
import org.springframework.stereotype.Service;

import in.ashokit.model.Student;
import in.ashokit.repo.Istudent;
import jakarta.annotation.Resource;


@Service
public class Studentimpl implements Istudent {
  
	
	private final String KEY="STUDENT";
	
	@Resource(name="rt") 
	private HashOperations<String,String,Student> opr;
	
	@Override
	public void addstudent(Student s) {
     
		opr.putIfAbsent(KEY, s.getSid(), s);
	}

	@Override
	public void modifystudent(Student s) {
		opr.put(KEY, s.getSid(), s);
	}

	@Override
	public Student getstudent(int id) {
		
		 return opr.get(KEY,id);
		
	}

	@Override
	public Map<String, Student> getallstudents() {
		return opr.entries(KEY);
	}

	@Override
	public void removestudent(int id) {
           opr.delete(KEY,id);	
	}

}
