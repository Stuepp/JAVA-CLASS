package apresentacao;
import negocio.*;

import java.util.ArrayList;
import java.util.Scanner;
import dados.*;

public class Principal {
	static ReservaPassagem rp = new ReservaPassagem();
	
	public static void fazerReserva() {
		Cliente cliente = new Cliente();
		rp.cadastrarCliente(cliente);
		Reserva reserva = new Reserva();
		rp.reservarIda(cliente, reserva);
	}
	public static void cadastrarCliente() {
		Cliente cliente = new Cliente();
		rp.cadastrarCliente(cliente);
	}
	public static void cadastrarCidade() {
		Cidade cidade = new Cidade();
		rp.cadastrarCidade(cidade);
	}
	public static void mostrarReservas() {
		//achei meio confuso pois temos mostrar Reservas | Clientes | Cidades
		//para me manter fiel a UML e não ter feito função que não são usadas
		//optei por este método ter a opção de chamar as outras funções
		Scanner scan = new Scanner(System.in);
		System.out.println("Deseja ver?"
				+ "\n(1) Reservas do cliente"
				+ "\n(2) os clientes"
				+ "\n(3) as cidades");
		int escolha = Integer.parseInt(scan.nextLine());
		switch(escolha) {
			case 1:
				/*System.out.println("Digite o cpf do cliente:");
				int clienteCpf = Integer.parseInt(scan.nextLine());*/
				System.out.println("Desculpe função não finalizada"
						+ "\nmotivo: fazer uma busca do cpf do cliente na"
						+ " arraylist e então pegar esse clinte e retornar"
						+ " suas reservas");
				
				/*
				ArrayList<Reserva> reservas = new ArrayList<Reserva>(); 
				rp.mostrarReservas(clienteCpf);
				for(Reserva r : reservas) {
					System.out.println(r.toString());
				}*/
				break;
			case 2:
				ArrayList<Cliente> clientes = new ArrayList<Cliente>(); 
				clientes = rp.mostrarClientes();
				for(Cliente c : clientes) {
					System.out.println(c.toString());
				}
				break;
			case 3:
				ArrayList<Cidade> cidades = new ArrayList<Cidade>();
				cidades = rp.mostrarCidades();
				for(Cidade c : cidades) {
					System.out.println(c.toString());
				}
				break;
			default:
				break;
		}

		scan.close();
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner s = new Scanner(System.in);
		System.out.println("-----Menu-----"
				+ "\n(1) fazer reserva"
				+ "\n(2) cadastrar cliente"
				+ "\n(3) cadastrar cidade"
				+ "\n(4) mostrar Reservas");
		int escolha = Integer.parseInt(s.nextLine());
		switch(escolha) {
		case 1:
			fazerReserva();
			break;
		case 2:
			cadastrarCliente();
			break;
		case 3:
			cadastrarCidade();
			break;
		case 4:
			mostrarReservas();
			break;
		default:
			break;
		}
		mostrarReservas();
		s.close();
	}

}
