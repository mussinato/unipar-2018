import org.junit.Assert;
import org.junit.Test;

public class CalculadoraTest {

	@Test
	public void somarSucesso() {
		Calculadora calc = new Calculadora();
		Double result = calc.calcular(2.0, 3.0, "+");
		Assert.assertEquals(5.0, result, 0.0);
	}
	
	@Test
	public void subtrairSucesso() {
		Calculadora calc = new Calculadora();
		Double result = calc.calcular(2.0, 3.0, "-");
		Assert.assertEquals(-1.0, result, 0.0);
	}
	
	@Test
	public void multiplicarSucesso() {
		Calculadora calc = new Calculadora();
		Double result = calc.calcular(2.0, 3.0, "*");
		Assert.assertEquals(6.0, result, 0.0);
	}
	
	@Test
	public void dividirSucesso() {
		Calculadora calc = new Calculadora();
		Double result = calc.calcular(10.0, 2.0, "/");
		Assert.assertEquals(5.0, result, 0.0);
	}
	
	@Test
	public void dividirPorZeroErro() {
		Calculadora calc = new Calculadora();
		double result = calc.calcular(1.0, 0.0, "/");
		Assert.assertEquals(0.0, result, 0.0);
	}
	
	
}
