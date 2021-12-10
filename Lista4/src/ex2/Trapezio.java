package ex2;

public class Trapezio extends FormaGeometrica{
	//Atributps
	private int altura;
	//Getters and Setters
	public int getAltura() {
		return altura;
	}

	public void setAltura(int altura) {
		this.altura = altura;
	}
	//Métodos
	public void setBaseMenor(int valor) {
		super.setMedida2(valor);
	}
	public void setBaseMaior(int valor) {
		super.setMedida1(valor);
	}
	@Override
	//medida1 é base maior e medidade2 é base menor
	public int calcularArea() {
		int area = (super.getMedida1() - super.getMedida2())*altura;
		area /= 2;
		return (area);
	}
	@Override //necessário 2º override?
	public int calcularPerimetro() {
		int perimetro = (super.getMedida1() - super.getMedida2())/2;
		perimetro *= perimetro;
		perimetro = (int) Math.sqrt(perimetro);
		perimetro *= 4;
		return (perimetro);
	}
	
	public String toString() {
		return "---Trapézio---"
				+ "\nAltura: "+altura
				+ "\nBase menor: "+super.getMedida2()
				+ "\nBase maior: "+super.getMedida1()
				+ "\nÁrea: "+calcularArea()
				+ "\nPerimetro: "+calcularPerimetro();
	}
}
