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
	//M�todos
	public void setBaseMenor(int valor) {
		super.setMedida2(valor);
	}
	public void setBaseMaior(int valor) {
		super.setMedida1(valor);
	}
	@Override
	//medida1 � base maior e medidade2 � base menor
	public int calcularArea() {
		int area = (super.getMedida1() - super.getMedida2())*altura;
		area /= 2;
		return (area);
	}
	@Override //necess�rio 2� override?
	public int calcularPerimetro() {
		int perimetro = (super.getMedida1() - super.getMedida2())/2;
		perimetro *= perimetro;
		perimetro = (int) Math.sqrt(perimetro);
		perimetro *= 4;
		return (perimetro);
	}
	
	public String toString() {
		return "---Trap�zio---"
				+ "\nAltura: "+altura
				+ "\nBase menor: "+super.getMedida2()
				+ "\nBase maior: "+super.getMedida1()
				+ "\n�rea: "+calcularArea()
				+ "\nPerimetro: "+calcularPerimetro();
	}
}
