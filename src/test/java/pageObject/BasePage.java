package pageObject;

import org.openqa.selenium.WebDriver;

public abstract class BasePage {
    protected WebDriver driver;
    protected String URL;

    public BasePage(WebDriver driver) {
        this.driver = driver;
    }

    public void open() {
        driver.get(URL);
    }

}
