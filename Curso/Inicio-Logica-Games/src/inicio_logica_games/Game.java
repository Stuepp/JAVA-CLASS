package inicio_logica_games;

import java.util.ArrayList;

public class Game implements Runnable{
	//Atributos
	public boolean isRunnning;
	private Thread thread;
	private ArrayList<Entity> entities = new ArrayList<>();
	//Construtor
	public Game() {
		entities.add(new Entity());
	}
	//main
	public static void main(String[]args) {
		Game game = new Game();
		game.start();
	}
	//Métodos
	public synchronized void start() {
		isRunnning = true;
		thread = new Thread(this);
		thread.start();
	}
	public void update() {//atalizar o jogo
		System.out.println("Tick");
	}
	public void render() {//renderizar o jogo
		System.out.println("Render");
	}
	@Override
	public void run() {
		while(isRunnning) {
			update();
			render();
			/*
			try {
				Thread.sleep(1000);
			} catch(InterruptedException e) {
				e.printStackTrace();
			}
			*/
		}
	}
}
