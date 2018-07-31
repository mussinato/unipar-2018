
public class Calculadora {

	public Double calcular(Double n1, Double n2, String op) throws Exception {
		
		if (n1 == null) {
			n1 = 0.0;
		}
		
		if (n2 == null) {
			n2 = 0.0;
		}
		
		double resultado = 0.0;
		
		if (op.equals("+")) {
			resultado = n1 + n2;
		} else if (op.equals("-")) {
			resultado = n1 - n2;
		} else if (op.equals("/")) {
			if (n2 == 0.0) {
				throw new Exception("Não é possível dividir por zero.");
			}
			resultado = n1 / n2;
		} else if (op.equals("*")) {
			resultado = n1 * n2;
		}
		
		return resultado;
	}
}
