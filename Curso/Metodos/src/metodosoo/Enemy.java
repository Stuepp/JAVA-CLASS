package metodosoo;

public class Enemy {
	//Atributos
	private int life;
	//Construtor
	public Enemy(int maxlife,int speed,int damage,String name) {
		born(name, maxlife);
	}
	private void born(String name, int life) {
		System.out.println("The Enemy has been born!");
		System.out.println("Enemy Name: "+name+"\nEnemy Life: "+life);
	}
}
