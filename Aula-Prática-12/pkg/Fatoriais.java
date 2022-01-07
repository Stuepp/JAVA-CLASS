package pkg;

public class Fatoriais extends Gerador{
	@Override
	public void gerar(int quantidade) {
		int atual = 1, anterior = 1;;
		for(int i = 0; i < quantidade; i++) {
			if(i > 1) {
				atual = i * anterior;
				anterior = atual;
			}
			super.getSequencia().add(atual);
		}
	}
}
