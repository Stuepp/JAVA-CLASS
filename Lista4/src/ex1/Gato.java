package ex1;

public class Gato extends Animal{
	@Override
	public String emitirSom() {
		return super.getNome()+": miau\n";
	}
}
