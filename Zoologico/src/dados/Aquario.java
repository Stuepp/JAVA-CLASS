package dados;

public class Aquario extends Viveiro{
	//atributos
	private float altura, temperatura;
	//getters and setters

	public float getAltura() {
		return altura;
	}

	public void setAltura(float altura) {
		this.altura = altura;
	}

	public float getTemperatura() {
		return temperatura;
	}

	public void setTemperatura(float temperatura) {
		this.temperatura = temperatura;
	}
	//métodos
	public float calculaEspaco() {
		return super.calculaEspaco() * altura;
	}
	public boolean adicioanaAnimal(Animal animal) {
		if(espacoDisponivel() >= (animal.calculaEspacoOcupado() *.7)) {
			if(animal instanceof Peixe) {
				Peixe p = (Peixe) animal;
				
				if((p.getTemperaturaIdeal() < temperatura - 3) || (p.getTemperaturaIdeal() > temperatura +3)) {
					return false;
				}
			}
		}
		return true;
	}
}
