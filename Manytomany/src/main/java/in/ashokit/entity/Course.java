package in.ashokit.entity;

import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;

@Entity
public class Course {
	
    @Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer courseid;
	private String coursename;
	private Double coursefee;
	
	public Course()
	{
		
	}
	 @ManyToMany(mappedBy = "courses",fetch = FetchType.EAGER)
	 private Set<Student> students = new HashSet<>();

	 public Integer getCourseid() {
		 return courseid;
	 }
	 public void setCourseid(Integer courseid) {
		 this.courseid = courseid;
	 }
	 public String getCoursename() {
		 return coursename;
	 }
	 public void setCoursename(String coursename) {
		 this.coursename = coursename;
	 }
	 public Double getCoursefee() {
		 return coursefee;
	 }
	 public void setCoursefee(Double coursefee) {
		 this.coursefee = coursefee;
	 }
	 public Set<Student> getStudents() {
		 return students;
	 }
	 public void setStudents(Set<Student> students) {
		 this.students = students;
	 }
	 @Override
	public String toString() {
		return "Course [courseid=" + courseid + ", coursename=" + coursename + ", coursefee=" + coursefee + "]";
	}
	 
	 
	 

}
