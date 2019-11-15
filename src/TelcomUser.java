import java.util.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

public class TelcomUser {
	private String phoneNumber;
	private String callTo;
	private StringBuffer communicationRecords;
	public TelcomUser(String phoneNumber) {
		this.phoneNumber=phoneNumber;
		this.communicationRecords=new StringBuffer();
		
	}
	//模拟通话记录生成 generateCommunicateRecord() 
	public void generateCommunicateRecord() {
		int recordNum=new Random().nextInt(10);
		for(int i=1;i<=recordNum;i++) {
			long timeStart=System.currentTimeMillis()-new Random().nextInt(36000000);
			long timeEnd=timeStart+60000+new Random().nextInt(600000);
			
			//this.callTo=getCallToPhoneNumber();
			
			this.communicationRecords.append(this.phoneNumber+
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
		double feePerMinute=0.2;
		int minutes=Math.round((timeEnd-timeStart)/60000);
		double feeTotal=feePerMinute*minutes;
		
		return String.format("%.4f", feeTotal);
		
		
	}
	
	//打印通话清单
	void printDetails() {
		String allRecords=this.communicationRecords.toString();
		String [] recordArray=allRecords.split(";");
		for(int i=0;i<recordArray.length;i++) {
			String [] recordField=recordArray[i].split(" ");
			System.out.println("---------通话记录分割线---------");
			System.out.println("主叫：" + recordField[0]);
			System.out.println("被叫：" + recordField[3]);
			Date timeStart = new Date(Long.parseLong(recordField[1]));
			Date timeEnd = new Date(Long.parseLong(recordField[2]));
			DateFormat mediumFormat = DateFormat.getDateTimeInstance(DateFormat.MEDIUM, DateFormat.MEDIUM);
			SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy年MM月dd日 hh时mm分ss秒");
            //simpleDateFormat格式
//			System.out.println("通话开始时间：" + simpleDateFormat.format(timeStart));
//			System.out.println("通话结束时间：" + simpleDateFormat.format(timeEnd));
			
			//mediumFormat格式
			System.out.println("通话开始时间：" + mediumFormat.format(timeStart));
			System.out.println("通话结束时间：" + mediumFormat.format(timeEnd));
			
//			//fullFortmat格式
//			System.out.println("通话开始时间：" + longFortmat.format(timeStart));
//			System.out.println("通话结束时间：" + longFortmat.format(timeEnd));
			
			System.out.println("计费：" 
					+ accountFee(Long.parseLong(recordField[1]), Long.parseLong(recordField[2]))
					+ " 元。");
		}
		
	}

}
