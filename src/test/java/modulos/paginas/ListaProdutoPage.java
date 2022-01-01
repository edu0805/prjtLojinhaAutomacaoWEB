package modulos.paginas;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ListaProdutoPage {
    private WebDriver navegador;

    public ListaProdutoPage (WebDriver navegador){
        this.navegador = navegador;
    }

    public FormularioRegistrarProdutoPage acessarFomularioRegistroProduto(){
        navegador.findElement(By.linkText("ADICIONAR PRODUTO")).click();

        return new FormularioRegistrarProdutoPage(navegador);
    }

    public String capturarMensagemApresentadaListaProdutoComErro(){
        String mensagemToast = navegador.findElement(By.cssSelector(".toast.rounded")).getText();
        return mensagemToast;
    }
}
