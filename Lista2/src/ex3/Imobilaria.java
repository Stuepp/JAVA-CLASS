package ex3;

import java.util.ArrayList;

public class Imobilaria {
	private ArrayList <Imovel> imoveis = new ArrayList<Imovel>();
	private String nome;
	
	
	public ArrayList<Imovel> getImoveis() {
		return imoveis;
	}
	public void setImoveis(ArrayList<Imovel> imoveis) {
		this.imoveis = imoveis;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public void addImovel(Imovel imovel) {
		imovel.calcularArea();
		imoveis.add(imovel);
	}
	public ArrayList<Imovel> imoveisDeXArea(int Xarea) {
		ArrayList<Imovel> imoveisXarea = new ArrayList<Imovel>();
		for(int i = 0; i < imoveis.size(); i++) {
			if(imoveis.get(i).getArea() >= Xarea) {
				imoveisXarea.add(imoveis.get(i));
			}
		}
		return imoveisXarea;
	}
	public String toString() {
		String imovel = "\n";
		for(int i = 0; i < imoveis.size(); i++) {
			imovel += imoveis.get(i).toString();
			imovel += "\n";
		}
		return "---Imobiliaria---"
				+ "\nNome: " + nome
				+imovel;
	}
}
