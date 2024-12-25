package mts;

import org.junit.jupiter.api.*;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.springpattern.mts.factory.ChromeDriverProvider;
import org.springpattern.mts.factory.WebDriverProvider;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;


public class MtsBaseTest {
    protected WebDriver driver;
    protected final String url = "https://www.mts.by/";


    private static String browserList = "chrome";
    private static List<WebDriverProvider> browserProviders = new ArrayList<>();

    static {
        String browsers = System.getProperty("browsers", browserList);
        for (String browser : browsers.split(",")) {
            switch (browser.trim().toLowerCase()) {
                case "chrome":
                    browserProviders.add(new ChromeDriverProvider());
                    break;
                default:
                    throw new IllegalArgumentException("Неподдерживаемый браузер: " + browser);
            }
        }
    }

    @BeforeEach
    public void setUp(TestInfo testInfo) {
        driver = browserProviders.get(0).createDriver();
        driver.manage().window().maximize();
    }

    protected void basicFunctionality() {
        driver.get(url);
        handleCookiePopup(driver);
        scrollToRow(driver);
    }

    private void handleCookiePopup(WebDriver driver) {
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            WebElement cookiePopup = wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("cookie__wrapper")));
            WebElement acceptButton = wait.until(ExpectedConditions.elementToBeClickable(By.id("cookie-agree")));

            acceptButton.click();
        } catch (NoSuchElementException e) {
            // Игнорируем, если элемент не найден
        }
    }

    private void scrollToRow(WebDriver driver) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true);", driver.findElement(By.className("pay")));
    }

    @AfterEach
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
