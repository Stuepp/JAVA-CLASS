package pkg;

public class CalculadoraInteiros implements IOperacoesBasicas<Integer> {
	@Override
	public Integer soma(Integer op1,Integer op2) {
		return (op1+op2);
	}
	@Override
	public Integer subtracao(Integer op1,Integer op2) {
		return (op1-op2);
	}
}
