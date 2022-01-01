package dados;

public class Naturais extends Gerador{

	@Override
	public void gerar(int quantidade) {
		int x = (int) ((Math.random() * (quantidade)));
		for(int i = 0; i < x; i++) {
			super.getSequencia().add(i);	
		}		
	}
}
