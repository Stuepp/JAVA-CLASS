package apresentacao;

import javax.swing.table.AbstractTableModel;

import pkg.CalculadoraEstatistica;

public class TabelaValores extends AbstractTableModel{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String[] colunas = {"Valores"};
	private CalculadoraEstatistica calculadora = CalculadoraEstatistica.getInstance();
	
	@Override
	public int getRowCount() {
		// TODO Auto-generated method stub
		return calculadora.getValores().size();
	}

	@Override
	public int getColumnCount() {
		// TODO Auto-generated method stub
		// Só teremos uma coluna
		return 1;
	}
	public String getColumnName(int col) {
		return colunas[col];
	}
	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		// TODO Auto-generated method stub
		return calculadora.getValores().get(rowIndex);
	}

	public void adicionarValor(int valor) {
		calculadora.adicionarValor(valor);
		fireTableStructureChanged();
	}
	public void limpar() {
		calculadora.limparValores();
		fireTableStructureChanged();
	}
}
