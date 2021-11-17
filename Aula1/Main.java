package aula01;

public class Main {
	public static void main(String[]args) {
		System.out.println("Welcome to the first class of DankiCode!!");
		//variaveis
		int idade = 24;
		System.out.println("A idade é: "+ idade);
		String texto = "Eu sou um texto";
		System.out.println(texto);
		char letra = 'a';
		System.out.println(letra);
		boolean simNao = true;
		double real = 2.5;
		System.out.println(simNao);
		System.out.println(!simNao);
		System.out.println(real);
		//constantes
		final int num_fixo = 10;
		System.out.println(num_fixo);
		//array
		String[] nome = new String[5];
		nome[0] = "nome1";
		nome[1] = "nome1";
		nome[2] = "nome2";
		nome[3] = "nome3";
		nome[4] = "nome4";
		nome[5] = "nome5";
		//array multidimensional
		String[][] array_multi = new String[2][2];
		array_multi[0][0] = "bundinha";		
	}
}
