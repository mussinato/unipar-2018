package strategy;

public class Main {
	
	/*
	 Regras:
		- O Desenvolvedor deve ter um imposto de 15% caso seu salário seja 
			maior que R$ 2000,00 e 10% caso contrário;
		- O Gerente deve ter um imposto de 20% caso seu salário seja maior 
			que R$ 3500,00 e 15% caso contrário;
		- O DBA deve ter um imposto de  de 15% caso seu salário seja maior 
			que R$ 2000,00 e 10% caso contrário;
	 */
	
	public static void main(String[] args) {
		Funcionario f1 = new Funcionario(Funcionario.DESENVOLVEDOR, 2100);
		System.out.println(f1.calcularSalarioComImposto());

		Funcionario f2 = new Funcionario(Funcionario.DESENVOLVEDOR, 1700);
		System.out.println(f2.calcularSalarioComImposto());
		
		Funcionario f3 = new Funcionario(Funcionario.DBA, 3700);
		System.out.println(f3.calcularSalarioComImposto());
		
		Funcionario f4 = new Funcionario(Funcionario.GERENTE, 5200);
		System.out.println(f4.calcularSalarioComImposto());
	}
}