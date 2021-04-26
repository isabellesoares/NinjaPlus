package tests;

import common.BaseTest;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Condition.text;

public class LoginTests extends BaseTest {

   // protected static LoginPage Login;
  //  protected static SideBar side;

    @DataProvider(name = "login-alerts")
    public Object[][] loginProvider() {
        return new Object[][]{
                {"isabelle@ninjaplus.com", "abc123", "Usuário e/ou senha inválidos"},
                {"404@gmail.com", "123456", "Usuário e/ou senha inválidos"},
                {"", "abc123", "Opps. Cadê o email?"},
                {"isabelle@ninjaplus.com", "", "Opps. Cadê a senha?"},
        };
    }

    @Test
    public void shouldSeeLoggedUser() {
        // isChrome();///utilizar esse navegador para os testes
        //open("http://ninjaplus-web:5000"); ///abrir o link do da página

        ///Buscar elemento no selenide
        //$("input[name=email]").setValue("isabelle@ninjaplus.com");
        // $("#input[type=password]").setValue("123456");
        //$("#login").click();
        // $(byText("Entrar")).click();//quando não tiver o id

        ///Validar se o valor na area logado estar de acordo com o usuário logado

        Login
                .open()
                .with("isabelle@ninjaplus.com", "123456");

        side.loggedUser().shouldHave(text("Isabelle"));
        //$(".user .info span").shouldHave(text("Isabelle"));

    }

    // DDT (Data driven testing)
    @Test(dataProvider = "login-alerts")
    public void shouldSeeLoginAlerts(String email, String pass, String expectAlert) {
        // isChrome();///utilizar esse navegador para os testes
        // executeJavaScript("localStorage.clear();");
        //  open("http://ninjaplus-web:5000/login"); ///abrir o link do da página

        // $("input[name=email]").setValue(email);
        //  $("input[type=password]").setValue(pass);
        //  $(byText("Entrar")).click();

        //  $(".alert span").

        Login
                .open()
                .with(email, pass)
                .alert().shouldHave(text(expectAlert));
    }

    @AfterMethod
    public void cleanup(){
        Login.clearSession();
    }

       /*@Test
    public void UserNotFound(){
        isChrome();///utilizar esse navegador para os testes
        open("http://ninjaplus-web:5000/login"); ///abrir o link do da página

        ///Buscar elemento no selenide
        $("#emailId").setValue("404@gmail.com");
        $("#passId").setValue("123");
        //$("#login").click();
        $(byText("Entrar")).click();//quando não tiver o id

        $(".alert span").shouldHave(text("Usuário e/ou senha inválidos"));
    }*/

    /*@Test
    public void EmailRequired(){
        isChrome();///utilizar esse navegador para os testes
        open("http://ninjaplus-web:5000/login"); ///abrir o link do da página

        ///Buscar elemento no selenide
        $("#emailId").setValue("");
        $("#passId").setValue("123456");
        //$("#login").click();
        $(byText("Entrar")).click();//quando não tiver o id

        $(".alert span").shouldHave(text("Opps. Cadê o email?"));
    }*/

    /*@Test
    public void PasswordRequired(){
        isChrome();///utilizar esse navegador para os testes
        open("http://ninjaplus-web:5000/login"); ///abrir o link do da página

        ///Buscar elemento no selenide
        $("#emailId").setValue("isabelle@ninjaplus.com");
        $("#passId").setValue("");
        //$("#login").click();
        $(byText("Entrar")).click();//quando não tiver o id

        $(".alert span").shouldHave(text("Opps. Cadê a senha?"));
    }*/

}
