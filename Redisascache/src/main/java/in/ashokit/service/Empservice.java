package in.ashokit.service;

import java.util.List;
import java.util.Optional;
import java.util.function.Function;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.query.FluentQuery.FetchableFluentQuery;
import org.springframework.stereotype.Service;

import in.ashokit.entity.Employee;
import in.ashokit.repo.Iemployeerepo;

@Service
public class Empservice {
	
	
	@Autowired
	Iemployeerepo irepo;
	
	
	public Employee saveemp(Employee e)
	{
		return irepo.save(e);
	}
	
	@CachePut(value="employees",key="#id")
    public Employee  updateemp(Integer id,Employee e)
	{
		return irepo.save(e);
		
	}
	
	@CacheEvict(value="employees",allEntries=true)
    public void deleteemp(Integer id) {
		
		irepo.deleteById(id);
		
	}
	public List<Employee> getallemployees(){
		
		return irepo.findAll();
}
	@Cacheable(value="employees",key="#id")
	public Optional<Employee> getoneemp(Integer id) {
		
		return irepo.findById(id);
		
	}

	
}
