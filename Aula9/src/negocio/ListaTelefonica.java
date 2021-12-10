package negocio;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import dados.Contato;

public class ListaTelefonica {
	//Atributos
	private HashMap<Character,List<Contato>> contatos = new HashMap<Character,List<Contato>>();
	//Construtor
	public ListaTelefonica() {
		List<Contato> lista;
		for(int i = 65; i <= 90;i++) {
			lista = new LinkedList<Contato>();
			contatos.put((char) i, lista);
		}
	}
	//Métodos
	public void adicionarContato(Contato contato) {
		String nome = contato.getNome().toUpperCase();
		List<Contato> tempList = contatos.get(nome.charAt(0));//está trabalhando por referência!!!
		tempList.add(contato);
	}
	public void removerContato(Contato contato) {
		String nome = contato.getNome().toUpperCase();
		contatos.get(nome.charAt(0)).remove(contato);
	}
	public List<Contato> buscarContatos(char letra){
		return contatos.get(Character.toUpperCase(letra));
	}
	public Map<Character, List<Contato>> buscarContatos(){
		return contatos;
	}
}
