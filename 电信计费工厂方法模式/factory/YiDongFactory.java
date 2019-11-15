package factory;
import teldif.*;

public class YiDongFactory implements Factory{
	public TelDif producetel() {
		return new YiDong();
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