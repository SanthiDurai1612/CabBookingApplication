package dto;

public class Cabdtls {
	
	int taxino;
	int bookingid;
	int custid;
	String cursource;
	String from;
	String to;
	int pickuptime;
	int droptime;
	int tottime;
	double amt;
	double totearning;
	public Cabdtls(int taxino,double totearning,String cursource)
	{
		settaxino(taxino);
		settotearning(totearning);
		setcursource(cursource);
		
	}
	public void settaxino(int taxino)
	{
		this.taxino=taxino;
	}
	public void settotearning(double totearning)
	{
		this.totearning=totearning;
	}
	public void setcursource(String cursource)
	{
		this.cursource=cursource;
	}
	public void setbookingid(int id)
	{
		this.bookingid=id;
	}
	public void setcustid(int cid)
	{
		this.custid=cid;
	}
	public void setfrom(String from)
	{
		this.from=from;
	}
	public void setto(String to)
	{
		this.to=to;
	}
	public void setpickuptime(int ptime)
	{
		this.pickuptime=ptime;
	}
	public void setdroptime(int dtime)
	{
		this.droptime=dtime;
	}
	public void settottime(int tottime)
	{
		this.tottime=tottime;
	}
	public void setamt(double amt)
	{
		this.amt=amt;
	}
	
	
	
	public int gettaxino()
	{
		return taxino;
	}
	public double gettotearning()
	{
		return totearning;
	}
	public String getcursource()
	{
		return cursource;
	}
	public int getbookingid()
	{
		return bookingid;
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
	public int getpickuptime()
	{
		 return pickuptime;
	}
	public int getdroptime()
	{
		return droptime;
	}
	public int gettottime()
	{
		return tottime;
	}
	public double getamt()
	{
		 return amt;
	}
	
	
	
	

}
