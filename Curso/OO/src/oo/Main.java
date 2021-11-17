package oo;

public class Main extends TesteAbstract implements PlayerInterface{
	public static void main(String[]args) {
		new Main().callAbstractMethod();
		
		Player player = new Player(); // novo objeto player
		Player player2 = new Player(); // novo objeto player2
		Enemy enemy = new Enemy(); // novo objeto enemy
		
		player.startPlayer();
		player2.startPlayer();
		enemy.startEnemy();
		new Enemy().startEnemy(); //utilizar a classe apenas uma evez sem
		//estanciar ela / guardar em uma variavel.
		new Main().instanceMain2();
		//TesteAbstract abs = new TesteAbstract();
		new Main().start();
	}
	public void callAbstractMethod() {
		startGame();
	}
	public void instanceMain2(){
		new Main2().print1();
	}
	private class Main2{
		public void print1() {
			System.out.println("Chamando meu método");
		}
	}
	@Override
	public void start() {
		System.out.println("Loading...");
	}
	@Override
	public void die() {
		
	}
	@Override
	public void loseLife() {
		
	}
}
