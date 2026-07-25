package in.ashokit.service;

import java.util.Arrays;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import in.ashokit.entity.Address;
import in.ashokit.entity.Employee;
import in.ashokit.repo.Addressrepo;
import in.ashokit.repo.Employeerepo;

@Service
public class Employeeservice {

	@Autowired
	private Employeerepo empRepo;

	@Autowired
	private Addressrepo addrRepo;

	public void saveEmpWithAddressList() {

		Address a1 = new Address();
		a1.setCity("Hyd");
		a1.setState("TG");
		a1.setType("Present");

		Address a2 = new Address();
		a2.setCity("Guntur");
		a2.setState("AP");
		a2.setType("Permanent");

		Employee e = new Employee();
		e.setEmpName("Ram");
		e.setEmpSalary(15000.00);

		// associate emp to addr objs
		a1.setEmp(e);
		a2.setEmp(e);

		// associate addrList to emp
		e.setAddrList(Arrays.asList(a1, a2));

		// save parent
		empRepo.save(e);
	}

	public Optional<Employee> getEmp(int id) {
		 return empRepo.findById(id);
	}
	
	public void deleteEmp(int id) {
		empRepo.deleteById(id);
	}

	public Optional<Address> getAddr(int id) {
		 return addrRepo.findById(id);
	}

	@Transactional
	public void deleteAddress(int addrId) {

		Address address = addrRepo.findById(addrId).orElseThrow();

		Employee emp = address.getEmp();

		if (emp != null) {

			emp.getAddrList().remove(address); // unlink child from parent

			address.setEmp(null); // unlink from child side also
		}

		addrRepo.delete(address);
	}
}