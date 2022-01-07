package pkg;

public class Primos extends Gerador{
	@Override
	public void gerar(int quantidade) {
		boolean ehprimo = true;
		for(int i = 2; i < quantidade;i++) {
			if(i > 2) {
				for(int j = 2; j < i; j++) {
					if(i%j == 0) {
						ehprimo = false;
					}
				}
			}
			if(ehprimo) {
				super.getSequencia().add(i);
			}
			ehprimo = true;
		}
	}
}
