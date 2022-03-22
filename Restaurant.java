
import java.lang.reflect.Array;

public class Restaurant {
	public static void main(String[] args) {
		FoodItem[] items = new FoodItem[10];
	    items[0]         = new FoodItem("Roti                ",10,true,"Roti");
	    items[1]         = new FoodItem("Paratha             ",15,true,"Roti");
	    items[2]         = new FoodItem("Paneer Butter Masala",210,true,"Curry");
	    items[3]         = new FoodItem("Chicken Kadai       ",250,false,"Curry");
	    items[4]         = new FoodItem("Thali Meals         ",320,true,"Main course");
	    items[5]         = new FoodItem("Chicken Biriyani    ",350,false,"Main course");
	    items[6]         = new FoodItem("Mutton Biriyani     ",410,false,"Main course");
	    items[7]         = new FoodItem("Gulab Jamun         ",80,true,"Sweet");
	    items[8]         = new FoodItem("Lassi               ",100,true,"Sweet");
	    items[9]         = new FoodItem("Mashoom Masala      ",210,true,"Curry");
		
	    RestService cust1	= new RestService();  	
    	cust1.displayMenu(items);
    	
    	OrderItem[] oitem=new OrderItem[20];
    	oitem[0]		= new OrderItem(1,2);
    	oitem[1]		= new OrderItem(2,1);
    	oitem[2]		= new OrderItem(6,1);
    	oitem[3]		= new OrderItem(8,3);
    	cust1.orderFood(oitem,items);

	}
}
class RestService{
	
	void displayMenu(FoodItem[] arr){
		System.out.println("Welcome to the Restaurant!! ");
		System.out.println("Today's Specials are.. ");
		 int count	= Array.getLength(arr);
		 int no,i;
		 String veg;
		for(i=0;i<count;i++) {
			no=i+1;
			if(arr[i].itemType==true) veg="Pure Veg";
			else veg="Non Veg";
			System.out.println(no+". "+arr[i].itemName+" ("+veg+") 			- Rs."+arr[i].itemPrice);
		}
		System.out.println("--------------------------------------------------------");
		
	}

	public float orderFood(OrderItem[] arr,FoodItem[] foods) {
		// TODO Auto-generated method stub
		int count	= Array.getLength(arr);
		int no,i;
		String itemName;
		float price,totalBill=0;
		int quant;
		System.out.println("Your Food is ready. Enjoy!!");
		for(i=0;i<count&&arr[i]!=null;i++) {
			no=i+1;
			itemName	= foods[arr[i].itemId].itemName;
			quant		= arr[i].itemQuant;
			price		= foods[arr[i].itemId].itemPrice;
			System.out.println(no+". "+itemName+" 			X "+quant+" 	- Rs."+price+"/-");
			totalBill+=addtoBill(quant,price);
			
		}
		System.out.println("--------------------------------------------------------");
		System.out.println("TOTAL BILL  						- Rs."+totalBill+"/-");
		System.out.println("---------------------------------------------------------");
		System.out.println("THANK YOU FOR VISITIG!!");
		return totalBill;
	}

	private float addtoBill(int quant, float price) {
		// TODO Auto-generated method stub
		float total;
		total=quant*price;
		
		return total;
	}
	
}

class FoodItem{
   String itemName;
   int itemPrice;
  boolean itemType;
  String itemCat;
  public FoodItem(String name,int price,boolean type,String cat){
    itemName    =name;
    itemPrice   =price;
    itemType    = type;
    itemCat     = cat;
    
  }
}
class OrderItem{
	  int itemId;
	  int itemQuant;
	  public  OrderItem(int id,int quant){
	    itemId    =id;
	    itemQuant  =quant;
	     
	  }
}

