package utility;
import factory.*;
import factory.TVFactory.TV;
import Tvv.*;

public class Main {

	public static void main(String[] args) {
	TV tv;
    TVFactory factory;
    HaierTv hr=new HaierTv();
    factory=(TVFactory)hr;
	HisenseTv hs=new HisenseTv();
	tv=factory.produceTV();
	tv.play();
	//hs.play();
	//hr.play();
	
	}

}
