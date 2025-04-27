package Booking;



public class BookingController {
	
	public BookingModel model;
	public BookingView view;
	public BookingController()
	{
		model=new BookingModel(this);
		this.view=view;
	}
	
	public int booking(int cid,String ppt,String dpt,int ptime)
	{
		return model.booking(cid,ppt,dpt,ptime);
	}
   
}
