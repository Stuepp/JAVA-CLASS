package persostencia;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.io.Writer;
import java.util.ArrayList;
import java.util.List;

public class EditorTexto {
	public void gravaTexto(String caminho,ArrayList<String> dados) {
		Writer file;
		
		try {
			file = new FileWriter(caminho);
			for(String i : dados) {
				file.write(i + "\n");
			}
		} catch(IOException e) {
			System.err.println("Erro na escrita do arquivo");
			System.exit(0);
		}
	}
	public void gravaTexto(String caminho,String linha) {
		Writer file;
		
		try {
			file = new FileWriter(caminho,true); //true indicica que a info será adicionada no final do arquivo
			file.write(linha+"\n");
			file.close();
		}catch(IOException e) {
			System.err.println("Erro na escrita do arquivo");
			//System.exit(0);
		}
	}
	public List<String> leTexto(String caminho){
		List<String> dados = new ArrayList<String>();
		
		Reader arquivo;
		BufferedReader r;
		
		try {
			arquivo = new FileReader(caminho);
			r = new BufferedReader(arquivo);
			
			String s = r.readLine();
			
			while(s != null) {
				dados.add(s);
				s = r.readLine();
			}
			arquivo.close();
		}catch(IOException e) {
			System.err.println("Erro na leitura do arquivo");
			//System.exit(0);
		}
		
		return dados;
	}
}
