
 class Student1 {
	private String id;
	private String name;
	public Student1(String id,String name) {
		this.id=id;
		this.name=name;
	}
	public String toString() {
		return id+":"+name;
	}
	public int hashCode() {
		return id.hashCode();
	}
	public boolean equals(Object obj) {
		
		if(this==obj) {
			return true;
		}
		if(!(obj instanceof Student1)) {
			return false;
		}
		Student1 stu=(Student1)obj;
		boolean b=this.id.equals(stu.id);
		return b;
	}

}
import java.util.*;

public class Example0 {

	public static void main(String[] args) {
		// TODO 自动生成的方法存根
		HashSet hs=new HashSet();
		Student1 stu1=new Student1("1","Jack");
		Student1 stu2=new Student1("2","Rose");
		Student1 stu3=new Student1("2","Rose");
		hs.add(stu1);
		hs.add(stu2);
		hs.add(stu3);
		System.out.println(hs);

	}

}
