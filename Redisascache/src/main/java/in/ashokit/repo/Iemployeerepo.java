package in.ashokit.repo;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import in.ashokit.entity.Employee;

public interface Iemployeerepo extends JpaRepository<Employee,Integer> {
	
	

}
