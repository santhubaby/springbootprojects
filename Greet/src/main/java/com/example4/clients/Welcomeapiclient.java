package com.example4.clients;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(name="welcome")
public interface Welcomeapiclient {
	
	@GetMapping("/welcome")
	public String invokewelcomeapi();

}
