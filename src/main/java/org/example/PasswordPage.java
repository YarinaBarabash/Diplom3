package org.example;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class PasswordPage {
    private WebDriver driver;
    public PasswordPage (WebDriver driver){
        this.driver = driver; // Инициализировали в нём поле driver
    }
    private By linkLogin = By.xpath(".//a[text()='Войти']");
    @Step("Клик по кнопке 'Войти в аккаунт'")
    public LoginPage clickSignIn() {
        driver.findElement(linkLogin).click();
        return new LoginPage(driver);
    }

}
