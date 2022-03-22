import java.util.Date;
public class AssignmentFnType {

	public static void main(String args[]){
	  meditation();
	  multiTable(5);
	  String email = getemail("nimya","krishnan");
 	  System.out.println("Suitable Email is "+email);
	  System.out.println("Today you are "+feeling());
	
	}
	static void meditation(){
		System.out.println("Close your eyes and take breath!!");
		int i=1;
		while(i!=6){
		 
			System.out.println(i+"s \n");
			i++;
			//Thread.sleep(100);
		}
	
	}
	
	static void multiTable(int x)
	{
		int i;
		for(i=1;i<=10;i++){	  
			System.out.println(i+"*"+x+"="+(i*x)+"\n" );
		}
	}
	
	
	private static String getemail(String string2, String string3) {
		// TODO Auto-generated method stub
		String email=string2+string3+"@"+"domain.com";
		return email;
	}

	private static String feeling() {
		// TODO Auto-generated method stub
		Date d=new Date();
		
		int x = d.getSeconds()%10;
		switch(x){
			case 1:
			case 3:
			case 5:
				return "Happy";
			
			case 2:
			case 6:
			case 8:
				return "Angry";
			
		case 4:
		case 7:
			return "Sad!";
			
		case 9:
			return "Excited ";
			
		default:
		 return "Cool!! ";
		
	}
		
}
}
