import User.UserSteps;
import io.qameta.allure.junit4.DisplayName;
import org.example.LoginPage;
import org.example.MainPage;
import org.example.RegisterPage;
import org.junit.Assert;
import org.junit.Test;
import org.example.*;

import com.github.javafaker.Faker;
import java.time.Duration;



public class LoginTest  extends BaseTest{
    public static Faker faker = new Faker();

MainPage mainPage;

    LoginPage loginPage;

    @Test
    @DisplayName("Вход юзера по валидным данным через кнопку вход")
        public void testLoginValid() {
        mainPage = new MainPage(driver);
            loginPage = mainPage.openMainPage()
                    .clickSignIn()
                    .inputLoginForm(user.getEmail(), user.getPassword());
        Assert.assertTrue("Пользователь не вошел", mainPage.checkIsAuth());

    }
    @Test
    @DisplayName("Вход юзера по кнопке Личный кабинет")
    public void testLoginValidСCabinet() {
        mainPage = new MainPage(driver);
        loginPage = mainPage.openMainPage()
                .clickCabinet()
                .inputLoginForm(user.getEmail(), user.getPassword());
        Assert.assertTrue("Пользователь не вошел", mainPage.checkIsAuth());

    }
    @Test
    @DisplayName("Вход юзера по кнопке в форме регистрации")
    public void testLoginRegisterButton() {
        mainPage = new MainPage(driver);
        loginPage = mainPage.openMainPage()
                .clickSignIn()
                .clickRegisterLink()
                .clickRegister()
                .inputLoginForm(user.getEmail(), user.getPassword());
        Assert.assertTrue("Пользователь не вошел", mainPage.checkIsAuth());

    }
    @Test
    @DisplayName("Вход юзера со страницы восстановления пароля")
    public void testLoginPasswordPage() {
        mainPage = new MainPage(driver);
        loginPage = mainPage.openMainPage()
                .clickSignIn()
                .clickLinkForgotPassword()
                .clickSignIn()
                .inputLoginForm(user.getEmail(), user.getPassword());
        Assert.assertTrue("Пользователь не вошел", mainPage.checkIsAuth());

    }

}
