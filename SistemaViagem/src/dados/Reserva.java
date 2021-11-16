package dados;

public class Reserva {
	//Atributos
	private int numReserva, poltrona;
	private String dataVoo, horaVoo, classeVoo;
	private float preco;
	private boolean idaEvolta;
	private Cidade origem, destino;
	//Getters and Setters
	public int getNumReserva() {
		return numReserva;
	}
	public void setNumReserva(int numReserva) {
		this.numReserva = numReserva;
	}
	public int getPoltrona() {
		return poltrona;
	}
	public void setPoltrona(int poltrona) {
		this.poltrona = poltrona;
	}
	public String getDataVoo() {
		return dataVoo;
	}
	public void setDataVoo(String dataVoo) {
		this.dataVoo = dataVoo;
	}
	public String getHoraVoo() {
		return horaVoo;
	}
	public void setHoraVoo(String horaVoo) {
		this.horaVoo = horaVoo;
	}
	public String getClasseVoo() {
		return classeVoo;
	}
	public void setClasseVoo(String classeVoo) {
		this.classeVoo = classeVoo;
	}
	public float getPreco() {
		return preco;
	}
	public void setPreco(float preco) {
		this.preco = preco;
	}
	public boolean isIdaEvolta() {
		return idaEvolta;
	}
	public void setIdaEvolta(boolean idaEvolta) {
		this.idaEvolta = idaEvolta;
	}
	public Cidade getOrigem() {
		return origem;
	}
	public void setOrigem(Cidade origem) {
		this.origem = origem;
	}
	public Cidade getDestino() {
		return destino;
	}
	public void setDestino(Cidade destino) {
		this.destino = destino;
	}
	//toString
	public String toString() {
		return "------Reserva------\n"
				+ "Número da reserva: " + numReserva + "\n"
				+ "Preço: " + preco + "\n"
				+ "Hora do voo: " + horaVoo + "\n"
				+ "Classe do voo: " + classeVoo + "\n"
				+ "Cidade de origem: " + origem + "\n"
				+ "Cidade de destino: " + destino + "\n";
	}
}
