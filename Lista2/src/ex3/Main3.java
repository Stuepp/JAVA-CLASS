package ex3;

import java.util.ArrayList;
import java.util.Scanner;

public class Main3 {
	private static Scanner s = new Scanner(System.in);
	private static Imobilaria imobilaria = new Imobilaria();
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int menu = 0;
		System.out.println("Digite o nome da imobilaria:");
		imobilaria.setNome(s.nextLine());
		while(menu == 0) {
			System.out.println("(1) Cadastrar Imovel\n(2) Mostrar Imoveis\n(3) Mostrar Imoveis de área >= x");
			int opcao = Integer.parseInt(s.nextLine());
			switch(opcao){
				case 1:
					cadastrarImovel();
					break;
				case 2:
					mostraImoveis();
					break;
				case 3:
					mostraImoveisAreaX();
					break;
				default:
					break;
			}
			System.out.println("Desja continuar?"
					+ "\n(0)Sim\n(1)Não");
			menu = Integer.parseInt(s.nextLine());
		}
	}
	public static void cadastrarImovel() {
		Imovel imovel = new Imovel();
		System.out.println("Digite a largura:");
		imovel.setLargura(Integer.parseInt(s.nextLine()));
		System.out.println("Digite o comprimento:");
		imovel.setComprimento(Integer.parseInt(s.nextLine()));
		imobilaria.addImovel(imovel);
	}
	public static void mostraImoveis() {
		for(int i = 0; i < imobilaria.getImoveis().size(); i++) {
			System.out.println(i);
			System.out.println(imobilaria.toString());
		}
	}
	public static void mostraImoveisAreaX() {
		System.out.println("Digite o tamanho da área que deseja:");
		int area = Integer.parseInt(s.nextLine());
		ArrayList<Imovel> imoveisXarea = new ArrayList<Imovel>();
		imoveisXarea = imobilaria.imoveisDeXArea(area);
		for(int i = 0; i < imoveisXarea.size(); i++) {
			System.out.println(imoveisXarea.get(i).toString());
		}
	}
}
