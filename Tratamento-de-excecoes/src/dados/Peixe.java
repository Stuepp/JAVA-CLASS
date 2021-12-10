package dados;

public class Peixe extends Animal{
	//atributos
	private float temperaturaIdeal;
	//getters and setters

	public float getTemperaturaIdeal() {
		return temperaturaIdeal;
	}

	public void setTemperaturaIdeal(float temperaturaIdeal) {
		this.temperaturaIdeal = temperaturaIdeal;
	}
	//métodos
	public float EspacoOcupado() {
		return altura * super.calculaEspacoOcupado();
	}
	public String toString() {
		return super.toString() + "\nTemperatura Ideal: " + temperaturaIdeal;
	}
}
