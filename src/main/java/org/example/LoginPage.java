package org.example;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LoginPage {
    protected WebDriver driver;
    private By registerLink = By.xpath(".//a[text()='Зарегистрироваться']");
    private By enterHeading = By.xpath(".//h2[text()='Вход']");
    private By buttonEnter = By.xpath(".//button[text()='Войти']");
    private By errorPassword = By.xpath(".//p[text()='Некорректный пароль']");
    private By passwordInput = By.xpath(".//label[text()='Пароль']/../input");
    private By emailInput = By.xpath(".//label[text()='Email']/../input");
    private By linkForgotPassword = By.xpath(".//a[text()='Восстановить пароль']");
    private final By personalAccountButton = By.xpath(".//p[text()='Личный Кабинет']");
    public LoginPage(WebDriver driver){
        this.driver = driver; // Инициализировали в нём поле driver
    }
    public RegisterPage clickRegisterLink() {
        driver.findElement(registerLink).click();
        return new RegisterPage(driver);
    }
    public PasswordPage clickLinkForgotPassword() {
        driver.findElement(linkForgotPassword).click();
        return new PasswordPage(driver);
    }
    @Step("Проверка перехода на страницу 'Вход")
    public boolean validateOpeningLoginPage() {
        return driver.findElement(enterHeading).isDisplayed();
    }
    @Step("Проверка сообщения об ошибке")
    public boolean errorPassword() {
        return driver.findElement(errorPassword).isDisplayed();
    }
    @Step("Вход юзера")
    public LoginPage inputLoginForm( String email, String password) {
        driver.findElement(emailInput).sendKeys(email);
        driver.findElement(passwordInput).sendKeys(password);
       driver.findElement(buttonEnter).click();
        return new LoginPage(driver);
    }
    @Step("Клик по кнопке Личный кабнет")
    public ProfilePage clicksCabinet() {
        driver.findElement(personalAccountButton).click();
        return new ProfilePage(driver);
    }
}
