package pkg;

import java.util.Random;

public class Complexo {
	//Atributos
	private int real, imaginaria;
	//Construtor
	public Complexo() {
		Random r = new Random();
		real = r.nextInt(100);
		imaginaria = r.nextInt(100);
	}
	public Complexo(int real, int imaginaria) {
		this.real = real;
		this.imaginaria = imaginaria;
	}
	//Getters and Setters
	public int getReal() {
		return real;
	}

	public void setReal(int real) {
		this.real = real;
	}

	public int getImaginaria() {
		return imaginaria;
	}

	public void setImaginaria(int imaginaria) {
		this.imaginaria = imaginaria;
	}
	//Métodos
	public String toString() {
		if(imaginaria > 0) {
			return "---Complexo---"
					+ "\n"+real+" + "+imaginaria+"i";
		}else if(imaginaria < 0) {
			return "---Complexo---"
					+"\n"+real+" "+imaginaria+"i";
		}else {
			return	"---Complexo---"
					+"\n"+real;
		}		
	}
}
