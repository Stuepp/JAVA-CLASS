package negocio;

import java.util.ArrayList;

import dados.Animal;
import dados.Aquario;
import dados.Viveiro;

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
}
