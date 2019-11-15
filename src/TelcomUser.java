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
	//ģ��ͨ����¼���� generateCommunicateRecord() 
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
	
	//������ɱ��к���
	private String getCallToPhoneNumber() {
		
		return "1380372"+String.valueOf(new Random().nextInt(10))
		        +String.valueOf(new Random().nextInt(10))
		        +String.valueOf(new Random().nextInt(10))
		        +String.valueOf(new Random().nextInt(10));
	}
	
	//ģ��Ʒ�
	private String accountFee(long timeStart,long timeEnd) {
		double feePerMinute=0.2;
		int minutes=Math.round((timeEnd-timeStart)/60000);
		double feeTotal=feePerMinute*minutes;
		
		return String.format("%.4f", feeTotal);
		
		
	}
	
	//��ӡͨ���嵥
	void printDetails() {
		String allRecords=this.communicationRecords.toString();
		String [] recordArray=allRecords.split(";");
		for(int i=0;i<recordArray.length;i++) {
			String [] recordField=recordArray[i].split(" ");
			System.out.println("---------ͨ����¼�ָ���---------");
			System.out.println("���У�" + recordField[0]);
			System.out.println("���У�" + recordField[3]);
			Date timeStart = new Date(Long.parseLong(recordField[1]));
			Date timeEnd = new Date(Long.parseLong(recordField[2]));
			DateFormat mediumFormat = DateFormat.getDateTimeInstance(DateFormat.MEDIUM, DateFormat.MEDIUM);
			SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy��MM��dd�� hhʱmm��ss��");
            //simpleDateFormat��ʽ
//			System.out.println("ͨ����ʼʱ�䣺" + simpleDateFormat.format(timeStart));
//			System.out.println("ͨ������ʱ�䣺" + simpleDateFormat.format(timeEnd));
			
			//mediumFormat��ʽ
			System.out.println("ͨ����ʼʱ�䣺" + mediumFormat.format(timeStart));
			System.out.println("ͨ������ʱ�䣺" + mediumFormat.format(timeEnd));
			
//			//fullFortmat��ʽ
//			System.out.println("ͨ����ʼʱ�䣺" + longFortmat.format(timeStart));
//			System.out.println("ͨ������ʱ�䣺" + longFortmat.format(timeEnd));
			
			System.out.println("�Ʒѣ�" 
					+ accountFee(Long.parseLong(recordField[1]), Long.parseLong(recordField[2]))
					+ " Ԫ��");
		}
		
	}

}
