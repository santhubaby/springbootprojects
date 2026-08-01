package in.ashokit.controller;

import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;

import in.ashokit.exceptions.Apierrormsg;
import in.ashokit.exceptions.Productnotfoundexception;


@RestController
@ControllerAdvice
public class RestExceptionhandler {
	
	@ExceptionHandler(value=Productnotfoundexception.class)
	public ResponseEntity<Apierrormsg> Productnotfoundexception()
	
	{
		
		Apierrormsg errormsg= new Apierrormsg(400,"product not found",new Date());
		return new ResponseEntity<Apierrormsg>(errormsg,HttpStatus.BAD_REQUEST);
	}
	
	

}
