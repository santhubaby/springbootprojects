package in.ashokit.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import in.ashokit.entity.Employee;

public interface Employeerepo extends JpaRepository<Employee, Integer>{

}