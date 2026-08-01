package in.ashokit.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.ashokit.dao.Studentdao;
import in.ashokit.entity.Student;

@Service
public class Studentservice {

	@Autowired
	private Studentdao studentDao;

	public void addStudent(Student student) {
		studentDao.saveStudent(student);
	}

	public List<Student> listStudents() {
		return studentDao.getAllStudents();
	}
}