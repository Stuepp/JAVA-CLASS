package ex3;

public class Grafo extends Digrafo{
	@Override
	public void adicionarAresta(int origem, int destino) {
		super.getMa1().get(origem).set(destino, 1);
	}
	
	public String toString() {
		String matriz = "";
		for(int i = 0; i < super.getMa1().size(); i++) {
			for(int j = 0; j < super.getMa1().get(i).size(); j++) {
				matriz += super.getMa1().get(i).get(j)+"\t";
			}
			matriz +="\n";
		}
		return matriz;
	}
}
