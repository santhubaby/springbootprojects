package in.ashokit.dto;
import org.springframework.stereotype.Component;

@Component
public class Orderevent {
	
	    private String orderitem;
	    private int quantity;

	    public String getOrderitem() 
	    { return orderitem; 
	    }
	    public void setOrderitem(String orderitem) 
	    { this.orderitem = orderitem; 
	    }

	    public int getQuantity() { 
	    	return quantity;
	    	}
	    public void setQuantity(int quantity) { 
	    	this.quantity = quantity; 
	    	}
}


