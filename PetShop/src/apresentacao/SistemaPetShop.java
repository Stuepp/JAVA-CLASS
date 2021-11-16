package apresentacao;

import java.util.Scanner;

import dados.Animal;
import dados.Dono;
import dados.Endereco;
import dados.Veterinario;

public class SistemaPetShop {
	//Scanner s = new Scanner(System.in);
	//métodos
	public static void cadastrar_vet(Veterinario v) {
		Scanner s = new Scanner(System.in);
		//
		System.out.println("Digite  o nome do veterinario:");
		v.setNome(s.nextLine());
		System.out.println("Digite o salário:");
		v.setSalario(Float.parseFloat(s.nextLine()));
		//
		Endereco e = new Endereco();
		cadastrar_endereco(e);
		v.setEndereco(e);
		//
		for(int i = 0; i < v.getMaxAnimais(); i++) {
			Animal a = new Animal();
			cadastrar_animal(a);
			v.setAnimal(a);
		}
		//s.close();
	}
	public static void mostrar_vet(Veterinario v) {
		System.out.println(v.toString());
	}
	public static void cadastrar_animal(Animal a) {
		Scanner s = new Scanner(System.in);
		//
		System.out.println("Digite o nome do animal:");
		a.setNome(s.nextLine());
		System.out.println("Digite a espécie do animal:");
		a.setEspecie(s.nextLine());
		System.out.println("Digite a descrição:");
		a.setDescricao(s.nextLine());
		//
		Dono d = new Dono();
		cadastrar_dono(d);
		a.setDono(d);
		//
		//s.close();
	}
	public static void mostrar_animal(Animal a) {
		System.out.println(a.toString());
	}
	public static void cadastrar_dono(Dono d) {
		Scanner s = new Scanner(System.in);
		//
		System.out.println("Digite o nome do Dono:");
		d.setNome(s.nextLine());
		System.out.println("Digite o cpf:");
		d.setCpf(Integer.parseInt(s.nextLine()));
		//
		Endereco e = new Endereco();
		cadastrar_endereco(e);
		d.setEndereco(e);
		//
		//s.close();
	}
	public static Endereco cadastrar_endereco(Endereco e) {
		Scanner s = new Scanner(System.in);
		//
		System.out.println("Digite o nome do estado");
		e.setEstado(s.nextLine());
		System.out.println("Digite o nome da cidade:");
		e.setCidade(s.nextLine());
		System.out.println("Digite o nome do bairro:");
		e.setBairro(s.nextLine());
		System.out.println("Digite o nome da rua:");
		e.setRua(s.nextLine());
		System.out.println("Digite o número:");
		e.setNumero(Integer.parseInt(s.nextLine()));
		System.out.println("Digite o cep:");
		e.setCep(Integer.parseInt(s.nextLine()));
		
		//s.close();
		return e;
	}
	public static void mostrar_dono(Dono d) {
		System.out.println(d.toString());
	}
	//main
	public static void main(String[]args) {
		Scanner s = new Scanner(System.in);
		
		System.out.println("Deseja cadastrar um:"
				+ "\nveterinario(1)"
				+ "\nanimal(2)"
				+ "\ndono(3) ?");
		int opcao = Integer.parseInt(s.nextLine());
		switch(opcao) {
			case 1:
				System.out.println("Digite o número de animais que o veterinário cuida:");
				Veterinario v = new Veterinario(Integer.parseInt(s.nextLine()));
				cadastrar_vet(v);
				mostrar_vet(v);
				break;
			case 2:
				Animal a = new Animal();
				cadastrar_animal(a);
				mostrar_animal(a);
				break;
			case 3:
				Dono d = new Dono();
				cadastrar_dono(d);
				mostrar_dono(d);
				break;
		}
		s.close();
	}
}
