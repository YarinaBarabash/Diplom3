package org.example;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ProfilePage {
    private WebDriver driver;

    public ProfilePage(WebDriver driver) {
        this.driver = driver; // Инициализировали в нём поле driver
    }

    private By linkProfile = By.xpath(".//a[text()='Профиль']");
    private By enterHeading = By.xpath(".//h2[text()='Вход']");
    private By konstruktor = By.xpath(".//p[text()='Конструктор']");
    private final By logoButton = By.className("AppHeader_header__logo__2D0X2");
    private By logOutButton = By.xpath(".//button[text()='Выход']");


    @Step("Проверить наличие отображения Входа")
    public boolean checkProfile() {
        return driver.findElement(enterHeading).isDisplayed();
    }

    @Step("Клик на контруктор")
    public MainPage clickKonstruktor() {
        driver.findElement(konstruktor).click();
        return new MainPage(driver);
    }

    @Step("Клик на logo")
    public MainPage clickLogo() {
        driver.findElement(logoButton).click();
        return new MainPage(driver);
    }
    @Step("Клик на выход")
    public MainPage clickLogOut() {
        driver.findElement(logoButton).click();
        return new MainPage(driver);
    }

    @Step("Открытие главной страницы")
    public ProfilePage openProfilePage() {
        driver.get("https://stellarburgers.nomoreparties.site/account/profile");
        new WebDriverWait(driver, Duration.ofSeconds(10));
        return this;

    }
}
