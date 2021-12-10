package persistencia;

import java.util.List;
import dados.Contato;
import java.util.LinkedList;

public class ArquivoContatoDAO {
	
	private final String caminho = "files/contatos.csv";
	private static EditorTexto file = new EditorTexto();
	
	private String toCSV(Contato contato) {
		String c = "";
		
		c += contato.getNome()+",";
		c += contato.getTelefone();
		
		return c;
		
	}
	private Contato fromCSV(String s) {
		String[] atributos = s.split(",");
		
		Contato contato = new Contato();
		contato.setNome(atributos[0]);
		contato.setTelefone(Integer.parseInt(atributos[1]));
		
		return contato;
	}
	private List<String> listaContatoToString(List<Contato> contatos){
		List<String> file = new LinkedList<String>();
		
		for(Contato contato : contatos) {
			file.add(toCSV(contato));
		}
		
		return file;
	}
	private List<Contato> stringToListaContato(List<String> file){
		List<Contato> contatos = new LinkedList<Contato>();
		
		for(String linha : file) {
			contatos.add(fromCSV(linha));
		}
		
		return contatos;
	}
	public List<Contato> leContatos() {
		List<Contato> contatos = new LinkedList<Contato>();
		for(String linha : file.leTexto(caminho)) {
			contatos.add(fromCSV(linha));
		}
		
		return contatos;
	}
	public void salvaContatos(List<Contato> contatos) {
		file.gravaTexto(caminho, listaContatoToString(contatos));
	}
	public void salvaContatoArquivo(Contato contato) {
		file.gravaTexto(caminho, toCSV(contato));
	}
}
