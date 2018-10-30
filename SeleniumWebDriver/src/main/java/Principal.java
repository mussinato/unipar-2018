import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Principal {

	private static WebDriver web;
	
	public static void main(String[] args) {
		System.setProperty("webdriver.gecko.driver", "D:\\geckodriver.exe");
		web = new FirefoxDriver();
		
		for (int i = 0; i<5; i++) {
			web.get("<URL DA PAGINA PARA ABRIR>");
			
			WebElement elMensagem = web.findElement(By.name("mensagem"));
			elMensagem.sendKeys("Lorem ipsum dolor sit amet, consectetur "
					+ "adipiscing elit. In id egestas massa.");
			
			WebElement elBotaoEnviar = web.findElement(By.className("btn-contato-enviar"));
			elBotaoEnviar.click();
		}
	}

}
