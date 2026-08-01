package resttemplate;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class Productservice {

	RestTemplate rt= new RestTemplate();
	
	
	public void getproductdetails()
	{
		String url="https://api.restful-api.dev/objects/1";
      
		ResponseEntity<String> str= rt.getForEntity(url, String.class);
		
		System.out.println(str);
	}
}
