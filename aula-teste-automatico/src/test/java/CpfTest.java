import org.junit.Assert;
import org.junit.Test;

public class CpfTest {
	
	@Test
	public void cpfSucesso() {
		Cpf cpf = new Cpf();
		Boolean resultado = cpf.validar("12345678909");
		Assert.assertEquals(true, resultado);
	}
	
	@Test
	public void cpfInvalido() {
		Cpf cpf = new Cpf();
		Boolean resultado = cpf.validar("12345678900");
		Assert.assertEquals(false, resultado);
	}
	
	@Test
	public void cpfValidoComMascara() {
		Cpf cpf = new Cpf();
		Boolean resultado = cpf.validar("123.456.789-09");
		Assert.assertEquals(true, resultado);
	}
	
	@Test
	public void cpfInvalidoComMascara() {
		Cpf cpf = new Cpf();
		Boolean resultado = cpf.validar("123.456.789-00");
		Assert.assertEquals(false, resultado);
	}
	
	@Test
	public void cpfInvalidoMenor11Dig() {
		Cpf cpf = new Cpf();
		Boolean resultado = cpf.validar("123456789");
		Assert.assertEquals(false, resultado);
	}
	
	
	
	
}
