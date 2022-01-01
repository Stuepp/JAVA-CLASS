package negocio;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import dados.Contato;
import exceptions.DeleteException;
import exceptions.InsertException;
import exceptions.SelectException;
import exceptions.UpdateException;
import persistencia.Conexao;
import persistencia.ContatoDAO;

public class ListaTelefonica {
	//Atributos
	private ContatoDAO contatoDAO;
	private HashMap<Character,List<Contato>> contatos = new HashMap<Character,List<Contato>>();
	//Construtor
	public ListaTelefonica(String senha) throws ClassNotFoundException,SQLException,SelectException {
		List<Contato> lista;
		Conexao.setSenha(senha);
		contatoDAO =  new ContatoDAO();
		for(int i = 65; i <= 90;i++) {
			lista = new LinkedList<Contato>();
			contatos.put((char) i, lista);
		}
	}
	//Métodos
	public void atualizarContato(Contato contato) throws UpdateException{//UpdateException
		contatoDAO.update(contato);
	}
	public void adicionarContato(Contato contato)  throws InsertException, SelectException {
		String nome = contato.getNome().toUpperCase();
		List<Contato> tempList = contatos.get(nome.charAt(0));//está trabalhando por referência!!!
		tempList.add(contato);
		contatoDAO.insert(contato);
	}
	public void removerContato(Contato contato)  throws DeleteException {
		String nome = contato.getNome().toUpperCase();
		contatos.get(nome.charAt(0)).remove(contato);
		contatoDAO.delete(contato);
	}
	public List<Contato> buscarContatos(char letra) throws SelectException {
		Map<Character, List<Contato>> tempMap = contatoDAO.selectAll();
		return tempMap.get(Character.toUpperCase(letra));
		//return contatos.get(Character.toUpperCase(letra));
	}
	public Map<Character, List<Contato>> buscarContatos() throws SelectException {
		return contatoDAO.selectAll();
	}
}
