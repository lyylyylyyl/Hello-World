import java.util.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import factory.*;
import teldif.*;
import utility.*;
import java.util.*;

public class TelcomUser {
	Factory telFactory=(Factory)XMLUtility.getBean();
	TelDif teldif=telFactory.producetel();
	private String phoneNumber;
	private String callTo;
	private ArrayList communicationRecords;
	//private HashMap singleRecord;
	private LinkedHashMap singleRecord;
	
	public TelcomUser(String phoneNumber) {
		this.phoneNumber=phoneNumber;
		this.communicationRecords=new ArrayList();
		}
	public void generateCommunicateRecord() {
		int recordNum=new Random().nextInt(10);
		for(int i=1;i<=recordNum;i++) {
			long timeStart=System.currentTimeMillis()-new Random().nextInt(36000000);
			long timeEnd=timeStart+60000+new Random().nextInt(600000);
			this.singleRecord=new LinkedHashMap();
			this.singleRecord.put("主叫", this.phoneNumber);
			this.singleRecord.put("开始时间",new Date(timeStart));
			this.singleRecord.put("结束时间",new Date(timeEnd));
			this.singleRecord.put("被叫号码", this.getCallToPhoneNumber());
			this.singleRecord.put("计费",this.accountFee(timeStart, timeEnd));
			this.communicationRecords.add(this.singleRecord);
		}
		
	}
	void printDetails() {
		Iterator itRecords = this.communicationRecords.iterator();
		while(itRecords.hasNext()) {
			System.out.println("---------通话记录分割线---------");
			this.singleRecord=((LinkedHashMap)itRecords.next());
//			Set keySet=this.singleRecord.keySet();
//			Iterator itSet=keySet.iterator();
//			while(itSet.hasNext()) {
//				Object key=itSet.next();
//				Object value=this.singleRecord.get(key);
//				System.out.println(key+":"+value);
//				
//			}
			Set entrySet=this.singleRecord.entrySet();
			Iterator itEntry=entrySet.iterator();
			while(itEntry.hasNext()) {
				Map.Entry entry=(Map.Entry)itEntry.next();
				Object key=entry.getKey();
				Object value=entry.getValue();
				System.out.println(key+":"+value);
			}
		}
	}
	private String accountFee(long timeStart,long timeEnd) {
		int minutes=Math.round((timeEnd-timeStart)/60000);
		double feeTotal=teldif.getRatio()*minutes;
		return String.format("%.4f", feeTotal);
		
	}
private String getCallToPhoneNumber() {
		
		return "1380372"+String.valueOf(new Random().nextInt(10))
		        +String.valueOf(new Random().nextInt(10))
		        +String.valueOf(new Random().nextInt(10))
		        +String.valueOf(new Random().nextInt(10));
	}
}
