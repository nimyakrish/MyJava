import java.time.LocalDate;
import java.time.LocalTime;
public class Restaurant {

	public static void main(String[] args) {
		FoodItem[] items = new FoodItem[10];
    items[0]         = new FoodItem("Roti",10,0,"Roti");
    items[1]         = new FoodItem("Paratha",15,0,"Roti");
    items[2]         = new FoodItem("Paneer Butter Masala",210,0,"Curry");
    items[3]         = new FoodItem("Chicken Kadai",250,1,"Curry");
    items[4]         = new FoodItem("Thali Meals",320,0,"Main course");
    items[5]         = new FoodItem("Chicken Biriyani",350,1,"Main course");
    items[6]         = new FoodItem("Mutton Biriyani",410,1,"Main course");
    items[7]         = new FoodItem("Gulab Jamun",80,0,"Sweet");
    items[8]         = new FoodItem("Lassi",100,0,"Sweet");
    items[9]         = new FoodItem("Mashoom Masala",210,0,"Curry");
        
    
		BankAcc[] ount cust1 = new BankAccount();			
		cust1.setBankAccount(123, "Nimya Krishnan", 45000.0f,LocalDate.of(2022, 3, 22),LocalDate.of(1988, 8, 28),"ASVCD5454G");
		cust1.printBankAccount();
		float updatedBalance = cust1.withdraw(10000);
		System.out.println("Updated balance is "+updatedBalance+" @"+LocalTime.now().getHour()+":"+LocalTime.now().getMinute());
		updatedBalance = cust1.deposit(55000);
		System.out.println("Updated balance is "+updatedBalance+" @"+LocalTime.now().getHour()+":"+LocalTime.now().getMinute());		
		
	}

}

class FoodItem{
  private itemName;
  private itemPrice;
  private itemType;
  private itemCat;
  public FoodItem(String name,int price,boolean type,String cat){
    itemName    =name;
    itemPrice   =price;
    itemType    = type;
    itemCat     = cat;
    
  }
}
class BankAccount
{
	//DATA-MEMBER / fields  SECTION
	private int accountNumber;
	private String accountHolderName;
	private float accountBalance;
	private int age;
	private String pan;
	private LocalDate accopendate;
	private LocalDate dateofbirth;
	private LocalTime txnTime;
	//MEMBER-FUNCTIONS / methods SECTION
	
	void setBankAccount(int x, String y, float z,LocalDate aod,LocalDate dob,String panno) {
		System.out.println("Setting the bank account details....");
		accountNumber = x;
		accountHolderName = y;
		accountBalance= z;
		LocalDate today = LocalDate.now();
		age = today.getYear() - dob.getYear();
		pan=panno;
		accopendate=aod;
		dateofbirth=dob;
	}
	
	

	void printBankAccount() {
		System.out.println("Bank Account Number  : "+accountNumber);
		System.out.println("Bank Holder Name     : "+accountHolderName);
		System.out.println("Bank Account Balance : Rs."+accountBalance+"/-");
		System.out.println("Bank Holder's Age    : "+age+" years");
		System.out.println("PAN Number 		     : "+pan);
		System.out.println("Account Opening date : "+accopendate+" years");
		System.out.println("Simple Interset      : "+calculateSimpleInterest());	
		
		
		System.out.println("---------------------");
	}
	
	float withdraw(float amountToWithdraw) {
		System.out.println("withdrawing....");
		if(amountToWithdraw <=accountBalance) {
			//+amountToWithdraw+" @"+LocalTime.now().getHour()+":"+LocalTime.now().getMinute()
			accountBalance = accountBalance - amountToWithdraw;		
		}else {
			System.out.println("Insufficient Balance....");
		}
		return accountBalance;
	}
	float deposit(float amountToDeposit) {
		System.out.println("Depositing....");
		if(amountToDeposit>50000) {
			System.out.println("Submit PAN and source of income!");
		} else {
			//System.out.println("Depositing...."+amountToDeposit+" @"+LocalTime.now().getHour()+":"+LocalTime.now().getMinute());
			accountBalance = accountBalance + amountToDeposit;
		}
				return accountBalance;
	}
	
	private float calculateSimpleInterest() {
		System.out.println("Calculating simple interest....");
		float si = accountBalance * 1 * 2.5f / 100;
		return si;
	}

}


