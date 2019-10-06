package DAZY;

public class Student {
	private String name;
	private String num;
	public String getname() {
		return name;
	}
	public void setname(String stuzh) {
		name=stuzh;
	}
	public String getnum() {
		return num;
	}
	public void setnum(String stuname) {
		num=stuname;
	}
	public void PR() {
		System.out.println("我叫"+name+"，我的学号是"+num);
	}

}
