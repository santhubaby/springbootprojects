package in.ashokit.model;

public class Productdetails {

	Integer pid;
	String pname;
	Double pprice;
	
	public Productdetails(){
		
	}
	
	public Productdetails(Integer prid,String ppname, Double price)
	{
		this.pid=prid;
		this.pname=ppname;
		this.pprice=price;
	}

	public Integer getPid() {
		return pid;
	}

	public void setPid(Integer pid) {
		this.pid = pid;
	}

	public String getPname() {
		return pname;
	}

	public void setPname(String pname) {
		this.pname = pname;
	}

	public Double getPprice() {
		return pprice;
	}

	public void setPprice(Double pprice) {
		this.pprice = pprice;
	}

	@Override
	public String toString() {
		return "Productdetails [pid=" + pid + ", pname=" + pname + ", pprice=" + pprice + "]";
	}
	
	
	
}
