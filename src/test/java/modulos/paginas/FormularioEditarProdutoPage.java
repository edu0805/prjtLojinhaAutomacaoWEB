package modulos.paginas;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class FormularioEditarProdutoPage {

    private WebDriver navegador;

    public FormularioEditarProdutoPage(WebDriver navegador){
        this.navegador = navegador;
    }

    public String capturarMensagemApresentadaComSucesso(){
        String mensagemToast = navegador.findElement(By.cssSelector(".toast.rounded")).getText();
        return mensagemToast;
    }


}
