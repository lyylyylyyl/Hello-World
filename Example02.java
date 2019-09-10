class Father{
	private String name="zhangjun";
	class Child{
		void introFather() {
			System.out.println("My Father is "+name);
		}
	}
	
}
class Example02{
	public static void main(String[] args) {
		Father.Child ch=new Father().new Child();
		ch.introFather();
	}
}