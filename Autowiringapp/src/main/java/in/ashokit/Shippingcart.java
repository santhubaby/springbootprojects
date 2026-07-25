package in.ashokit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class Shippingcart {
	
	@Autowired
	@Qualifier("debit")
	private Ipayment ipay;
	
	public void placeorder() {
		
	
	    ipay.dopayment();
	
		System.out.println("order placed");
	}

}
