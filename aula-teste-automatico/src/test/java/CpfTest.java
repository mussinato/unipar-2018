import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class CpfTest {
	
	private Cpf cpf = null;
	
	@Before
	public void antes() {
		cpf = new Cpf();
	}
	
	@After
	public void depois() {
		
	}
	
	@Test
	public void cpfSucesso() {
		Boolean resultado = cpf.validar("12345678909");
		Assert.assertEquals(true, resultado);
	}
	
	@Test
	public void cpfInvalido() {
		Boolean resultado = cpf.validar("12345678900");
		Assert.assertEquals(false, resultado);
	}
	
	@Test
	public void cpfValidoComMascara() {
		Boolean resultado = cpf.validar("123.456.789-09");
		Assert.assertEquals(true, resultado);
	}
	
	@Test
	public void cpfInvalidoComMascara() {
		Boolean resultado = cpf.validar("123.456.789-00");
		Assert.assertEquals(false, resultado);
	}
	
	@Test
	public void cpfInvalidoMenor11Dig() {
		Boolean resultado = cpf.validar("123456789");
		Assert.assertEquals(false, resultado);
	}
	
	@Test
	public void cpfMenor11DigComMascara() {
		Boolean resultado = cpf.validar("075.887.109");
		Assert.assertEquals(false, resultado);
	}
	
	@Test
	public void cpfMaior11Dig() {
		Boolean resultado = cpf.validar("1234567890901");
		Assert.assertEquals(false, resultado);
	}
	
	@Test
	public void cpfMaior11DigComMascara() {
		Boolean resultado = cpf.validar("123.456.789-0901");
		Assert.assertEquals(false, resultado);
	}
	
	@Test
	public void cpfNulo() {
		Boolean resultado = cpf.validar(null);
		Assert.assertEquals(false, resultado);
	}
	
	@Test
	public void cpfVazio() {
		Boolean resultado = cpf.validar("");
		Assert.assertEquals(false, resultado);
	}
	
	@Test
	public void cpfTodos1() {
		Boolean resultado = cpf.validar("11111111111");
		Assert.assertEquals(false, resultado);
	}
	
	@Test
	public void cpfComLetras() {
		Boolean resultado = cpf.validar("aaabbbcccdd");
		Assert.assertEquals(false, resultado);
	}
}
