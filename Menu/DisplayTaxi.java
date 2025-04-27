package Menu;

import Repository.Cabsettingdtls;
import dto.Cabdtls;
import Booking.*;
import java.util.*;
public class DisplayTaxi {
	
	
	public void cabdtls()
	{
		System.out.println("Welcome To Taxi Booking Application \n");
		
		System.out.println("Enter 1 To View Taxi Details || Enter 2 For Booking");
		Scanner in=new Scanner(System.in);
		String input=in.next();
		
		if(input.equalsIgnoreCase("1"))
		{
			
			System.out.printf("\n %13s %13s %13s %13s %13s %13s %13s","BookingID","CustomerID",
					"From","To","PickupTime","DropTime","Amount \n");
			System.out.println("----------------------------------------------------------------------------------------------------- \n");
            

			
			Cabsettingdtls.instance().showtaxidetails();
			
		}
		else if(input.equalsIgnoreCase("2"))
		{
			System.out.println("Hey!! Book Your Taxi Now!! \n");
			BookingView bview=new BookingView();
			bview.getinputs();
			
			
		}
		else
		{
			System.out.println("Thank You !! Visit Again !! \n");
			System.out.println("---------------------------- \n");
			return;
		}
		
		System.out.println();
		cabdtls();
		
		
	}


	public static void main(String[] args) {
		// TODO Auto-generated method stub
	
		DisplayTaxi display=new DisplayTaxi();
		display.cabdtls();

	}

}
