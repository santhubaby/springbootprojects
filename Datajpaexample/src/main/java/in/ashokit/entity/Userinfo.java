package in.ashokit.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;


@Entity
public class Userinfo {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer userId;
	private String name;
	private String gender;
	private String country;
	private Integer age;
	
	public Userinfo() {
		
	}
    public Userinfo(Integer userid,String name, String gender, String country,Integer age) 
    {
    	this.userId=userid;
    	this.name=name;
    	this.gender=gender;
    	this.country=country;
    	this.age=age;
		
	}
	public Integer getUserId() {
		return userId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public Integer getAge() {
		return age;
	}
	public void setAge(Integer age) {
		this.age = age;
	}
	@Override
	public String toString() {
		return "Userinfo [userId=" + userId + ", name=" + name + ", gender=" + gender + ", country=" + country
				+ ", age=" + age + "]";
	}

}