package negocio;
import java.util.ArrayList;
import java.util.Scanner;
import dados.*;

public class ReservaPassagem {
	
	Scanner s = new Scanner(System.in);
	private ArrayList<Cliente> listadeclientes = new ArrayList<Cliente>();
	private ArrayList<Cidade> listadecidades = new ArrayList<Cidade>();
	
	public void cadastrarCidade(Cidade cidade) {
		System.out.println("Digite o nome da cidade: ");
		cidade.setNome(s.nextLine());
		System.out.println("Digite o nome do estado da cidade: ");
		cidade.setEstado(s.nextLine());
		listadecidades.add(cidade);
	}
	public void cadastrarCliente(Cliente cliente) {
		System.out.println("Digite o nome do cliente: ");
		cliente.setNome(s.nextLine());
		System.out.println("Digite o cpf do(a) Sr(a) "+cliente.getNome()+": ");
		cliente.setCpf(Integer.parseInt(s.nextLine()));
		//cpf é muito grande é da erro, quis manter como int para seguir a UML
		//possível solução: unsigned int ou manter como string
		System.out.println("Digite o telefone do(a) Sr(a) "+cliente.getNome()+": ");
		cliente.setTelefone(Integer.parseInt(s.nextLine()));
		//telefone é muito grande é da erro, que manter como int para seguir a UML
		//possível solução: unsigned int ou manter como string
		System.out.println("Digite o endereço do(a) Sr(a)"+cliente.getNome()+": ");
		cliente.setEndereco(s.nextLine());
		listadeclientes.add(cliente);
	}
	public void reservarIda(Cliente cliente, Reserva reserva) {
		//Cidade : origem - destino
		System.out.println("Cidade de origem");
		Cidade origem = new Cidade();
		Cidade destino = new Cidade();
		reserva.setOrigem(origem);
		reserva.setDestino(destino);
		cadastrarCidade(reserva.getOrigem());
		System.out.println("Cidade destino");
		cadastrarCidade(reserva.getDestino());
		//Reserva
		cliente.reservarIda(reserva);
	}
	public void reservarVolta(Cliente cliente, Reserva reserva) {
		cliente.reservarIda(reserva);
	}
	public ArrayList<Reserva> mostrarReservas(int cpfCliente) {
		/*
		Cliente cliente = new Cliente();
		ArrayList<Reserva> listadereservas = new ArrayList<Reserva>();
		cliente = (Cliente) listadeclientes.stream().filter(Cliente -> cpfCliente == Cliente.getCpf());
		int i = 0;
		for(Reserva r : listadereservas) {
			listadereservas.add(cliente.getReservas(i));
			i++;
		}
		return listadereservas;*/
		return null;
		
	}
	public ArrayList<Cliente> mostrarClientes() {
		//Optei por trocar por Arraylist, tentei fazer conversão para ficar
		//fiel a UML mas não consegue
		return listadeclientes;
	}
	public ArrayList<Cidade> mostrarCidades() {
		//Optei por trocar por Arraylist, tentei fazer conversão para ficar
		//fiel a UML mas não consegue
		return listadecidades;
	}
}
