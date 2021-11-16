package apresentacao;

import java.util.Scanner;

import dados.*;
import negocio.Zoologico;

public class Main {

	private static Zoologico zoo = new Zoologico();
	private static Scanner s = new Scanner(System.in);	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int menu = 0;
		while(menu == 0) {
			System.out.println("1 cadastra viveiro\n2 cadastra animal"
					+ "\n3 mostrar viveiros\n4 mostrar animais");
			int opcao = Integer.parseInt(s.nextLine());
			switch (opcao) {
            case 0:
                break;
            case 1:
                cadastrarViveiro();
                break;
            case 2:
                cadastrarAnimal();
                break;
            case 3:
                mostrarViveiros();
                break;
            case 4:
                mostrarAnimais();
                break;
            default:
            	break;
        }			
			System.out.println("Deseja continuar?"
					+ "\n(0)sim\n(1)Não");
			menu = Integer.parseInt(s.nextLine());
		}
	}
	public static void cadastrarViveiro() {
		System.out.println("Deseja cadastrar um:"
				+ "\n(1)Viveiro"
				+ "\n(2)Aquário");
		int opcao = Integer.parseInt(s.nextLine());
		if(opcao == 1) {
			novoViveiro();
		}
		if(opcao == 2) {
			novoAquario();
		}
	}
	public static void novoViveiro() {
		Viveiro viveiro = new Viveiro();
		System.out.println("Digite o nome do viveiro:");
		viveiro.setNome(s.nextLine());
		System.out.println("Digite o comprimento do viveiro:");
		viveiro.setComprimento(Float.parseFloat(s.nextLine()));
		zoo.cadastrarViveiro(viveiro);
		System.out.println("Digite a largura do viveiro:");
		viveiro.setLargura(Float.parseFloat(s.nextLine()));
		
		zoo.cadastrarViveiro(viveiro);
	}
	public static void novoAquario() {
		Aquario aquario = new Aquario();
		System.out.println("Digite o nome do aquário:");
		aquario.setNome(s.nextLine());
		System.out.println("Digite o comprimenro do aquário:");
		aquario.setComprimento(Float.parseFloat(s.nextLine()));
		System.out.println("Digite a largura do aquário:");
		aquario.setLargura(Float.parseFloat(s.nextLine()));
		System.out.println("Digite a temperatura:");
		aquario.setTemperatura(Float.parseFloat(s.nextLine()));
		
		zoo.cadastrarViveiro(aquario);
	}
	public static void cadastrarAnimal() {
		System.out.println("Tipo de animal:"
				+ "\n(1) qualquer"
				+ "\n(2) peixe");
		int opcao = Integer.parseInt(s.nextLine());
		if(opcao == 1) {
			novoAnimal();
		}
		if(opcao == 2) {
			novoPeixe();
		}
	}
	public static void novoAnimal() {
		Animal animal = new Animal();
		System.out.println("Digite o nome do animal:");
		animal.setNome(s.nextLine());
		System.out.println("Digite a cor do animal:");
		animal.setCor(s.nextLine());
		System.out.println("Digite a especia do animal:");
		animal.setEspecie(s.nextLine());
		System.out.println("Digite a idade do animal:");
		animal.setIdade(Integer.parseInt(s.nextLine()));
		System.out.println("Digite a largura do animal:");
		animal.setLargura(Float.parseFloat(s.nextLine()));
		System.out.println("Digite o comprimento do animal:");
		animal.setComprimento(Float.parseFloat(s.nextLine()));
		System.out.println("Digite a altura do animal:");
		animal.setAltura(Float.parseFloat(s.nextLine()));
		
		int ok = 0;
		while(ok == 0) {
			mostrarSoViveiros();
			int num;
			do {
				System.out.println("Digite o número do aquário:");
				num = Integer.parseInt(s.nextLine());
			}while(num > zoo.getSoAquarios().size());
			if(zoo.getSoAquarios().get(num).espacoDisponivel() >= animal.calculaEspacoOcupado()) {
				zoo.cadastrarAnimal(animal);
				ok = 1;
			}else {
				System.out.println("Sem espaço no áquario, escolha outro aquário");
			}
		}
	}
	public static void novoPeixe() {
		Peixe peixe = new Peixe();
		System.out.println("Digite o nome do peixe:");
		peixe.setNome(s.nextLine());
		System.out.println("Digite a cor do peixe:");
		peixe.setCor(s.nextLine());
		System.out.println("Digite a especia do peixe:");
		peixe.setEspecie(s.nextLine());
		System.out.println("Digite a idade do peixe:");
		peixe.setIdade(Integer.parseInt(s.nextLine()));
		System.out.println("Digite a largura do peixe:");
		peixe.setLargura(Float.parseFloat(s.nextLine()));
		System.out.println("Digite o comprimento do peixe:");
		peixe.setComprimento(Float.parseFloat(s.nextLine()));
		System.out.println("Digite a altura do peixe:");
		peixe.setAltura(Float.parseFloat(s.nextLine()));
		System.out.println("Digite a temperatura ideal do peixe:");
		peixe.setTemperaturaIdeal(Float.parseFloat(s.nextLine()));
		
		int ok = 0;
		while(ok == 0) {
			mostrarSoAquarios();
			int num;
			do {
				System.out.println("Digite o número do aquário:");
				num = Integer.parseInt(s.nextLine());
			}while(num > zoo.getSoAquarios().size());
			if(zoo.getSoAquarios().get(num).espacoDisponivel() >= peixe.EspacoOcupado()) {
				zoo.cadastrarAnimal(peixe);
				ok = 1;
			}else {
				System.out.println("Sem espaço no áquario, escolha outro aquário");
			}
		}
	}
	public static void mostrarViveiros() {
		for(int i = 0; i < zoo.getViveiros().size(); i++) {
			System.out.println(zoo.getViveiros().get(i).getNome());
		}
	}
	public static void mostrarAnimais() {
		for(int i = 0; i < zoo.getAnimais().size(); i++) {
			System.out.println(zoo.getAnimais().get(i).getNome());
		}
	}
	public static void mostrarSoViveiros() {
		for(int i = 0; i < zoo.getSoViveiros().size(); i++) {
			System.out.println(i+" "+zoo.getSoViveiros().get(i).getNome());
		}
	}
	public static void mostrarSoAquarios() {
		for(int i = 0; i < zoo.getSoAquarios().size(); i++) {
			System.out.println(i+" "+zoo.getSoAquarios().get(i).getNome());
		}
	}
}
