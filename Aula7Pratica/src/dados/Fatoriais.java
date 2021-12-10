package dados;

public class Fatoriais extends Gerador{
	@Override
	public void gerar(int quantidade) {
		int x = (int) ((Math.random() * quantidade));
		int atual = 1, anterior = 1;;
		for(int i = 0; i < x; i++) {
			if(i > 1) {
				atual = i * anterior;
				anterior = atual;
			}
			super.getSequencia().add(atual);
		}
	}
}
