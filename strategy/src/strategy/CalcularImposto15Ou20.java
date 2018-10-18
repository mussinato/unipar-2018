package strategy;

public class CalcularImposto15Ou20 implements CalcularSalario {

	@Override
	public double calcularSalarioComImposto(double salarioBase) {
		if (salarioBase >= 3500) {
			return salarioBase * 0.8;
		}
		return salarioBase * 0.85;
	}

}
