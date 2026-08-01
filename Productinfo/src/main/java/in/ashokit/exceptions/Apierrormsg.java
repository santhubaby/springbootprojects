package in.ashokit.exceptions;

import java.util.Date;

public class Apierrormsg {
	
	private Integer errorcode;
	private String errordesc;
	private Date date;
	
	public Apierrormsg()
	{
		
	}
	public Apierrormsg(Integer errorcode, String errordesc, Date date)
	{
		this.errorcode=errorcode;
		this.errordesc=errordesc;
		this.date=date;
	}
	public Integer getErrorcode() {
		return errorcode;
	}
	public void setErrorcode(Integer errorcode) {
		this.errorcode = errorcode;
	}
	public String getErrordesc() {
		return errordesc;
	}
	public void setErrordesc(String errordesc) {
		this.errordesc = errordesc;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	@Override
	public String toString() {
		return "Apierrormsg [errorcode=" + errorcode + ", errordesc=" + errordesc + ", date=" + date + "]";
	}
	
	

}
