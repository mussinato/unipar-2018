package strategy;

public class Main {
	
	/*
	 Regras:
		- O Desenvolvedor deve ter um imposto de 15% caso seu salário seja maior que R$ 2000,00 e 10% caso contrário;
		- O Gerente deve ter um imposto de 20% caso seu salário seja maior que R$ 3500,00 e 15% caso contrário;
		- O DBA deve ter um imposto de  de 15% caso seu salário seja maior que R$ 2000,00 e 10% caso contrário;
	 */
	
	public static void main(String[] args) {
		Funcionario umFuncionario = new Funcionario(Funcionario.DESENVOLVEDOR, 2100);
		System.out.println(umFuncionario.calcularSalarioComImposto());

		Funcionario outroFuncionario = new Funcionario(Funcionario.DESENVOLVEDOR, 1700);
		System.out.println(outroFuncionario.calcularSalarioComImposto());
	}
}