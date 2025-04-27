package dto;

public class Customerdtls {
	
	int custid;
	String from;
	String to;
	double amt;
	public Customerdtls(int custid,String from,String to,double amt)
	{
		setcustid(custid);
		setfrom(from);
		setto(to);
		setamt(amt);
	}
	public void setcustid(int custid)
	{
		this.custid=custid;
	}
	public void setfrom(String from)
	{
		this.from=from;
	}
	public void setto(String to)
	{
		this.to=to;
	}
	public void setamt(double amt)
	{
		this.amt=amt;
	}
	
	public int getcustid()
	{
		return custid;
	}
	public String getfrom()
	{
		return from;
	}
	public String getto()
	{
		return to;
	}
	public double getamt()
	{
		return amt;
	}
	

}
