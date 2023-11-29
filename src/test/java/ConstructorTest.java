import io.qameta.allure.junit4.DisplayName;
import org.example.MainPage;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;

public class ConstructorTest extends BaseTest {
    MainPage mainPage;

    @Test
    @DisplayName("Переключение на соусы")
    public void testClickSouse() {
        mainPage = new MainPage(driver).openMainPage();
        mainPage.switchSaucesButton();
        Assert.assertEquals("Соусы", mainPage.getSwitchIngredientType());
    }
    @Test
    @DisplayName("Переход в раздел 'Булки'")
    public void SwitchBunTest() {
       mainPage = new MainPage(driver).openMainPage();
        mainPage.switchSaucesButton();
        mainPage.switchBunButton();
        Assert.assertEquals("Булки",mainPage.getSwitchIngredientType());
    }
    @Test
    @DisplayName("Переход в раздел 'Начинки'")
    public void SwitchFillingsTest() {
        mainPage = new MainPage(driver).openMainPage();
        mainPage.switchFillingsButton();
        Assert.assertEquals("Начинки",mainPage.getSwitchIngredientType());
    }
}