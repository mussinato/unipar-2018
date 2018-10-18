package strategy;

public class CalcularImposto10Ou15 implements CalcularSalario {

	@Override
	public double calcularSalarioComImposto(double salarioBase) {
		if (salarioBase >= 2000) {
			return salarioBase * 0.85;
		}
		return salarioBase * 0.9;
	}

}
