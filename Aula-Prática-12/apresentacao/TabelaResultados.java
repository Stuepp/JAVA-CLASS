package apresentacao;

import javax.swing.table.AbstractTableModel;

import pkg.CalculadoraEstatistica;

public class TabelaResultados  extends AbstractTableModel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String[] colunas = {"Sorteado","Somatório","Média Aritimética","Média Geometrica"
			, "Variância","Desvio Padrão","Amplitude"};
	private CalculadoraEstatistica calculadora = CalculadoraEstatistica.getInstance();
	
	public TabelaResultados() {

	}
	
	public String getColumnName(int col) {
		return colunas[col];
	}	
	@Override
	public int getRowCount() {
		// TODO Auto-generated method stub
		return 1;
	}

	@Override
	public int getColumnCount() {
		// TODO Auto-generated method stub
		// Só teremos um valor para média, variancia etc..
		return colunas.length;
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		// TODO Auto-generated method stub
		if(!calculadora.getValores().isEmpty()) {
			switch(columnIndex) {
				case 0:
					return calculadora.sortear();
				case 1:
					return calculadora.somatorio();
				case 2:
					return calculadora.mediaAritimetica();
				case 3:
					return calculadora.mediaGeometrica();
				case 4:
					return calculadora.variancia();
				case 5:
					return calculadora.desvioPadrao();
				case 6:
					return calculadora.amplitude();
			}
		}else {
			return " − ";
		}
		return null;
	}

	public void atualizar() {
		fireTableStructureChanged();
	}
}
