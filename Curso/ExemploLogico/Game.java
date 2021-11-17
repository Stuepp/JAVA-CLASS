package exemplologico;

public class Game {
	//Atributos
	private Player player;
	private Enemy enemy;
	//Construtor
	public Game() {
		//player = new Player();
		player = new Tipo1();
		if(player instanceof Tipo1) {
			
		}else if(player instanceof Player) {
			
		}
		enemy = new Enemy();
	}
	//Getters
	public Player getPlayer() {
		return player;
	}
	public Enemy getEnemy() {
		return enemy;
	}
	
	public static void main(String[]args) {
		Game game = new Game();
		Player player = game.getPlayer();
		player.attackEnemy(game.getEnemy());
		System.out.println(game.getEnemy().life);
	}
}
