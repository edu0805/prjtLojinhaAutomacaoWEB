package modulos.paginas;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class FormularioRegistrarProdutoPage {

    private WebDriver navegador;

    public FormularioRegistrarProdutoPage(WebDriver navegador) {
        this.navegador = navegador;
    }

    public FormularioRegistrarProdutoPage preencherProdutoNome(String nome){
        navegador.findElement(By.id("produtonome")).sendKeys(nome);
        return this;
    }

    public FormularioRegistrarProdutoPage preencherProdutoValor(String valor){
        navegador.findElement(By.id("produtovalor")).sendKeys(valor);
        return this;
    }

    public FormularioRegistrarProdutoPage preencherProdutoCores(String cores){
        navegador.findElement(By.id("produtocores")).sendKeys(cores);
        return this;
    }

    public ListaProdutoPage submeterFormularioProdutoComErro(){
        navegador.findElement(By.name("action")).click();
        return new ListaProdutoPage(navegador);
    }

    public FormularioEditarProdutoPage submeterFormularioProdutoComSucesso(){
        navegador.findElement(By.name("action")).click();
        return new FormularioEditarProdutoPage(navegador);
    }
}
