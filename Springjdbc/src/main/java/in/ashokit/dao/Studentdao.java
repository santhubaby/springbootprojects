package in.ashokit.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import in.ashokit.dto.Student;
import in.ashokit.mapper.StudentMapper;

@Repository
public class Studentdao {

	private JdbcTemplate jt;

	public Studentdao(JdbcTemplate jt) {
		this.jt = jt;
	}

	public int save(Student s) {

		String sql = "INSERT INTO STUDENT (ID, NAME, CITY) VALUES (?,?,?)";
		int rowsEffected = jt.update(sql, s.getId(), s.getName(), s.getCity());

		return rowsEffected;
	}

	public List<Student> findAll() {
		return jt.query("SELECT * FROM STUDENT", new StudentMapper());
	}
	
	 public int updateCity(int id, String city) {
	        String sql = "UPDATE STUDENT SET city = ? WHERE id = ?";
	        return jt.update(sql, city, id);
	    }

	    public int deleteById(int id) {
	        String sql = "DELETE FROM student WHERE id = ?";
	        return jt.update(sql, id);
	    }
	    
	  /** public  Student findById(int id) {
	        String sql = "SELECT * FROM student WHERE id = ?";
	        return jt.queryForObject(sql, new StudentMapper(), id);
	    }**/
	    
	    
	    public Optional<Student> findById(int id) {
	        String sql = "SELECT * FROM student WHERE id = ?";
	        try {
	            Student student = jt.queryForObject(sql, new StudentMapper(), id);
	            return Optional.ofNullable(student);
	        } catch (EmptyResultDataAccessException ex) {
	            return Optional.empty();
	        }
	    }

}