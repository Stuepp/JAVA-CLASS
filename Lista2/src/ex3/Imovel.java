package ex3;

public class Imovel {
	//Atributos
	private float largura, comprimento, area;
	//Getters and Setters

	public float getLargura() {
		return largura;
	}

	public void setLargura(float largura) {
		this.largura = largura;
	}

	public float getComprimento() {
		return comprimento;
	}

	public void setComprimento(float comprimento) {
		this.comprimento = comprimento;
	}

	public float getArea() {
		return area;
	}

	public void setArea(float area) {
		this.area = area;
	}
	//métodos
	public void calcularArea() {
		area = comprimento * largura;
	}
	public String toString() {
		return "---Imóvel---"
				+ "\nÁrea: "+area+"m²";
	}
}
