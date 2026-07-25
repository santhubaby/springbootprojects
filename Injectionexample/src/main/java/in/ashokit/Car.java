package in.ashokit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Car {
	
	//field injection
	//@Autowired
	private Engine eng;
	
	
	public Car()
	{
		  System.out.println("car default constructor");

	}
	//constructor injection
	@Autowired
	public Car(Engine engi)
	{
		  System.out.println("car parameterized constructor");

		this.eng=engi;
	}
	//setter injection
  @Autowired
  public void setEngine(Engine engi2)
  {
	  System.out.println("settermethod");
	  this.eng=engi2;
  }
	public void drive()
	{
		System.out.println("car is depending on engine");
		eng.start();
	}
}
