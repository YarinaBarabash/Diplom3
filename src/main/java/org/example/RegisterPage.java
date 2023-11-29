package org.example;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import io.qameta.allure.Step;
public class RegisterPage {
    private WebDriver driver;
    private By registerButton = By.xpath(".//button[text()='Зарегистрироваться']");
    // Шаг 4. Добавили конструктор класса page object
    private By nameInput = By.xpath(".//label[text()='Имя']/../input");
    private By passwordInput = By.xpath(".//label[text()='Пароль']/../input");
    private By emailInput = By.xpath(".//label[text()='Email']/../input");
    private By linkLogin = By.xpath(".//a[text()='Войти']");


    public RegisterPage(WebDriver driver){
        this.driver = driver; // Инициализировали в нём поле driver
    }

    @Step("Регистрация юзера")
    public LoginPage inputRegisterForm(String name, String password, String email) {
        driver.findElement(nameInput).sendKeys(name);
        driver.findElement(passwordInput).sendKeys(password);
        driver.findElement(emailInput).sendKeys(email);
        driver.findElement(registerButton).click();
        return new LoginPage(driver);
    }


    @Step("Клик по кнопке Личный кабнет")
    public LoginPage clickRegister() {
        driver.findElement(linkLogin).click();
        return new LoginPage(driver);
    }
}

