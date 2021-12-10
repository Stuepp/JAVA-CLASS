package persistencia;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import dados.Contato;

public class ContatoDAO {
	
	private ArquivoContatoDAO arquivoContatoDAO = new ArquivoContatoDAO();
	
	public void insert(Contato contato) {
		arquivoContatoDAO.salvaContatoArquivo(contato);
	}
	public void delete(Contato contato) {
		List<Contato> contatos = arquivoContatoDAO.leContatos();
		contatos.remove(contato);
		arquivoContatoDAO.salvaContatos(contatos);
	}
	public Map<Character,List<Contato>> getAll(){
		Map<Character, List<Contato>> contatos = new HashMap<Character, List<Contato>>();
		for(char i = 65; i < 91; i++) {
			List<Contato> lista = new LinkedList<Contato>();
			contatos.put(i,lista);
		}
		for(Contato contato : arquivoContatoDAO.leContatos()) {
			char inicial = contato.getNome().toUpperCase().charAt(0);
			contatos.get(inicial).add(contato);
		}
		return contatos;
	}
}
