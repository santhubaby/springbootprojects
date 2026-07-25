package com.example4.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.example4.clients.Welcomeapiclient;

@RestController
public class Greetmsg {

	
	@Value("${msg}")
	private String greetmsg;
	
	@Autowired
	private Welcomeapiclient welcomeclient;
	
	@GetMapping("/greet")
	public String greetmsg()
	{
		/*String url="http://localhost:8082/welcome";
		
		RestTemplate rt= new RestTemplate();
		ResponseEntity<String> rs = rt.getForEntity(url, String.class);
		 String welcomemsg=rs.getBody();
		 */
		
		String welcomemsg= welcomeclient.invokewelcomeapi();
		return  welcomemsg +  " need   space "   +greetmsg ;
	}
}
