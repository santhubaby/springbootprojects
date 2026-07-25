package in.ashokit;

import org.springframework.stereotype.Service;

@Service("debit")
public  class Debitcard implements Ipayment{

	public void dopayment()
	{
		System.out.println("payment done through debitcard");
	}
		
	

}
