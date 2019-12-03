package pbl;
import java.util.Enumeration;
import java.util.Vector;

class Customer{
	private String _name;
	private Vector _rentals = new Vector();
	public Customer(String name){
		_name = name;
	};
	public void addRental(Rental arg){
		_rentals.addElement(arg);
	}
	public String getName (){
		return _name;
	}
	public String statement(){
		double totalAmount=0;
		int frequentRenterPoints=0;
		Enumeration rentals=_rentals.elements();
		String  result="Rental Record for "+getName()+"\n";
		while(rentals.hasMoreElements()){
			Rental each =(Rental)rentals.nextElement();
			//double thisAmount=0;  //去除该变量
			//thisAmount=each.getCharge();     //第一次修改
			
			frequentRenterPoints+=each.getFrequentRenterPoints();
			
			result+="\t"+each.getMovie().getTitle()+"\t"+String.valueOf(each.getCharge())+"\n";
			totalAmount+=each.getCharge();
			
		}
		result+="Amount owed is "+String.valueOf(getTotalCharge())+"\n";
		result+="You earned "+String.valueOf(getTotalFrequentRenterPoints())+" frequent renter points";
		return result;
	}
	private int getTotalFrequentRenterPoints() {
		int result=0;
		Enumeration rentals=_rentals.elements();
		while(rentals.hasMoreElements()){
			Rental each =(Rental)rentals.nextElement();
			result+=each.getCharge();}
		return result;
	}
	private double getTotalCharge() {
		double result=0;
		Enumeration rentals=_rentals.elements();
		while(rentals.hasMoreElements()){
			Rental each =(Rental)rentals.nextElement();
			result+=each.getCharge();}
		return result;
	}
	private double amountFor(Rental aRental) {
		return aRental.getCharge();
	}
}