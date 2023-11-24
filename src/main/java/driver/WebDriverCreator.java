package driver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;


public class WebDriverCreator {

    public static final String YANDEX_DRIVER = "src/main/java/driver/yandexdriver";
    public static final String YANDEX_BROWSER_PATH = "/Applications/Yandex.app/Contents/MacOS/Yandex";

    public static WebDriver createWebDriver() {
//
//return createChromeDriver();
//        }
        return createYandexDriver();
    }

    private static WebDriver createChromeDriver() {
        System.setProperty("webdriver.http.factory", "jdk-http-client");
        ChromeOptions options = new ChromeOptions();
        return new ChromeDriver(options);
    }

    private static WebDriver createYandexDriver() {
        System.setProperty("webdriver.http.factory", "jdk-http-client");
        System.setProperty("webdriver.chrome.driver", YANDEX_DRIVER);
        ChromeOptions options = new ChromeOptions();
        options.setBinary(YANDEX_BROWSER_PATH);
        return new ChromeDriver(options);
    }
}