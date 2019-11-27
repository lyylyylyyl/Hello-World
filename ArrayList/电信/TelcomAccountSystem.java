package µÁ–≈;

import teldif.*;
import factory.*;
import utility.XMLUtility;

public class TelcomAccountSystem {

	public static void main(String[] args) {
		
		TelDif tel;
		Factory factory;
		factory = (Factory)XMLUtility.getBean();
		tel=factory.producetel();
		TelcomUser telcomUser=new TelcomUser("15837206666");
		telcomUser.generateCommunicateRecord();
		telcomUser.printDetails();
				

	}

}