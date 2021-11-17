package ex4;

import java.util.ArrayList;
import java.util.Random;

public class Sorteador {
	private ArrayList <Pessoa> p = new ArrayList<Pessoa>();
	
	public void cadastrarPessoa(Pessoa pessoa) {
		p.add(pessoa);
	}
	public Pessoa sortearProximo() {
		if(p.size() == 1) {
			return p.get(0);
		}
		Random r = new Random();
		Pessoa Psorteado = new Pessoa();
		int Nsorteado = r.nextInt((p.size()-0)+1)+0;
		Psorteado = p.get(Nsorteado);
		p.remove(Nsorteado);
		return Psorteado;
	}
}
