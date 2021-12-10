package dados;

public class Primos extends Gerador{
	@Override
	public void gerar(int quantidade) {
		int x = (int) ((Math.random() * quantidade));
		boolean ehprimo = true;
		for(int i = 2; i < x;i++) {
			if(i > 2) {
				for(int j = 2; j < i; j++) {
					System.out.println(i+" "+j);
					if(i%j == 0) {
						System.out.println(i+" "+j);
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
