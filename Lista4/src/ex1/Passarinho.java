package ex1;

public class Passarinho extends Animal{
	@Override
	public String emitirSom() {
		return super.getNome()+": piu-piu\n";
	}
}
