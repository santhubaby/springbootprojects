package in.ashokit.model;
import java.io.Serializable;


public class Student implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 7627597091945114942L;
	private String sid;
	private String sname;
	private String sgender;
	
	public Student(String sid,String sname, String sgender)
	{
		this.sid=sid;
		this.sname=sname;
		this.sgender=sgender;
		
		
	}

	public String getSid() {
		return sid;
	}

	public void setSid(String sid) {
		this.sid = sid;
	}

	public String getSname() {
		return sname;
	}

	public void setSname(String sname) {
		this.sname = sname;
	}

	public String getSgender() {
		return sgender;
	}

	public void setSgender(String sgender) {
		this.sgender = sgender;
	}

	@Override
	public String toString() {
		return "Student [sid=" + sid + ", sname=" + sname + ", sgender=" + sgender + "]";
	}
	
	

}
