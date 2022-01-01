package modulos.paginas;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
    private WebDriver navegador;

    public LoginPage(WebDriver navegador){
        this.navegador = navegador;
    }

    public LoginPage informarUsuario(String usuario){
        navegador.findElement(By.cssSelector("label[for='usuario']")).click();
        navegador.findElement(By.id("usuario")).sendKeys(usuario);

        return this; // retorna a pagina
    }

    public LoginPage informarSenha(String senha){
        navegador.findElement(By.cssSelector("label[for='senha']")).click();
        navegador.findElement(By.id("senha")).sendKeys(senha);

        return this; // retorna a pagina
    }

    public ListaProdutoPage submeterFomularioLogin(){
        navegador.findElement(By.name("action")).click();
        return new ListaProdutoPage(navegador);
    }

}
