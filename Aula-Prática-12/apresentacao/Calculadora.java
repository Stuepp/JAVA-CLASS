package apresentacao;

import java.awt.EventQueue;
import java.awt.event.ActionListener;
import java.util.List;
import java.awt.event.ActionEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

import pkg.Fatoriais;
import pkg.Fibonacci;
import pkg.Gerador;
import pkg.Primos;

public class Calculadora extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane = new JPanel();
	private JPanel painelEntrada = new JPanel();
	private JLabel infoCaixaTexto = new JLabel("Digite um valor:");
	private JTextField caixaTexto = new JTextField();
	private JButton botaoAdicionar = new JButton("adicionar");
	private JButton botaoLimpar = new JButton("limpar");
	private JScrollPane painelScrollTabelaResultados = new JScrollPane();
	private JTable tabelaResultados;
	private TabelaResultados resultados = new TabelaResultados();
	private JScrollPane painelScrollTabelaValores = new JScrollPane();
	private JTable tabelaValores;
	private TabelaValores valores = new TabelaValores();
	//FPF-Fibonacci Primos Fatorial
	private JPanel painelFPF = new JPanel();
	private JLabel infoCaixaGerar = new JLabel("Gerar Valores");
	private JTextField caixaTexto2 = new JTextField();
	private JLabel resposta = new JLabel("Resposta:");
	private JButton botaoFibonacci = new JButton("Fibonacci");
	private JButton botaoPrimos = new JButton("Primos");
	private JButton botaoFatorial = new JButton("Fatorial");
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Calculadora frame = new Calculadora();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Calculadora() {
		setTitle("Calculadora Estatística");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false);
		setBounds(100, 100, 900, 300);//Xinicial, Yinicial, width, heigth
		contentPane.setLayout(null);
		setContentPane(contentPane);
		
		painelEntrada.setBounds(15,80,280,173);
		painelEntrada.setLayout(null);
		contentPane.add(painelEntrada);
		
		infoCaixaTexto.setBounds(30,30,200,15);
		painelEntrada.add(infoCaixaTexto);
		
		caixaTexto.setBounds(30,50,200,20);
		painelEntrada.add(caixaTexto);
		
		botaoAdicionar.setBounds(77,94,117,25);
		painelEntrada.add(botaoAdicionar);
		
		botaoLimpar.setBounds(77,136,117,25);
		painelEntrada.add(botaoLimpar);
		
		 painelScrollTabelaResultados.setBounds(10,10,870,50);
		 contentPane.add(painelScrollTabelaResultados);
		 tabelaResultados = new JTable(resultados);
		 painelScrollTabelaResultados.setViewportView(tabelaResultados);
		 
		 painelScrollTabelaValores.setBounds(307,80,173,173);
		 contentPane.add(painelScrollTabelaValores);
		 tabelaValores = new JTable(valores);
		 painelScrollTabelaValores.setViewportView(tabelaValores);
		 
		 painelFPF.setBounds((307+173+10),80,173,173);
		 painelFPF.setLayout(null);
		 contentPane.add(painelFPF);
		 
		 infoCaixaGerar.setBounds(10,0,200,15);
		 painelFPF.add(infoCaixaGerar);
		 
		 resposta.setBounds(50,15,173,25);//tentei aumentar o tamando para mostrar a resposta completa mas não deu certo..
		 painelFPF.add(resposta);
		 
		 caixaTexto2.setBounds(50,40,117,25);
		 painelFPF.add(caixaTexto2);
		 
		 botaoFibonacci.setBounds(50,70,117,25);
		 painelFPF.add(botaoFibonacci);
		 
		 botaoPrimos.setBounds(50,105,117,25);
		 painelFPF.add(botaoPrimos);
		 
		 botaoFatorial.setBounds(50,140,117,25);
		 painelFPF.add(botaoFatorial);
		 
		 /********************************************************/
		 botaoAdicionar.addActionListener(new ActionListener() {
			 public void actionPerformed(ActionEvent arg0) {
				 // Ação realizada
				 valores.adicionarValor(Integer.parseInt(caixaTexto.getText()));
				 resultados.atualizar();
				 caixaTexto.setText("");
			 }
		 });
		 botaoLimpar.addActionListener(new ActionListener() {
			 public void actionPerformed(ActionEvent arg0) {
				 valores.limpar();
				 resultados.atualizar();
			 }
		 });
		 botaoFibonacci.addActionListener(new ActionListener() {
			 public void actionPerformed(ActionEvent arg0) {
				 Gerador fibo = new Fibonacci();
				 String txt = "";
				 fibo.gerar(Integer.parseInt(caixaTexto2.getText()));
				 List<Integer> result = fibo.getSequencia();
					for(int i = 0; i < result.size(); i++) {
						txt += (result.get(i)+", ");
					}
				 resposta.setText("Fibonacci: "+txt);
				 caixaTexto2.setText("");
			 }
		 });
		 botaoPrimos.addActionListener(new ActionListener() {
			 public void actionPerformed(ActionEvent arg0) {
				 Gerador primo = new Primos();
				 String txt = "";
				 primo.gerar(Integer.parseInt(caixaTexto2.getText()));
				 List<Integer> result = primo.getSequencia();
					for(int i = 0; i < result.size(); i++) {
						txt += (result.get(i)+", ");
					}
				 resposta.setText("Primos: "+txt);
				 caixaTexto2.setText("");
			 }
		 });
		 botaoFatorial.addActionListener(new ActionListener() {
			 public void actionPerformed(ActionEvent arg0) {
				 Gerador fatorial = new Fatoriais();
				 String txt = "";
				 fatorial.gerar(Integer.parseInt(caixaTexto2.getText()));
				 List<Integer> result = fatorial.getSequencia();
					for(int i = 0; i < result.size(); i++) {
						txt += (result.get(i)+", ");
					}
				 resposta.setText("Fatorial: "+txt);
				 caixaTexto2.setText("");
			 }
		 });
	}

}
