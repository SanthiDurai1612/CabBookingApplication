package Booking;
import java.util.*;
import Menu.*;
import Repository.Cabsettingdtls;
public class BookingView {

	public BookingController controll;
	public DisplayTaxi display;
	public Cabsettingdtls cab;
	public BookingView()
	{
		controll=new BookingController() ;
		if(display==null)
		{
		display=new DisplayTaxi();
		}
	}
	
	public void getinputs()
	{
		Scanner in=new Scanner(System.in);
		System.out.println("Enter Customer ID:");
		int cid=in.nextInt();
		System.out.println("Enter PickUp Point:");
		String ppt=in.next();
		System.out.println("Enter Drop Point:");
		String dpt=in.next();
		System.out.println("Enter PickupTime:");
		int ptime=in.nextInt();
		
		int allotedtaxi=controll.booking(cid,ppt,dpt,ptime);
	
		if(allotedtaxi!=0)
		{
			System.out.println("Taxi Can Be Alloted \n");
			System.out.println("Taxi-"+allotedtaxi+" "+"alloted \n");
			System.out.println("Happy Journey \n");
			System.out.println("----------------------------------------------- \n");
			display.cabdtls();
		}
		else 
		{
			System.out.println("Sorry!! Taxi Not Available \n");
		}
	}
}
