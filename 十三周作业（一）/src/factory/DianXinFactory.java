package factory;
import teldif.*;


public class DianXinFactory implements Factory{
	public TelDif producetel() {
		return new DianXin();
	}

}
//package factory;
//import teldif.*;
//
//public class LianTongFactory implements Factory{
//	public TelDif producetel() {
//		return new LianTong();
//	}
//
//}
