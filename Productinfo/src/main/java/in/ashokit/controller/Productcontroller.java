package in.ashokit.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import in.ashokit.model.Productdetails;
import in.ashokit.service.Productserviceimpl;

@RestController
public class Productcontroller {
	
	@Autowired
	private Productserviceimpl pservice;
	
	@GetMapping(value="/getproduct",produces= {"application/json"})
	public Productdetails findproduct(@RequestParam("pid") Integer pid)
	
	{
		return pservice.findproductbyid(pid);
	}
	
	

}
