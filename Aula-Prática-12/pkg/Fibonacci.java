package pkg;

public class Fibonacci extends Gerador{
	@Override
	public void gerar(int quantidade) {
		int atual = 0, anterior = 0;
		for(int i = 0; i < quantidade; i++) {
			if(i == 1) {
				atual = 1;
			} else {
				atual += anterior;
				anterior = atual - anterior;
			}
			super.getSequencia().add(atual);
		}
	}
}
