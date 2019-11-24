import java.util.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import factory.*;
import teldif.*;
import utility.*;
import java.util.*;

public class TelcomUser {
	private String phoneNumber;
	private String callTo;
	//private HashSet communicationRecords;
	private TreeSet communicationRecords;
	Factory telFactory=(Factory)XMLUtility.getBean();
	TelDif teldif=telFactory.producetel();
	public TelcomUser(String phoneNumber) {
		this.phoneNumber=phoneNumber;
		this.communicationRecords=new TreeSet();
		//this.communicationRecords=new HashSet();
		}
		
	//模拟通话记录生成 generateCommunicateRecord() 
	public void generateCommunicateRecord() {
		int recordNum=new Random().nextInt(10);
		for(int i=1;i<=recordNum;i++) {
			long timeStart=System.currentTimeMillis()-new Random().nextInt(36000000);
			long timeEnd=timeStart+60000+new Random().nextInt(600000);
			
			//this.callTo=getCallToPhoneNumber();
			
			this.communicationRecords.add(this.phoneNumber+
					" "+timeStart+
					" "+timeEnd+
					" "+this.getCallToPhoneNumber()+
					";"
					);
			
		}
		
	}
	
	//随机生成被叫号码
	private String getCallToPhoneNumber() {
		
		return "1380372"+String.valueOf(new Random().nextInt(10))
		        +String.valueOf(new Random().nextInt(10))
		        +String.valueOf(new Random().nextInt(10))
		        +String.valueOf(new Random().nextInt(10));
	}
	
	//模拟计费
	private String accountFee(long timeStart,long timeEnd) {
		int minutes=Math.round((timeEnd-timeStart)/60000);
		double feeTotal=teldif.getRatio()*minutes;
		return String.format("%.4f", feeTotal);
		
	}
	
	//打印通话清单
	void printDetails() {
		int arrayListSize=this.communicationRecords.size();
		String allRecords=this.communicationRecords.toString();
		for(int i=0;i<arrayListSize-1;i++) {
			System.err.println("-------"+teldif.toString()+"通话记录分割线-------");
			String [] recordField=((String) this.communicationRecords.first()).split(" ");
			
			System.out.println("主叫：" + recordField[0]);
			System.out.println("被叫：" + recordField[3]);
			Date timeStart = new Date(Long.parseLong(recordField[1]));
			Date timeEnd = new Date(Long.parseLong(recordField[2]));
			DateFormat mediumFormat = DateFormat.getDateTimeInstance(DateFormat.MEDIUM, DateFormat.MEDIUM);
			SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy年MM月dd日 hh时mm分ss秒");

			//mediumFormat格式
			System.out.println("通话开始时间：" + mediumFormat.format(timeStart));
			System.out.println("通话结束时间：" + mediumFormat.format(timeEnd));
			System.out.println("计费：" 
					+ accountFee(Long.parseLong(recordField[1]), Long.parseLong(recordField[2]))
					+ " 元。");
		
	  }
//		Iterator it = this.communicationRecords.iterator();
//		while(it.hasNext()) {
//			System.out.println("---------通话记录分割线---------");
//			String [] recordField = ((String) it.next()).split(",");
//			System.out.println("主叫：" + recordField[0]);
//			System.out.println("被叫：" + recordField[3]);
//			Date timeStart = new Date(Long.parseLong(recordField[1]));
//			Date timeEnd = new Date(Long.parseLong(recordField[2]));			
//			SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy年MM月dd日 hh时mm分ss秒");
//			
//			//SimpleDateFormat			
//			System.out.println("通话开始时间：" + simpleDateFormat.format(timeStart));
//			System.out.println("通话结束时间：" + simpleDateFormat.format(timeEnd));
//			
//			System.out.println("计费：" 
//					+ accountFee(Long.parseLong(recordField[1]), Long.parseLong(recordField[2]))
//					+ " 元。");
//		}
	}
}
