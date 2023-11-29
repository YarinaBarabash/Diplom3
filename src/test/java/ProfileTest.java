import io.qameta.allure.junit4.DisplayName;
import org.example.MainPage;
import org.example.ProfilePage;
import org.junit.Assert;
import org.junit.Test;
import org.example.LoginPage;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ProfileTest extends BaseTest {
    MainPage mainPage;
    ProfilePage profilePage;
LoginPage loginPage;
    @Test
    @DisplayName("Клик по кнопку личный кабинет")
    public void testClickProfile() {
        mainPage = new MainPage(driver);
        profilePage = new ProfilePage(driver);
        mainPage.openMainPage()
                .clickCabinet();
        Assert.assertTrue("Юзер не в личном кабинете", profilePage.checkProfile());
    }

    @Test
    @DisplayName("Клик на конструктор из Личного Кабинета")
    public void testClickConstruktor() {
        mainPage = new MainPage(driver);
        mainPage.openMainPage()
                .clickSignIn()
                .clickRegisterLink()
                .clickRegister()
                .inputLoginForm(user.getEmail(), user.getPassword())
                .clicksCabinet()
                .clickKonstruktor();
        Assert.assertTrue("Юзер не на Главной", mainPage.checkIsAuth());
    }


    @Test
    @DisplayName("Клик на logo из Личного Кабинета")
    public void testClickLogo() {
        mainPage = new MainPage(driver);
        mainPage.openMainPage()
                .clickSignIn()
                .clickRegisterLink()
                .clickRegister()
                .inputLoginForm(user.getEmail(), user.getPassword())
                .clicksCabinet()
        .clickLogo();
        Assert.assertTrue("Юзер не на Главной", mainPage.checkIsAuth());
    }

    @Test
    @DisplayName("Проверить, что можно выйти из аккаунта")
    public void testLogOut() {
        mainPage = new MainPage(driver);
        mainPage.openMainPage()
                .clickCabinet()
                .clickRegisterLink()
                .clickRegister()
                .inputLoginForm(user.getEmail(), user.getPassword())
                .clicksCabinet()
                .clickLogOut();
        Assert.assertTrue("Юзер не на Главной", mainPage.checkIsAuth());
    }
}