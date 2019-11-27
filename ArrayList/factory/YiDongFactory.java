package factory;
import teldif.*;

public class YiDongFactory implements Factory{
	public TelDif producetel() {
		return new LianTong();
	}

}