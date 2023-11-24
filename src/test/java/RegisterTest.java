//import com.github.javafaker.Faker;
import io.qameta.allure.junit4.DisplayName;
import org.example.LoginPage;
import org.example.MainPage;
import org.example.RegisterPage;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.example.*;
import io.github.bonigarcia.wdm.WebDriverManager;
import com.github.javafaker.Faker;
import java.time.Duration;

import static driver.WebDriverCreator.createWebDriver;

public class RegisterTest extends BaseTest{
   // protected WebDriver driver;
    public static Faker faker = new Faker();
//   @Before
//   public void init_App()
//    {
//        driver = createWebDriver();
//        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
//    }

    LoginPage loginPage;
    //public static Faker faker = new Faker();
    @Test
    @DisplayName("Регистрация юзера по валидным данным")
    public void testRegisterValid() {
        loginPage = new MainPage(driver).openMainPage()
       .clickSignIn()
        .clickRegisterLink()
                .inputRegisterForm(faker.name().firstName(), faker.internet().password(), faker.internet().emailAddress());
        Assert.assertTrue("Пользователь не зарегестрирован",loginPage.validateOpeningLoginPage());

    }


    @Test
    @DisplayName("Регистрация юзера с невалидный паролем")
    public void testRegisterNoValid() {
        loginPage = new MainPage(driver).openMainPage()
                .clickSignIn()
                .clickRegisterLink()
                .inputRegisterForm(faker.name().firstName(), "11", faker.internet().emailAddress());
        Assert.assertTrue("Некорректный пароль",loginPage.errorPassword());

    }

}
