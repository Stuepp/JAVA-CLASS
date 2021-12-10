package ex2;

public abstract class FormaGeometrica {
	//Atributos
	private int medida1,medida2;
	//Getters and Setters
	public int getMedida1() {
		return medida1;
	}
	public void setMedida1(int medida1) {
		this.medida1 = medida1;
	}
	public int getMedida2() {
		return medida2;
	}
	public void setMedida2(int medida2) {
		this.medida2 = medida2;
	}
	//Métodos
	public abstract int calcularArea();
	public abstract int calcularPerimetro();
}
