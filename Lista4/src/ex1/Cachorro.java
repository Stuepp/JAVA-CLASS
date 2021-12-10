package ex1;

public class Cachorro extends Animal{

	@Override
	public String emitirSom() {
		return super.getNome()+": au-au\n";
	}
	
}
