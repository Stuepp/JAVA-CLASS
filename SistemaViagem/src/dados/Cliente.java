package dados;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Cliente {
	//Atributos
	private int cpf, telefone;
	private String nome, endereco;
	private ArrayList<Reserva> reservas = new ArrayList<Reserva>();
	int reservas_size = 0;
	private Scanner s = new Scanner(System.in);
	//Construtor
	public Cliente() {
		//this.reservas = new Reserva[this.reservai];
	}
	//Getters and Setters
	public int getCpf() {
		return cpf;
	}
	public void setCpf(int cpf) {
		this.cpf = cpf;
	}
	public int getTelefone() {
		return telefone;
	}
	public void setTelefone(int telefone) {
		this.telefone = telefone;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getEndereco() {
		return endereco;
	}
	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}
	public Reserva getReservas(int i) {
		return reservas.get(i);
	}
	public void setReservas(Reserva reserva) {
		//this.reservas[this.reservai] = reservas;
		//this.reservai++;
		reservas.add(reserva);
		this.reservas_size++;
	}
	//metódos
	public void reservarIda(Reserva reserva) {
		Random random = new Random();
		reserva.setNumReserva(random.nextInt(100));
		//
		System.out.println("Digite a data do voo:");
		reserva.setDataVoo(s.nextLine());
		System.out.println("Digite a hora do voo:");
		reserva.setHoraVoo(s.nextLine());
		System.out.println("Escolha a classe que quer para o voo:"
				+ "\n(1) economica"
				+ "\n(2) vip"
				+ "\n(3) delux");
		int classe = Integer.parseInt(s.nextLine());
		System.out.println("Digite o número da poltrona:");
		reserva.setPoltrona(Integer.parseInt(s.nextLine()));
		switch(classe) {
			case 1:
				reserva.setPreco(100);
				break;
			case 2:
				reserva.setPreco(200);
				break;
			case 3:
				reserva.setPreco(300);
				break;
			default:
				break;
		}
		System.out.println("Vai ser ida e volta?"
				+ "\n(1) Sim"
				+ "\n(2) Não");
		int idaEvolta = Integer.parseInt(s.nextLine());
		if(idaEvolta == 1) {
			reserva.setIdaEvolta(true);
			Reserva volta = new Reserva();
			reservarVolta(reserva, volta);
		}else {
			reserva.setIdaEvolta(false);
		}
		setReservas(reserva);
	}
	public void reservarVolta(Reserva ida, Reserva volta) {
		volta.setOrigem(ida.getDestino());
		volta.setDestino(ida.getOrigem());
		//
		Random random = new Random();
		volta.setNumReserva(random.nextInt(100));
		//
		System.out.println("Digite a data do voo:");
		volta.setDataVoo(s.nextLine());
		System.out.println("Digite a hora do voo:");
		volta.setHoraVoo(s.nextLine());
		System.out.println("Escolha a classe que quer para o voo:"
				+ "\n(1) economica"
				+ "\n(2) vip"
				+ "\n(3) delux");
		int classe = Integer.parseInt(s.nextLine());
		System.out.println("Digite o número da poltrona:");
		volta.setPoltrona(Integer.parseInt(s.nextLine()));
		switch(classe) {
			case 1:
				volta.setPreco(100);
				break;
			case 2:
				volta.setPreco(200);
				break;
			case 3:
				volta.setPreco(300);
				break;
			default:
				break;
		}		
		setReservas(volta);
	}
	//toString
	public String toString() {
		String Sreservas = "";
		for(int i = 0; i < this.reservas_size; i++) {
			Sreservas += reservas.get(i).toString();
		}
		return "------Cliente------\n"
				+ "Nome: " + nome + "\n"
				+ "Telefone: " + telefone + "\n"
				+ "CPF: " + cpf + "\n"
				+ "Endereco: " + endereco + "\n"
				+ "Reservas: " + Sreservas + "\n";
	}
}
