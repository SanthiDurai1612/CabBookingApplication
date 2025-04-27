package Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import Menu.*;
import dto.Bookingdtls;
import dto.Cabdtls;
import dto.Customerdtls;

public class Cabsettingdtls {
	
	
    public Customerdtls cust;
    public static Cabsettingdtls cabinstance;
	Map<Integer,Cabdtls> map=new HashMap<>();
	List<Bookingdtls> bookinglist=new ArrayList<>();

	Map<String,Integer> point=new HashMap<>();
	List<Integer> availcabs=new ArrayList<>();
	Bookingdtls booking=new Bookingdtls();
	Map<Integer, Bookingdtls> allBookings = new HashMap<>();
	public Map<String,Integer> locationdtls()
	{
		point.put("A",0);
		point.put("B",15);
		point.put("C",30);
		point.put("D",45);
		point.put("E",60);
		point.put("F",75);
		return point;
	}
	
	
	public void showtaxidetails()
	{
		   
        for(int i=0;i<bookinglist.size();i++)
        {
		  		  System.out.println("Taxi-"+" "+bookinglist.get(i).gettaxino()+" "+
				"Total Earning:"+" "+bookinglist.get(i).gettotearning());
					  System.out.println();
				System.out.printf("\n %13s %13s %13s %13s %13s %13s %13s",bookinglist.get(i).getbookingid(),
						bookinglist.get(i).getcustid(),bookinglist.get(i).getfrom(),bookinglist.get(i).getto(),
						bookinglist.get(i).getpickuptime(),bookinglist.get(i).getdroptime(),bookinglist.get(i).getamt());
				System.out.println();
				
				
		
        }
		   
		
		
	}
	public int booking(int cid,String ppt,String dpt,int ptime)
	{
		int flg=0;
		double minamt=0;
		int ppt_distance=0;
		int dpt_distance=0;
		int taxi_count=0;
		int tot_kms=0;
		int availcab=0;
        int aflg=0;
		int prev_cab=0;
		int next_cab=0;
		int cur_ppt_distance=0;
		for(Entry<Integer,Cabdtls> map:map.entrySet())
		{
			
			if(map.getValue().getcursource().equalsIgnoreCase(ppt) && map.getValue().getdroptime()<=ptime)
			{
				if(flg==0)
				{
					minamt=Integer.MAX_VALUE;
					flg=1;
				}
				
		      if(map.getValue().gettotearning()<minamt)
				{
		    	  
					minamt=map.getValue().gettotearning();
					availcab=map.getValue().gettaxino();
				}
			}
		
		}
		
		if(availcab==0)
		{
			
			for(Entry<String,Integer> point:point.entrySet())	
			{
				if(point.getKey().equalsIgnoreCase(ppt))
				{
					cur_ppt_distance=point.getValue();
					 
				}
			}
			
			if(cur_ppt_distance==75)
			{
				int flg1=0;
				while(cur_ppt_distance>=0)
				{
					for(Entry<String,Integer> points:point.entrySet())
					{
						String curpoint=points.getKey();
						for(Entry<Integer,Cabdtls> cab:map.entrySet())
						{
							if(cab.getValue().getcursource().equalsIgnoreCase(curpoint) && cab.getValue().getdroptime()<=ptime)
							{
								availcabs.add(cab.getValue().gettaxino());
								aflg=1;
								flg1=1;
								break;
							}
						}
						if(flg1==1)
						{
							break;
						}
					}
					if(flg1==1)
					{
						break;
					}
					
					cur_ppt_distance -= 15;
				}
			}
			
			else if(cur_ppt_distance==0)
			{
				int flg2=0;
				while(cur_ppt_distance<=75)
				{
					
					for(Entry<String,Integer> points:point.entrySet())
					{
						String curpoint=points.getKey();
						for(Entry<Integer,Cabdtls> cab:map.entrySet())
						{
							
							if(cab.getValue().getcursource().equalsIgnoreCase(curpoint) && cab.getValue().getdroptime()<=ptime)
							{
								
								availcabs.add(cab.getValue().gettaxino());
								aflg=1;
								flg2=1;
								break;
								
							}
							
						}
						if(flg2==1)
						{
							break;
						}
					}
					if(flg2==1)
					{
						break;
					}
					
				
					cur_ppt_distance += 15;
				}
			}
			
			else
			{
				int next_ppt_distance=cur_ppt_distance;
				int prev_ppt_distance=cur_ppt_distance;
				
				while(next_ppt_distance<=75 && prev_ppt_distance>=0)
				{
					
					for(Entry<String,Integer> points:point.entrySet())
					{
						if(points.getValue()==next_ppt_distance)
						{
						String curnextpoint=points.getKey();
						
						for(Entry<Integer,Cabdtls> cab:map.entrySet())
						{
							if(cab.getValue().getcursource().equalsIgnoreCase(curnextpoint) && cab.getValue().getdroptime()<=ptime)
							{
								next_cab=cab.getValue().gettaxino();
								
							}
						}
						}
						
						if(points.getValue()==prev_ppt_distance)
						{
						String curprevpoint=points.getKey();
					
						for(Entry<Integer,Cabdtls> cab:map.entrySet())
						{
							if(cab.getValue().getcursource().equalsIgnoreCase(curprevpoint) && cab.getValue().getdroptime()<=ptime)
							{
							
								prev_cab=cab.getValue().gettaxino();
								
								
							}	
						}
						}
					}
					
					
					
					if(next_cab!=0 || prev_cab!=0)
					{
						break;
					}
					if(next_ppt_distance<75)
					{
					next_ppt_distance+=15;
					}
					if(prev_ppt_distance>0)
					{
						prev_ppt_distance-=15;
					}
				}
			
				if(next_cab!=0 || prev_cab!=0)
				{

					double next_cab_earning=0;
					double prev_cab_earning=0;
					for(Entry<Integer,Cabdtls> map:map.entrySet())
					{
					   if(map.getValue().gettaxino()==next_cab)
					   {
						   next_cab_earning=map.getValue().gettotearning();
					   }
					   if(map.getValue().gettaxino()==prev_cab)
					   {
						   prev_cab_earning=map.getValue().gettotearning();
					   }
					}
					
					if(next_cab!=0 && prev_cab!=0)
					{
					if(next_cab_earning< prev_cab_earning)
					{
						availcabs.add(next_cab);
						aflg=1;
					}
					
					else 
					{
						
						availcabs.add(prev_cab);
						aflg=1;
						
					}
					}
					else
					{
						if(next_cab!=0)
						{
							availcabs.add(next_cab);
							aflg=1;
						}
						else if(prev_cab!=0)
						{
							availcabs.add(prev_cab);
							aflg=1;
						}
						else
						{
							availcab=0;
						}
					}
					
					
				}
				
				
			}
			
		
			
		}
	
		else
		{
		availcabs.add(availcab);
		aflg=1;
		}
		
		
			for(Entry<String,Integer> point:point.entrySet())	
			{
				if(point.getKey().equalsIgnoreCase(ppt))
				{
					 ppt_distance=point.getValue();
					 
				}
				if(point.getKey().equalsIgnoreCase(dpt))
				{
					 dpt_distance=point.getValue();
				}
				
			}
		
			
		if(dpt_distance>ppt_distance)
		{
	     tot_kms=dpt_distance-ppt_distance;
		}
		else
		{
		 tot_kms=ppt_distance-dpt_distance;
		}
		int remain=tot_kms-5;
		double totamt=(100*5)+(remain*10);
		
		int tottime=tot_kms/15;
		int droptime=ptime+tottime;

		
		if(aflg==0)
		{
			
			return 0;
		}

		setcabdtls(availcabs,cid,ppt,dpt,ptime,droptime,tottime,totamt);
		
		
		
		return availcabs.get(availcabs.size()-1);
	}
	
