package org.example;

import io.qameta.allure.Step;
import org.example.LoginPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;



public class MainPage {
   public final String url = "https://stellarburgers.nomoreparties.site";

   private final By signInButton = By.xpath(".//button[text()='Войти в аккаунт']");
   private final By personalAccountButton = By.xpath(".//p[text()='Личный Кабинет']");
   private final By createOrderButton = By.xpath(".//button[text()='Оформить заказ']");

   private final By bunButton = By.xpath(".//span[text()='Булки']/parent::div");
   private final By saucesButton = By.xpath(".//span[text()='Соусы']/parent::div");
   private final By fillingsButton = By.xpath(".//span[text()='Начинки']/parent::div");
   private final By currentIngredientType = By.xpath("//div[contains(@class,'tab_tab__1SPyG tab_tab_type_current__2BEPc')]");

   WebDriver driver;

   public MainPage(WebDriver driver) {
      this.driver = driver;
   }




   @Step("Клик по кнопке 'Войти в аккаунт'")
   public LoginPage clickSignIn() {
      driver.findElement(signInButton).click();
      return new LoginPage(driver);

   }
   @Step("Клик по кнопке Личный кабнет")
   public LoginPage clickCabinet() {
      driver.findElement(personalAccountButton).click();
      return new LoginPage(driver);
   }

   @Step("Проверили, что мы залогинены")
   public boolean checkIsAuth() {
      return driver.findElement(createOrderButton).isDisplayed();
   }

   @Step("Переключение на Соусы")
   public void switchSaucesButton() {
      driver.findElement(saucesButton).click();
   }

   @Step("Переключение на Булки")
   public void switchBunButton() {
      driver.findElement(bunButton).click();
   }


   @Step("Переключение на Начинки")
   public void switchFillingsButton() {
      driver.findElement(fillingsButton).click();
   }

   @Step("Проверка выбранного раздела ингредиентов")
   public String getSwitchIngredientType() {
      return driver.findElement(currentIngredientType).getText();
   }

   @Step("Проверка перехода на главную страницу")
   public boolean validateOpeningMainPage() {
      return driver.findElement(createOrderButton).isDisplayed();
   }

   @Step("Открытие главной страницы")
   public MainPage openMainPage() {
      driver.get(url);
      new WebDriverWait(driver, Duration.ofSeconds(3));
      return this;


   }
}

