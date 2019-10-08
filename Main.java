import tv.*;
import factory.*;
import utility.*;
public class Main{
	public static void main(String args[]) {
		Tv tv;
		TVFactory factory;
		factory=(TVFactory)XMLUtil.getBean();
		tv=factory.produceTv();
		tv.play();
		}
}