	public void setcabdtls(List<Integer> availcabs,int cid,String ppt,String dpt,int ptime,int droptime,int tottime,double totamt)
	{
		
		int id=0;
		double totearning=0;
		for(Entry<Integer,Cabdtls> entry:map.entrySet())
		{
		   if(entry.getKey()==availcabs.get(availcabs.size()-1))
		   {
			
			  
			   Cabdtls cab = entry.getValue();
			   
			   id=cab.getbookingid()+1;
			   cab.setbookingid(id);
			    totearning=cab.gettotearning()+totamt;
			   cab.settotearning(totearning);
			   cab.setcursource(dpt);
			   cab.setcustid(cid);
			   cab.setfrom(ppt);
			   cab.setto(dpt);
			   cab.setpickuptime(ptime);
			   cab.setdroptime(droptime);
			   cab.settottime(tottime);
			   cab.setamt(totamt);
			   cab.settaxino(availcabs.get(availcabs.size()-1));
			  
			  
		   }
		   
		
		}
		
	
		   Bookingdtls booking = new Bookingdtls();
		   booking.setamt(totamt);
		   booking.setbookingid(id);
		   booking.setcustid(cid);
		   booking.setdroptime(droptime);
		   booking.setpickuptime(ptime);
		   booking.setfrom(ppt);
		   booking.setto(dpt);
		   booking.settotearning(totearning);
		   booking.settaxino(availcabs.get(availcabs.size()-1));
		   allBookings.put(booking.getbookingid(), booking);
		   bookinglist.add(booking);
		
		   setcustdtls(cid, ppt, dpt,totamt);
		
		
	}
		
	
	
	public void setcustdtls(int cid,String ppt,String dpt,double totamt)
	{
		cust=new Customerdtls(cid,ppt,dpt,totamt);
		cust.setcustid(cid);
		cust.setfrom(ppt);
		cust.setto(ppt);
		cust.setamt(totamt);
	}
	public Map<Integer,Cabdtls> createcabs()
	{
		
		Cabdtls cab=new Cabdtls(1,100,"A");
		map.put(1, cab);
		Cabdtls cab2=new Cabdtls(2,80,"A");
		map.put(2, cab2);
		Cabdtls cab3=new Cabdtls(3,50,"A");
		map.put(3, cab3);
		Cabdtls cab4=new Cabdtls(4,0,"A");
		map.put(4, cab4);
	
		
		return map;
		
	}
	
	
	
	public static Cabsettingdtls  instance()
	{
		if(cabinstance==null)
		{
		cabinstance=new Cabsettingdtls();
		cabinstance.createcabs();
		cabinstance.locationdtls();
		}
		
		return cabinstance;
	}

}
