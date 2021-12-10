package persistencia;

import java.util.List;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.LinkedList;

public class EditorTexto {
	public List<String> leTexto(String caminho){
		List<String> dados = new LinkedList<String>();
		
		FileReader file;
		BufferedReader readFile;
		
		try {
			file = new FileReader(caminho);
			readFile = new BufferedReader(file);
			String s = readFile.readLine();
			
			while(s != null) {
				dados.add(s);
				s = readFile.readLine();
			}
			
			file.close();
		} catch(Exception e) {
			System.err.println("Erro ao editar arquivo");
			System.exit(0);
		}
		
		return dados;
	}
	public void gravaTexto(String caminho, List<String> dados) {
		FileWriter file;
		try {
			file = new FileWriter(caminho);
			for(int i = 0; i < dados.size(); i++) {
				file.write(dados.get(i)+"\n");
			}
			file.close();
		}catch(Exception e) {
			System.err.println("Erro ao salvar o arquivo");
			System.exit(0);
		}
	}
	public void gravaTexto(String caminho, String linha) {
		FileWriter file;
		try {
			file = new FileWriter(caminho,true);
			file.write(linha);
			file.close();
		}catch(Exception e) {
			System.err.println("Erro ao salvar arquivo");
			System.exit(0);
		}
	}
}
