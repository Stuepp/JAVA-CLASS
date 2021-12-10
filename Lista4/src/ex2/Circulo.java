package ex2;

public class Circulo extends FormaGeometrica{
	//Atributos
	private int raio;
	//Getters and Setters
	public int getRaio() {
		return raio;
	}
	public void setRaio(int raio) {
		this.raio = raio;
	}
	//MÈtodos
	@Override
	public int calcularArea() {
		return (int) (Math.PI * Math.pow(raio, 2));
	}

	@Override //necess·rio 2∫ override?
	public int calcularPerimetro() {
		return (int) (Math.PI * super.getMedida1());
	}
	
	public String toString() {
		return "---Circulo---"
				+ "\nRaio: "+raio
				+ "\nDiametro: "+super.getMedida1()
				+ "\n¡rea: "+calcularArea()
				+ "\nPerimetro: "+calcularPerimetro();
	}
}
