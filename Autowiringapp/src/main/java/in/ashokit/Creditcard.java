package in.ashokit;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

@Service("credit")
@Primary
public class Creditcard implements Ipayment{

	@Override
	public void dopayment() {
		// TODO Auto-generated method stub
		System.out.println("payment done through creditcard");
	}

}
