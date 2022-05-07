package automation.endToend.steps;

import automation.endToend.pages.CreateUserPage;
import automation.endToend.pages.LoginPage;
import io.cucumber.java.pt.*;

public class DemoStep {

    public LoginPage pageLogin;
    public CreateUserPage pageCreateUser;
    public String firstName;
    public String lastName;
    public String userName;
    public String password;


    @Dado("a url demoqa\\login")
    public void a_url_demoqa_login() {
        pageLogin = new LoginPage(null);

    }
    @Quando("registro um novo usuario com a senha numerica")
    public void registro_um_novo_usuario_com_a_senha_numerica() {
        firstName = "Usuario";
        lastName = "Teste";
        userName = "userTest";
        password = "12345";

        pageCreateUser = pageLogin.navigatePageRegister();
        pageCreateUser.registerNewUser(firstName, lastName, userName, password);
    }
    @Entao("recebo mensagem de erro")
    public void recebo_mensagem_de_erro() {
        pageCreateUser.validateResgisterFailed();

    }

    @Quando("registro um novo usuario com as informacoes corretas")
    public void registro_um_novo_usuario_com_as_informacoes_corretas() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }
    @Entao("valido com sucesso")
    public void valido_com_sucesso() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }
    @Entao("realizado login")
    public void realizado_login() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

    @Quando("realizo login com sucesso")
    public void realizo_login_com_sucesso() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }
    @Quando("vou até a livraria")
    public void vou_até_a_livraria() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }
    @Quando("pesquiso por um livro")
    public void pesquiso_por_um_livro() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }
    @Entao("valido o codigo ISBN do livro")
    public void valido_o_codigo_isbn_do_livro() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }
    @Entao("adiciono o livro a minha colecao")
    public void adiciono_o_livro_a_minha_colecao() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }
    @Entao("valido se o livro foi adicionado.")
    public void valido_se_o_livro_foi_adicionado() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }
}
