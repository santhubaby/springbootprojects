package in.ashokit.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Msgrestcontroller {
	
	@GetMapping(value="/welcome")
	public String welcome() {
		
		return "welcome to ashokit";
	}

}
