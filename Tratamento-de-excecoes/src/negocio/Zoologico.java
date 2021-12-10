package negocio;

import java.util.ArrayList;

import dados.Animal;
import dados.Aquario;
import dados.Peixe;
import dados.Viveiro;
import exceptions.EhPeixeException;
import exceptions.EspacoIndisponivelException;
import exceptions.NaoEhPeixeException;
import exceptions.TemperaturaInadequadaException;

public class Zoologico {
	private ArrayList<Animal> animais = new ArrayList<Animal>();
	private ArrayList<Viveiro> viveiros = new ArrayList<Viveiro>();
	
	public ArrayList<Animal> getAnimais() {
		return animais;
	}
	public void setAnimais(ArrayList<Animal> animais) {
		this.animais = animais;
	}
	public ArrayList<Viveiro> getViveiros() {
		return viveiros;
	}
	public void setViveiros(ArrayList<Viveiro> viveiros) {
		this.viveiros = viveiros;
	}
	public void cadastrarViveiro(Viveiro viveiro) {
		viveiros.add(viveiro);
	}
	public void cadastrarAnimal(Animal animal) {
		animais.add(animal);
	}
	
	public ArrayList<Aquario> getSoAquarios() {
		ArrayList<Aquario> SoAquarios = new ArrayList<Aquario>();
		for(int i = 0; i < viveiros.size(); i++) {
			if((viveiros.get(i) instanceof Aquario)) {
				SoAquarios.add((Aquario) viveiros.get(i));
			}
		}
		return SoAquarios;		
	}
	public ArrayList<Viveiro> getSoViveiros() {
		ArrayList<Viveiro> SoViveiros = new ArrayList<Viveiro>();
		for(int i = 0; i < viveiros.size(); i++) {
			if(!(viveiros.get(i) instanceof Aquario)) {
				SoViveiros.add(viveiros.get(i));
			}
		}
		return SoViveiros;
	}
	
	public boolean alocarAnimal(Animal animal, Viveiro viveiro) throws EspacoIndisponivelException{
		if(viveiro instanceof Aquario) {
			if(animal instanceof Peixe) {
				Aquario aquario = (Aquario) viveiro;
				Peixe peixe = (Peixe) animal;
				
				float larguraDisponivel = aquario.larguraDisponivel();
				float comprimentoDisponivel = aquario.comprimentoDisponivel();
				float alturaDisponivel = aquario.alturaDisponivel();
				float temperaturaAquario = aquario.getTemperatura();
				
				if(larguraDisponivel > 0.7 * peixe.getLargura()
						&& comprimentoDisponivel > 0.7 * peixe.getComprimento()
						&& alturaDisponivel > 0.7 * peixe.getAltura()) {
					float temperaturaMaxima = peixe.getTemperaturaIdeal() + 3;
					float temperaturaMinima = peixe.getTemperaturaIdeal() - 3;
					
					if(temperaturaAquario < temperaturaMaxima && temperaturaAquario > temperaturaMinima) {
						try {
							aquario.adicioanaAnimal(peixe);
						} catch (TemperaturaInadequadaException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						} catch (EspacoIndisponivelException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						} catch (NaoEhPeixeException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					} else {
						throw new EspacoIndisponivelException("Não a espaço no aquario para esse peixe");
					}
				}
				return true;
			} else {
				return false;
			}
		} else {
			if(animal instanceof Peixe) {
				return false;
			}else {
				float larguraDisponivel = viveiro.larguraDisponivel();
				float comprimentoDisponivel = viveiro.comprimentoDisponivel();
				
				if(larguraDisponivel > 0.7 * animal.getLargura()
						&& comprimentoDisponivel > 0.7 * animal.getComprimento()) {
					try {
						viveiro.adicionarAnimal(animal);
					} catch (EspacoIndisponivelException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (EhPeixeException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}else {
					throw new EspacoIndisponivelException("Não a espaço disponível no viveiro para esse animal");
				}
				return true;
			}
		}
	}
}
