package factory;

public class HaierTVFactory implements TVFactory{
	public void play() {
		}
	public class HaierTV extends TV {
	}
	public TV produceTV() {
		return new HaierTV();
	}

}
