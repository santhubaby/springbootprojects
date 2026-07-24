package in.ashokit.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "consumer_orders")
public class Consumerorder {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String orderitem;
    private int totalOrders;

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

  

    public String getOrderitem() {
		return orderitem;
	}
	public void setOrderitem(String orderitem) {
		this.orderitem = orderitem;
	}
	public int getTotalOrders() { return totalOrders; }
    public void setTotalOrders(int totalOrders) { this.totalOrders = totalOrders; }
}
