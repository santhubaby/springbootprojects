package in.ashokit.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;
import java.util.Optional;

import in.ashokit.entity.Employee;
import in.ashokit.service.Empservice;

@RestController
@RequestMapping("/employee")
public class Empcontroller {
	
	@Autowired
	private Empservice semp;
	
	@PostMapping("/save")
	public ResponseEntity<Employee> saveemployee(@RequestBody Employee emp)
	{
		Employee savedemp =semp.saveemp(emp);
		
		return new ResponseEntity<Employee>(savedemp,HttpStatus.CREATED);
	}
	
	@GetMapping("/employees")
	public ResponseEntity<List<Employee>> getemps()
	{
		List<Employee> emps = semp.getallemployees();
		
		return new ResponseEntity<List<Employee>>(emps,HttpStatus.OK);
	}
	
	
	@GetMapping("/employee/{id}")
	public ResponseEntity<Employee> getemp(@PathVariable Integer id)
	{
		Employee e= semp.getoneemp(id).get();
		
		return new ResponseEntity<Employee>(e,HttpStatus.OK);
	}

	
	@PutMapping("/modify/{id}")
	public ResponseEntity<Employee> updateemp(@PathVariable Integer id, @RequestBody Employee emp)
	{
		
		Employee  emp1= semp.updateemp(id, emp);
		
		return new ResponseEntity<Employee>(emp1,HttpStatus.OK);
	}
	
	@DeleteMapping("/remove/{id}")
	public String deleteemp(@PathVariable Integer id)
	{
		semp.deleteemp(id);
		
		return "employee deleted";
	}
	

}

