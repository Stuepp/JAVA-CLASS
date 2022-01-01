package persostencia;

import java.util.ArrayList;
import java.util.List;

public class ArquivoPessoaDAO {
	private final String file = "res/pessoas.txt";
	private EditorTexto editorArquivo = new EditorTexto();
	
	private String toCSV(Pessoa pessoa) {
		String p = "";
		
		p += pessoa.getNome()+",";
		p += pessoa.getIdade()+",";
		p += pessoa.getAltura()+",";
		p += pessoa.getMassa();
		
		return p;
	}
	private Pessoa fromCSV(String linhaCSV) {
		String atributos[] = linhaCSV.split(",");
		
		Pessoa p = new Pessoa();
		p.setNome(atributos[0]);
		p.setIdade(Integer.parseInt(atributos[1]));
		p.setAltura(Float.parseFloat(atributos[2]));
		p.setMassa(Float.parseFloat(atributos[3]));
		
		return p;
	}
	private List<String> listaPessoaToString(List<Pessoa> pessoas){
		List<String> listaPessoas = new ArrayList<String>();
		
		for(Pessoa p : pessoas) {
			listaPessoas.add(toCSV(p));
		}
		return listaPessoas;
	}
	private List<Pessoa> stringToListaPessoa(List<String> listaPessoas){
		List<Pessoa> pessoas = new ArrayList<Pessoa>();
		for(String s : listaPessoas) {
			pessoas.add(fromCSV(s));
		}
		return pessoas;
	}
	public List<Pessoa> lePessoasArquivo(){
		return stringToListaPessoa(editorArquivo.leTexto(file));
	}
	public void savePessoaArquivo(Pessoa p) {
		editorArquivo.gravaTexto(file, toCSV(p));
	}
	public void salvaPessoaArquivo(List<Pessoa> pessoas) {
		editorArquivo.gravaTexto(file, listaPessoaToString(pessoas));
	}
}
