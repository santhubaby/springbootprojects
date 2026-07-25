package in.ashokit.entity ;
import jakarta.persistence.*;
import java.util.HashSet;
import java.util.Set;


@Entity
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int sid;

    private String name;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
        name = "student_course", // join table name
        joinColumns = @JoinColumn(name = "student_id"), // foreign key for Student
        inverseJoinColumns = @JoinColumn(name = "course_id") // foreign key for Course
    )
    private Set<Course> courses = new HashSet<>();
    
    public Student()
    {
    	
    }

	public int getSid() {
		return sid;
	}

	public void setSid(int sid) {
		this.sid = sid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Set<Course> getCourses() {
		return courses;
	}

	public void setCourses(Set<Course> courses) {
		this.courses = courses;
	}

	@Override
	public String toString() {
	    return "Student [sid=" + sid + ", name=" + name +
	           ", courses=" + courses + "]";
	}

    

    // getters and setters
}
