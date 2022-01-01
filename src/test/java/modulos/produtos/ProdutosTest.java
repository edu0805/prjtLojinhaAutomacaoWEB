package modulos.produtos;

import modulos.paginas.LoginPage;
import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

@DisplayName("Testes WEB do modulo de Produtos")
public class ProdutosTest {

    private WebDriver navegador;

    @BeforeEach
    public void beforeEach(){
        // Abrir o navegador
        System.setProperty("webdriver.chrome.driver", "C:\\drivers\\chromedriver_win32\\chromedriver.exe");
        this.navegador = new ChromeDriver();

        // Maximizar a tela
        navegador.manage().window().maximize();

        // Definir tempo de espera padrão
        navegador.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));

        // Navegar para a pagina da Lojinha Web
        navegador.get("http://165.227.93.41/lojinha-web/v2/");

    }

    @Test
    @DisplayName("Nao é permitido registrar um produto com o valor igual a zero")
    public void testNaoEhPermitidoRegistrarProdutoComValorIgualAZero(){

        // Fazer Login
        String mensagemApresentda = new LoginPage(navegador)
                .informarUsuario("admin")
                .informarSenha("admin")
                .submeterFomularioLogin()

                // Tela de registro de produto
                .acessarFomularioRegistroProduto()

                // Preencher dados do produto com o valor igual a zero
                .preencherProdutoNome("SmartTV")
                .preencherProdutoValor("000")
                .preencherProdutoCores("Verde, Amarelo")

                // Submeter formulario
                .submeterFormularioProdutoComErro()
                .capturarMensagemApresentadaListaProdutoComErro();


        // Validar messagem de erro apresentada
        Assertions.assertEquals("O valor do produto deve estar entre R$ 0,01 e R$ 7.000,00",mensagemApresentda);

    }
    @Test
    @DisplayName("Não é permitido registrar um produto acima de Sete Mil")
    public void TestNaoEhPermitidoRegistrarUmProdutoAcimaDeSeteMil(){

        // Fazer Login
        String mensagemApresentda = new LoginPage(navegador)
                .informarUsuario("admin")
                .informarSenha("admin")
                .submeterFomularioLogin()
                .acessarFomularioRegistroProduto()
                .preencherProdutoNome("SmartTV")
                .preencherProdutoValor("700001")
                .preencherProdutoCores("Verde, Amarelo")
                .submeterFormularioProdutoComErro()
                .capturarMensagemApresentadaListaProdutoComErro();


        // Validar messagem de erro apresentada
        Assertions.assertEquals("O valor do produto deve estar entre R$ 0,01 e R$ 7.000,00",mensagemApresentda);

    }

    @Test
    @DisplayName("Posso add produto que estejam na faixa de 0,01 à 7000,00")
    public void testPossoAddProdutoFaixaUmCentavoASeteMil(){
        String mensagemApresentadaComSucesso = new LoginPage(navegador)
                .informarUsuario("admin")
                .informarSenha("admin")
                .submeterFomularioLogin()
                .acessarFomularioRegistroProduto()
                .preencherProdutoNome("SmartTV")
                .preencherProdutoValor("400000")
                .preencherProdutoCores("Laranja")
                .submeterFormularioProdutoComSucesso()
                .capturarMensagemApresentadaComSucesso();

        //
        Assertions.assertEquals("Produto adicionado com sucesso", mensagemApresentadaComSucesso);

    }

    @AfterEach
    public void afterEach(){
        // Fechar Navegador
        navegador.quit();
    }
}
