package dados;

import exceptions.EspacoIndisponivelException;
import exceptions.NaoEhPeixeException;
import exceptions.TemperaturaInadequadaException;

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
	public float alturaDisponivel() {
		float altura = 0;
		for(Animal a : animais) {
			altura += a.getAltura();
		}
		return altura;
	}
	public void adicioanaAnimal(Animal animal) throws TemperaturaInadequadaException, EspacoIndisponivelException, NaoEhPeixeException{
		if(!(animal instanceof Peixe)) {
			Peixe p = (Peixe) animal;
			if(espacoDisponivel() >= (animal.calculaEspacoOcupado() *.7)) {		
				if((p.getTemperaturaIdeal() < temperatura - 3) || (p.getTemperaturaIdeal() > temperatura +3)) {
					throw new TemperaturaInadequadaException("A temperatura não está adequada para o peixe");
				}
				animais.add(p);
			}else {
				throw new EspacoIndisponivelException("O espaço não é o suficiente para o peixe");
			}
		} else {
			throw new NaoEhPeixeException("O animal não é peixe");
		}
	}
}
