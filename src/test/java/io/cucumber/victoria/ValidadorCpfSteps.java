package io.cucumber.victoria;

import static org.junit.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.pt.*;

public class ValidadorCpfSteps {

    public ValidadorCpfSteps() {
        System.setProperty("webdriver.chrome.driver", "driver/chromedriver.exe");
        browser = new ChromeDriver();
 
    }

    public WebDriver browser;

    @Quando("eu acesso o sistema de validacao de CPF")
    public void eu_acesso_o_sistema_de_validacao_de_CPF() {
        browser.get("http://localhost:8080/");

    }

    @Quando("digito no campo nome {string}")
    public void digito_no_campo_nome(String string) {
        WebElement input = browser.findElement(By.cssSelector("input[name='nome']"));
        input.sendKeys(string);
    }

    @Quando("digito no campo cpf {string}")
    public void digito_no_campo_cpf(String string) {
        WebElement input = browser.findElement(By.cssSelector("input[name='cpf']"));
        input.sendKeys(string);

    }

    @Quando("clico no botao enviar")
    public void clico_no_botao_enviar() {
        WebElement input  = browser.findElement(By.cssSelector("button[type='submit']"));
        input.click();
    }
    
    @Entao("eu devo ver a mensagem {string}")
    public void eu_devo_ver_a_mensagem_de_sucesso(String string) {
        WebElement input  = browser.findElement(By.cssSelector(".alert"));
        assertEquals(string, input.getText());
		browser.quit();

    }

}
