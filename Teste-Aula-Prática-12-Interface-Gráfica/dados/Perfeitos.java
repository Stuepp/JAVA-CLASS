package dados;

public class Perfeitos extends Gerador{
	@Override
	public void gerar(int quantidade) {
		int x = (int) ((Math.random() * quantidade));
		int soma = 0;
		for(int i = 6; i < x; i++) {
			if(i == 6) {
				super.getSequencia().add(i);
			}else {
				for(int j = 1; j < (i-1); j++) {
					if(i%j == 0) {
						soma+=j;
					}
				}
			}
			if(soma == i) {
				super.getSequencia().add(i);
			}
			soma = 0;
		}
	}
}
