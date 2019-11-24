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
		
	//ģ��ͨ����¼���� generateCommunicateRecord() 
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
	
	//������ɱ��к���
	private String getCallToPhoneNumber() {
		
		return "1380372"+String.valueOf(new Random().nextInt(10))
		        +String.valueOf(new Random().nextInt(10))
		        +String.valueOf(new Random().nextInt(10))
		        +String.valueOf(new Random().nextInt(10));
	}
	
	//ģ��Ʒ�
	private String accountFee(long timeStart,long timeEnd) {
		int minutes=Math.round((timeEnd-timeStart)/60000);
		double feeTotal=teldif.getRatio()*minutes;
		return String.format("%.4f", feeTotal);
		
	}
	
	//��ӡͨ���嵥
	void printDetails() {
		int arrayListSize=this.communicationRecords.size();
		String allRecords=this.communicationRecords.toString();
		for(int i=0;i<arrayListSize-1;i++) {
			System.err.println("-------"+teldif.toString()+"ͨ����¼�ָ���-------");
			String [] recordField=((String) this.communicationRecords.first()).split(" ");
			
			System.out.println("���У�" + recordField[0]);
			System.out.println("���У�" + recordField[3]);
			Date timeStart = new Date(Long.parseLong(recordField[1]));
			Date timeEnd = new Date(Long.parseLong(recordField[2]));
			DateFormat mediumFormat = DateFormat.getDateTimeInstance(DateFormat.MEDIUM, DateFormat.MEDIUM);
			SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy��MM��dd�� hhʱmm��ss��");

			//mediumFormat��ʽ
			System.out.println("ͨ����ʼʱ�䣺" + mediumFormat.format(timeStart));
			System.out.println("ͨ������ʱ�䣺" + mediumFormat.format(timeEnd));
			System.out.println("�Ʒѣ�" 
					+ accountFee(Long.parseLong(recordField[1]), Long.parseLong(recordField[2]))
					+ " Ԫ��");
		
	  }
//		Iterator it = this.communicationRecords.iterator();
//		while(it.hasNext()) {
//			System.out.println("---------ͨ����¼�ָ���---------");
//			String [] recordField = ((String) it.next()).split(",");
//			System.out.println("���У�" + recordField[0]);
//			System.out.println("���У�" + recordField[3]);
//			Date timeStart = new Date(Long.parseLong(recordField[1]));
//			Date timeEnd = new Date(Long.parseLong(recordField[2]));			
//			SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy��MM��dd�� hhʱmm��ss��");
//			
//			//SimpleDateFormat			
//			System.out.println("ͨ����ʼʱ�䣺" + simpleDateFormat.format(timeStart));
//			System.out.println("ͨ������ʱ�䣺" + simpleDateFormat.format(timeEnd));
//			
//			System.out.println("�Ʒѣ�" 
//					+ accountFee(Long.parseLong(recordField[1]), Long.parseLong(recordField[2]))
//					+ " Ԫ��");
//		}
	}
}
