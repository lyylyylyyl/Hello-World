class Student {
	private String name;
	private int grade;
	public String getName() {
		return name;
	}
	public void setName(String stuName) {
		name=stuName;
	}
	public int getGrade() {
		return grade;
	}
	public void setGrade(int stuGrade) {
		if(stuGrade<0) {
			System.out.println("����ɼ�Ϊ��������");
		}else {
			grade=stuGrade;
		}
	}
	public void introduce() {
		System.out.println("�ҽ�"+name+"���ɼ�Ϊ"+grade);
	}

}
public class Example01 {

	public static void main(String[] args) {
		Student stu=new Student();
		stu.setName("����");
		stu.setGrade(99);
		stu.introduce();

	}

}