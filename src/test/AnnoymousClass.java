package test;

interface Action{
	void eat();
	
	void play();
	
	void sleep();
}

public class AnnoymousClass {

	public static void main(String[] args) {
		
		Action action = new Action() {

			@Override
			public void eat() {
				System.out.println("먹다");
			}

			@Override
			public void play() {
				System.out.println("놀다");
			}

			@Override
			public void sleep() {
				System.out.println("자다");
			}
		};
		
		action.eat();
	}
}
