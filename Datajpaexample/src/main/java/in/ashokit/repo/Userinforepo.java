package in.ashokit.repo;

import java.util.List;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;


import in.ashokit.entity.Userinfo;

public interface Userinforepo extends CrudRepository<Userinfo, Integer> {

	// select * from user_info where country=?
	public List<Userinfo> findByCountry(String country);

	// select * from user_info where gender=?
	public List<Userinfo> findByGender(String gender);

	// select * from user_info where country=? and gender=?
	public List<Userinfo> findByCountryAndGender(String country, String gender);

	// select * from user_info where age >= 40
	public List<Userinfo> findByAgeGreaterThanEqual(Integer age);

	// select * from user_info where country=? and age >= ?
	public List<Userinfo> findByCountryAndAgeGreaterThanEqual(String country, Integer age);

	@Query(value = "select * from userinfo", nativeQuery = true)
	public List<Userinfo> m1();
	
	@Query("From Userinfo")
	public List<Userinfo> m2();		
	
	@Transactional
	@Modifying
	@Query("delete from Userinfo where userId = :userId")
	public void m3(Integer userId);
	

}







