package ex2;

public class Losango extends FormaGeometrica{
	//MÈtodos
	public void setD(int valor) {
		super.setMedida1(valor);
	}
	public void setd(int valor) {
		super.setMedida2(valor);
	}
	@Override
	public int calcularArea() {
		int area = super.getMedida1()*super.getMedida2();
		area /= 2;
		return area;
	}

	@Override //necess·rio 2∫ override?
	public int calcularPerimetro() {
		int perimetro = (super.getMedida1()*super.getMedida1())/4;
		perimetro += (super.getMedida2()*super.getMedida2())/4;
		perimetro = (int) Math.sqrt(perimetro);
		perimetro *= 4;
		return (perimetro);
	}
	public String toString() {
		return "---Losango---"
				+ "\nDiametro menor: "+super.getMedida2()
				+ "\nDiametro maior: "+super.getMedida1()
				+ "\n¡rea: "+calcularArea()
				+ "\nPerimetro: "+calcularPerimetro();
	}
}
