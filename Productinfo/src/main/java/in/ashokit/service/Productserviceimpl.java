package in.ashokit.service;

import org.springframework.stereotype.Service;

import in.ashokit.exceptions.Productnotfoundexception;
import in.ashokit.model.Productdetails;

@Service
public class Productserviceimpl  implements Productservice{
	
	public Productdetails findproductbyid(Integer pid) {
		
		
		if(pid==101)
		{
			return new Productdetails(101,"mouse",900.00);
		}
		
		else
		{
			throw new   Productnotfoundexception("product not found");
		}
	}

}
