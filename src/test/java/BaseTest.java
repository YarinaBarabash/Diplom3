import User.UserRandomData;
import io.restassured.response.Response;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import User.*;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import static driver.WebDriverCreator.createWebDriver;

// Базовый тестовый класс, в котором настраивается драйвер. Другие тестовые классы наследуются от базового.
public class BaseTest {
    //Объявляем переменную драйвера
    protected WebDriver driver;
public static User user;
    private UserSteps userSteps = new UserSteps();

   String accessToken;
    // Инициализируем драйвер и указываем, какой использовать: ChromeDriver() или FirefoxDriver()
    @Before
    public void init_App()
    {
        driver = createWebDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        user = UserRandomData.createRandomUser();
        userSteps.userCreate(user);
        accessToken = userSteps.getToken(user);
    }


    @After
    public void cleanUp() {
       if (accessToken != null) {
          userSteps.userDelete(accessToken);
       }
        driver.quit();
    }


}