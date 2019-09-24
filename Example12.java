<?xml version="1.0"?>
<config>
<brandName>HisenseTv</brandName>
</config>
import java.xml.parsers.*;       //不懂！！！
import org.w3c.dom.*;            //不懂！！！
import org.xml.sax.SAXException;
import java.io.*;
public class XMLUtilTv{   
	public static String getBrandName() {       //获得商标方法
		try {
			DocumentBuilderFactory dFactory =DocumentBuilderFactory.newInstance();
			DocumentBuilder builder=dFactory.newDocumentBuilder();
			Document doc=builder.parse(new File("configTv.xml"));
			NodList n1=doc.getElementsByTagName("brandName");
			Node classNode=n1.item(0).getFirstChild();
			String brandName=classNode.getNodeValue().trim();
			return brandName;
		}catch(Exception e) {
			System.out.println(e.getMessage());
			return null;
		}
	}
}
public class Main{             //主方法
	public static void main(String args[]) {
		Tv tv;          //创建TV类的对象
		String brandName =XMLUtilTv.getBrandName();   //调用getBrandName()方法获得电视机商标
		tv=TvFactory.produceTv(brandName);
		tv.play();
		}
}
public abstract class Tv{        //创建抽象类TV
	public abstract void play();
}
public class HaierTv extends Tv{    //创建HaierTV类继承自TV抽象类并实现play（）方法
	public void play() {
		System.out.println("This is HaierTv.");
	}
}
public class HisenseTv extends Tv{        //创建HisenseTv类继承自TV抽象类并实现play（）方法
	public void play() {
		System.out.println("This is HisenseTv.");
	}
}
public class TvFactory {              //TV工厂
	public static Tv produceTv(String brand) {
		if(brand.contentEquals("HaierTv"))
			return new HaierTv();
		if(brand.contentEquals("HisenseTv"))
			return new HisenseTv();
		return null;
	}
}
