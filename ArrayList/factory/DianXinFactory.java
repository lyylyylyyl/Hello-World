package factory;
import teldif.*;


public class DianXinFactory implements Factory{
	public TelDif producetel() {
		return new DianXin();
	}

}
