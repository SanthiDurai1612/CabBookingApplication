package dto;

import java.util.HashMap;
import java.util.Map;

public class Bookingdtls {

	int bookingid;
	int custid;
	String from;
	String to;
	int pickuptime;
	int droptime;
	double amt;
	double totearning;
	int taxino;
	
	public void booking(int bookingid,int custid,String from,String to,int pickuptime,int droptime,double amt,double totearning,int taxino)
	{
		
		settaxino(taxino);
		settotearning(totearning);
		setfrom(from);
		setto(to);
		setpickuptime(pickuptime);
		setdroptime(droptime);
		setamt(amt);
		setbookingid(bookingid);
		setcustid(custid);
	}
	
	public void settaxino(int taxino)
	{
		this.taxino=taxino;
	}
	public void settotearning(double totearning)
	{
		this.totearning=totearning;
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

	public double getamt()
	{
		 return amt;
	}
	
	
	
	
}
