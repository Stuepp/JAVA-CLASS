package dados;

public class Abundantes extends Gerador{

	@Override
	public void gerar(int quantidade) {
		int x = (int) ((Math.random() * (quantidade)));
		int soma = 0;
		for(int i = 0; i < x; i++) {
			for(int j = 1; j < i; j++) {
				if(i%j == 0) {
					soma += j;
				}
			}
			if(soma > i) {
				super.getSequencia().add(i);
			}
			soma = 0;
		}
	}
}
