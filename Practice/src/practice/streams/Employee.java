package practice.streams;

public class Employee {
	
	String empname;
	int empage;
	double empsal;
	String empdep;
	String empcity;
	Double  citypopulation;
	
	Employee(String name, int age,double sal,String dep,String city,double citypop)
	{
		this.empname=name;
		this.empage=age;
		this.empsal=sal;
		this.empdep=dep;
		this.empcity=city;
		this.citypopulation=citypop;
	}

	public String getEmpname() {
		return empname;
	}

	public void setEmpname(String empname) {
		this.empname = empname;
	}

	public int getEmpage() {
		return empage;
	}

	public void setEmpage(int empage) {
		this.empage = empage;
	}

	public double getEmpsal() {
		return empsal;
	}

	public void setEmpsal(double empsal) {
		this.empsal = empsal;
	}

	public String getEmpdep() {
		return empdep;
	}

	public void setEmpdep(String empdep) {
		this.empdep = empdep;
	}

	public String getEmpcity() {
		return empcity;
	}

	public void setEmpcity(String empcity) {
		this.empcity = empcity;
	}

	public Double getCitypopulation() {
		return citypopulation;
	}

	public void setCitypopualation(Double citypopualation) {
		this.citypopulation = citypopualation;
	}

	@Override
	public String toString() {
		return "Employee [empname=" + empname + ", empage=" + empage + ", empsal=" + empsal + ", empdep=" + empdep
				+ ", empcity=" + empcity + ", citypopualation=" + citypopulation + "]";
	}
	
	

}
