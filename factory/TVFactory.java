package factory;

public interface TVFactory {
	public class TV {
		public void play() {
			System.out.println("tv");
		}
	}
	public TV produceTV();

}
