package Booking;

import Repository.*;
public class BookingModel {
	
	public BookingController controll;
	public Cabsettingdtls cab;
	
	public BookingModel(BookingController controll)
	{
		this.controll=controll;
		
	}
	
	public int booking(int cid,String ppt,String dpt,int ptime)
	{
		return cab.instance().booking(cid,ppt,dpt,ptime);
		
		
	}
   

}
