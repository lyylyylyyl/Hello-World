package factory;

public class HisenseTVFactory implements TVFactory{
	public class HisenseTV extends TV {
	}
	public TV produceTV() {
		return new HisenseTV();
	}

}
