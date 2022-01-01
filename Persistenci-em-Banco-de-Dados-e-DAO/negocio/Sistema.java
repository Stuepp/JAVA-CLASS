package negocio;

import java.sql.SQLException;
import java.util.List;

import dados.Pessoa;
import exceptions.DeleteException;
import exceptions.InsertException;
import exceptions.SelectException;
import exceptions.UpdateException;
import persistencia.Conexao;
import persistencia.EnderecoDAO;
import persistencia.PessoaDAO;

public class Sistema {
	private PessoaDAO pessoaDAO = new PessoaDAO();
	private EnderecoDAO enderecoDAO = new EnderecoDAO();
	
	public Sistema(String senha) throws ClassNotFoundException,SQLException,SelectException{//ClassNotFoundException,SQLException,SelectEception
		Conexao.setSenha(senha);
		pessoaDAO = PessoaDAO.getInstance();
	}
	public void inserirPessoa(Pessoa pessoa) throws InsertException, SelectException{
		pessoaDAO.insert(pessoa);
	}
	public List<Pessoa> gettAllPessoas() throws SelectException{//SelectException
		return pessoaDAO.selectAll();
	}
	public void deletarPessoa(Pessoa pessoa) throws DeleteException{//DeleteException
		pessoaDAO.delete(pessoa);
	}
	public void atualizarPessoa(Pessoa pessoa) throws UpdateException{//UpdateException
		pessoaDAO.update(pessoa);
	}
}
