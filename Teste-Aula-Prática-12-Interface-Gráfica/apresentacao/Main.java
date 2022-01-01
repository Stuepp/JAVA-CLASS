package apresentacao;

import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import java.awt.GridLayout;
import java.awt.BorderLayout;
import java.awt.TextField;

import dados.*;

public class Main {

	private static final int WIDTH = 800;
	private static final int HEIGTH = 300;
	private static JFrame frame;
	private static JButton bt;
	private static JLabel label;
	
	public Main() {
		initFrame();
	}
	
	public static void initFrame() {
		frame = new JFrame("Aula Prática 12 - Calculadora Estatística");
		JPanel mainPanel = new JPanel(new BorderLayout(5, 5));
		String[] header = {"Sorteado","Somatorio","Média Aritmética","Média Geométrica","Variancia","Desvio Padrão", "Amplitude"};
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(WIDTH,HEIGTH);
		frame.setResizable(false);
		
		JPanel barra = new JPanel(new GridLayout(0,1));
		barra.add(new JLabel("Origem:"));
		barra.add(new JLabel("Destino:"));
		
		JPanel conteudos = new JPanel(new GridLayout(0,1));
		conteudos.add(new JTextField(40));
		conteudos.add(new JTextField(40));
		
		JPanel botoes = new JPanel(new GridLayout(1,0));
		botoes.add(new JLabel()); // insere um "espaço"
		botoes.add(new JButton("Copiar"));
		botoes.add(new JLabel()); // insere um "espaço"
		botoes.add(new JButton("Sair"));
		botoes.add(new JLabel()); // insere um "espaço"
		
		mainPanel.add(barra, BorderLayout.WEST);
		mainPanel.add(conteudos, BorderLayout.CENTER);
		mainPanel.add(botoes, BorderLayout.SOUTH);
		
		frame.setContentPane(mainPanel);
		frame.setVisible(true);	
	}
	//
	public static void main(String[] args) {
		Main window = new Main();
		Gerador gerador;
		List<Integer> resultado;

		//Naturais
		gerador = new Naturais();
		gerador.gerar(10);
		resultado = gerador.getSequencia();
		show("Naturais",resultado);
		//Abundantes
		gerador = new Abundantes();
		gerador.gerar(100);
		resultado = gerador.getSequencia();
		show("Abundantes",resultado);
		//Fibonacci
		gerador = new Fibonacci();
		gerador.gerar(10);
		resultado = gerador.getSequencia();
		show("Fibonacci",resultado);
		//Fatorais
		gerador = new Fatoriais();
		gerador.gerar(10);
		resultado = gerador.getSequencia();
		show("Fatoriais",resultado);
		//Primos
		gerador = new Primos();
		gerador.gerar(10);
		resultado = gerador.getSequencia();
		show("Primos",resultado);
		//Quadrados
		gerador = new Quadrados();
		gerador.gerar(10);
		resultado = gerador.getSequencia();
		show("Quadrados",resultado);
		//Perfeitos
		gerador = new Perfeitos();
		gerador.gerar(30);
		resultado = gerador.getSequencia();
		show("Perfeitos",resultado);
	}
	public static void show(String tipo,List<Integer> seq) {
		int size = seq.size();
		if(size < 1) {
			System.out.println(tipo+" de "+ size+": {/}");
		}else {
			System.out.println(tipo+" de "+size+":");
			for(int i = 0; i < size; i++) {
				System.out.print(seq.get(i)+", ");
			}
		}
		System.out.println();
	}
}
