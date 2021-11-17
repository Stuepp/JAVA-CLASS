package exemplologico;

public class Player {
	private int life = 100;
	
	public void attackEnemy(Enemy enemy) {
		enemy.life--;
	}
}
