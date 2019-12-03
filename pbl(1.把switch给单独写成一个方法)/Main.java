package pbl;
import java.util.Enumeration;


public class Main {

	public static void main(String[] args) {
		 
	      Customer c1=new Customer("LiuYuanYuan");
	      c1. addRental(new Rental(new Movie("ÉÙÄêµÄÄã",2),6));
	      String s=c1.statement();
	      System. out.println(s);

	}
	

}
