package in.ashokit.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.time.LocalDateTime;

@Entity
@Table(name="user_orders")
public class Order {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer orderid;
	private String orderitem;
	private Double orderprice;
    private LocalDateTime orderdate = LocalDateTime.now();
    private Integer quantity;
    
    
	public Order()
	{
		
	}
	public Order(Integer orderid,String orderitem, Double orderprice, LocalDateTime orderdate,Integer quantity) {
		
		this.orderid=orderid;
		this.orderitem=orderitem;
		this.orderprice=orderprice;
		this.orderdate=orderdate;
		this.quantity=quantity;
		
	}

	public Integer getOrderid() {
		return orderid;
	}

	public void setOrderid(Integer orderid) {
		this.orderid = orderid;
	}

	public String getOrderitem() {
		return orderitem;
	}

	public void setOrderitem(String orderitem) {
		this.orderitem = orderitem;
	}

	public Double getOrderprice() {
		return orderprice;
	}

	public void setOrderprice(Double orderprice) {
		this.orderprice = orderprice;
	}

	public LocalDateTime getOrderdate() {
		return orderdate;
	}

	public void setOrderdate(LocalDateTime orderdate) {
		this.orderdate = orderdate;
	}
	

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	@Override
	public String toString() {
		return "Order [orderid=" + orderid + ", orderitem=" + orderitem + ", orderprice=" + orderprice + ", orderdate="
				+ orderdate + ", quantity=" + quantity + "]";
	}
	
	
}
