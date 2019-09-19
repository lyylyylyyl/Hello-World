
public class Students {
	final String name="莉莉";   //final修饰name属性
	public void introduce() {
		System.out.println("我是一个学生，我叫"+name);
	}

}

public class Example07 {

	public static void main(String[] args) {
		// TODO 自动生成的方法存根
		Students stu = new Students();  //创建学生类的实例对象
		stu.introduce();           //调用Students的introduce方法

	}

}
