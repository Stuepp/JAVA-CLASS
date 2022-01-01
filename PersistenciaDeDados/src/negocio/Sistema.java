package negocio;

public class Sistema {
	private PessoaDAO pessoaDAO = new PessoaDAO();
	
	public void addPessoa(Pessoa p) {
		pessoaDAO.insert(p);
	}
	public void removePessoa() {
		
	}
	public List<Pessoa> getList(){
		return pessoaDAO.getAll();
	}
}
