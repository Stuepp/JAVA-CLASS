package metodosoo;

public class Main extends Enemy{
	public Main() {
		super(100,10,10,"Thomas a bomba thermonuclear");//int maxlife,int speed,int damage,String name
	}
	private static int exemplo() {
		return 5;
	}
	private static String exemplo2() {
		return "Arthur";
	}
	public void outrometodo(int n[], String[] nome) {
		System.out.println(n[0] + " " + nome[0]);
	}
	public static void main(String[]args) {
		Player player = new Player();
		//player.born(); método born é acessível apenas para a classe Player
		//não é acessivel nem com extends
		/*
		 * public é público
		 * private é apenas para a classe
		 * protecetd precisa de extends
		 * static é independente não vai ser chamado
		 * só se Main main = new Main();
		 * ou main(); pois java vai entender e vai ficar em itálico
		*/
		System.out.println(exemplo());
		System.out.println(exemplo2());
		int[] n = new int[10];
		n[0] = 10;
		//new Main().outrometodo(n, null); da problema o null quando é array
		n[1] = 5;
		String[] beniso = new String[3];
		beniso[0] = "Ben";
		beniso[1] = "nico";
		beniso[2] = "nico ni";
		new Main().outrometodo(n, beniso);
	}
}
