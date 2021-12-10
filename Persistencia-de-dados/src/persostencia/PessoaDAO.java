package persostencia;

public class PessoaDAO {
	private ArquivoPessoaDAO  arquivoPessoaDAO = new ArquivoPessoaDAO();
	
	public void insert(Pessoa p) {
		arquivoPessoaDAO.savePessoaArquivo(p);
	}
	public void delete(Pessoa p) {
		List<Pessoa> pessoas = arquivoPessoaDAO.lePessoasArquivo();
		
		pessoas.remove(p);
		
		arquivoPessoaDAO.savePessoasArquivo(pessoas);
	}
	public List<Pessoa> getAll(){
		return arquivoPessoaDAO.lePessoasArquivo();
	}
}
