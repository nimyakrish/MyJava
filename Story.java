package nimya;

import java.time.LocalDate;
import java.util.Arrays;

public class Story {
	public static void main(String[] args) {
		
		/*
		 * COLLEGE DAYS OF JACK
		 */
		Person jack 		= new Person("Jack",LocalDate.of(1988, 3, 10),'M');
		System.out.println("Once there lived "+jack.getName());
		College studCollege = new College();
		Student studJack	= new Student(jack,21,studCollege);
		studJack.goToLibrary();
		ReportCard jackReport =new ReportCard();
		studJack.getSignedByParent(jackReport);
		/*
		 *  LOVE DAYS OF JACK
		 */
		Person rose 	=new Person("Rose",LocalDate.of(1989,4, 5),'F');
		Life love		= new Life();
		love.Love(jack, rose);
		Shirt jacksh 	= new Shirt("Peter England","Pure Cotton",3500);
		studJack.wearShirt(jacksh);
		TwoWheeler jackVehicle	= new TwoWheeler();
		studJack.rideVehicle(jackVehicle);
		Acquarium jackaq 		= new Acquarium();
		jackaq.buyAcquarium(jack);
		Gift jackGift 			= new Gift();
		jackGift.giveGift(jack,rose,"Valentines day");
		Kfc 		datekfc	= new Kfc();
		datekfc.haveKFCSpecial();
		/*
		 * Career of Jack
		 */
		Employee empjack = new Employee(studJack,465,"TCS","Data Analyst");
		//Life
		love.marriage(jack, rose);
		Hotel jackRose =new Hotel();
		jackRose.bookRest();
		jackRose.bookRoom();
		//Career of Rose
		ToyShop toy = new ToyShop();
		toy.openShop(rose);
		FeedbackForm form =new FeedbackForm();
		form.startedFeedback(rose,"customers");
		love.happy(jack,rose);
		
		
		
		
	}

}
class Person{
	private String name;
	private LocalDate dateOfBirth;
	private char gender;
	public Person() {}
	public Person(String name, LocalDate dateOfBirth, char gender) {
		super();
		this.name = name;
		this.dateOfBirth = dateOfBirth;
		this.gender = gender;
	}
	
	public String getName() {
		return name;
	}

	public LocalDate getDateOfBirth() {
		return dateOfBirth;
	}

	public char getGender() {
		return gender;
	}

	//uses A
	void wearShirt(Shirt sh) {
		System.out.println(this.name+" wears "+sh);
	}
	//want to ride in general vehicle
	// but here it is twowheeler inherited class
	//how can add here
	void rideVehicle(TwoWheeler tw) {
		
		System.out.println(this.name+" rides Royal Enfield");
	}
			
}
class Student extends Person{
	College studCollege;
	int rollno;
	Student(Person p,int rollno,College c) {
		super(p.getName(),p.getDateOfBirth(),p.getGender());
		studCollege =c;
		System.out.println(p.getName()+" is "+studCollege);
	}
	ReportCard studentReport;
	//has a Reportcard
	void getSignedByParent(ReportCard repCard){
		System.out.println(this.getName()+" got signed by Parent in Report Card.");
	}
	//uses Library
	void goToLibrary() {
		
		System.out.println(this.getName()+" visit library to read. ");
	}
	
}
class Employee extends Student{
	static Company comp;
	int empno;
	String desig;
	public Employee(Student p,int empno,String compName,String desig){
		super(p,p.rollno,p.studCollege);
		this.empno=empno;
		this.desig=desig;
		System.out.println("Now "+compName+" hired "+p.getName()+" as "+desig);
	}
	static void setCompany(){
		
	}
	
}
class Company{
	
}
class Life{
	//hasA
	Person p;
	void Love(Person a,Person b){
		System.out.println(a.getName()+" loves "+b.getName());
	}
	void marriage(Person a,Person b) {
		System.out.println(a.getName()+" married "+b.getName());
	}
	void happy(Person a,Person b) {
		System.out.println(a.getName()+" and "+b.getName()+" lived happily together.");
	}
		
}
class College{
	String collegeName="MEC";
	String courseName="B TECH CS";
	
	@Override
	public String toString() {
		return "studying in " + collegeName + " for " + courseName ;
	}
	//has A Library
	Library collegeLib;
	//has a student
	Student collegeStud[];
	void addStudent(Student stud) {
		
	}
	//has a teacher
}
class Library{
	//has books
	Book bk;
	void readBook() {
		System.out.println("Read book of "+bk.bookSubj);
	}
}
class Book{
	String bookSubj;
	static private String author;
	private String booktitle;
	private float price;
	
}
class ReportCard{
	String[] subject;
	int[] marks;
	boolean result;
		
}
class Shirt{
	String shirtBrand;
	String shirtCloth;
	float shirtPrice;
	@Override
	public String toString() {
		return "Shirt [shirtBrand=" + shirtBrand + ", shirtCloth=" + shirtCloth + ", shirtPrice=" + shirtPrice + "]";
	}
	public Shirt(String shirtBrand, String shirtCloth, float shirtPrice) {
		super();
		this.shirtBrand = shirtBrand;
		this.shirtCloth = shirtCloth;
		this.shirtPrice = shirtPrice;
	}
	
	
}
class Vehicle{
	
}
class TwoWheeler extends Vehicle{
	public TwoWheeler() {
		// TODO Auto-generated constructor stub
		
	}
	
}
class Acquarium{
	void buyAcquarium(Person abc) {
		System.out.println(abc.getName()+" Bought an Acquarium .");
	}
}
class Gift{
	void giveGift(Person a,Person b,String occassion) {
		System.out.println(a.getName()+" gifted this to "+b.getName()+" on "+occassion);
	}
}
class FoodRestaurant{
	public FoodRestaurant() {
		// TODO Auto-generated constructor stub
		System.out.println("Having grand food in a Restaurant.");
	}
	
}
class Bill{
	
	Bill(){
		System.out.println("Bill is paid.");
	}
	
}
class Hotel{
	//has rest
	FoodRestaurant foodrest;
	Room holydayroom;
	Bill bookRest() {
		this.foodrest=new FoodRestaurant();
		Bill b=new Bill();
		return b;
		
	}
	Bill bookRoom() {
		this.holydayroom=new Room();
		Bill b=new Bill();
		return b;
		
	}
	
}
class Room{
	String place="Shimla";
	Room(){
		System.out.println("Booked Holyday room at "+place);
	}
	
}
class Restaurant{
}
class Kfc extends Restaurant{
	void haveKFCSpecial() {
		System.out.println("Having tasty KFC dishes.");
	}
}
class Trading{
	
}
class ToyShop extends Trading{
	void openShop(Person p) {
		System.out.println(p.getName()+" started Toy Shop.");
	}
}
class FeedbackForm {
	public void startedFeedback(Person p,String from) {
		System.out.println("For better cutomer service "+p.getName()+" started taking feedback from "+from);
	}
}
