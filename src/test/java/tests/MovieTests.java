package tests;

import common.BaseTest;
import models.MovieModel;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.List;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;

public class MovieTests extends BaseTest {

    @BeforeMethod
    public void setup() {
       /* Configuration.browser = "chrome";
        Configuration.baseUrl = "http://ninjaplus-web:5000";

        Login = new LoginPage();
        side = new SideBar();
        movie= new MoviePage();*/

        Login
                .open()
                .with("isabelle@ninjaplus.com", "123456");

        side.loggedUser().shouldHave(text("Isabelle"));
    }

    @Test
    public void shouldRegisterANewMovie(){
        /*String title = "Jumanji - Próxima fase";
        String status = "Pré-venda";
        String year = "2020";
        String releaseDate = "16/01/2020";
        List<String> cast = Arrays.asList("The rock", "Jack black", "Kevin hard", "Karen Gillan", "Danny DeVito");
        String plot = "Tentando a revisitar o mundo de Jumanji";*/

        MovieModel movieData = new MovieModel(
                "Jumanji - Próxima fase",
                "Pré-venda",
                2020,
                "16/01/2020",
                Arrays.asList("The rock", "Jack black", "Kevin hard", "Karen Gillan", "Danny DeVito"),
                "Tentando a revisitar o mundo de Jumanji",
                "jumanji.jpg"
        );

        movie
                .add()
                .create(movieData)
                .items().findBy(text(movieData.title)).shouldBe(visible);
    }
}
