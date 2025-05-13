package game;

public class Main {
	public static void main(String[] args) {
		System.out.println("Simson Game Starts!");
		
		SimonUI g = new SimonUI();
		g.makeUI();
		g.play();
	}

}
