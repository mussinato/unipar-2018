
public class Calculadora {

	public Double calcular(Double n1, Double n2, String op) {
		double resultado = 0.0;
		
		if (op.equals("+")) {
			resultado = n1 + n2;
		} else if (op.equals("-")) {
			resultado = n1 - n2;
		} else if (op.equals("/")) {
			resultado = n1 / n2;
		} else if (op.equals("*")) {
			resultado = n1 * n2;
		}
		
		return resultado;
	}
}
