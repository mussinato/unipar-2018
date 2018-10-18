package strategy;

public class Funcionario {
	public static final int DESENVOLVEDOR = 1;
	public static final int GERENTE = 2;
	public static final int DBA = 3;
	protected double salarioBase;
	protected int cargo;
	private CalcularSalario estrategia;
	
	public Funcionario(int cargo, double salarioBase) {
		this.salarioBase = salarioBase;
		this.cargo = cargo;
		
		if (cargo == DESENVOLVEDOR || cargo == DBA) {
			estrategia = new CalcularImposto10Ou15();
		} else if (cargo == GERENTE) {
			estrategia = new CalcularImposto15Ou20();
		} 
	}

	public double calcularSalarioComImposto() {
		return estrategia.calcularSalarioComImposto(salarioBase);
	}

	public double getSalarioBase() {
		return salarioBase;
	}
}