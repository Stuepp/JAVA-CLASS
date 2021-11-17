package metodosoo;

public class Player {
	//Atributos
	private int[] numeros;
	private String name = "Arthur";
	public static final int VIDA_MAXIMA = 100;//constante
	private int life = VIDA_MAXIMA;
	//Construtor -> métodos que carregam quando se instancia a classe.
	public Player() {
		numeros = new int[3];
		life = 100;
		born();
	}
	//Getters and Setters
	public String getName() {
		return name;
	}
	//Métodos 
	private void born() {
		System.out.println("The player has been born!");
		System.out.println("PLayer life: " + life + "\nPlayer name: " + name);
	}
}
