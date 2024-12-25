package locators;

import org.openqa.selenium.By;

public class PageObject {

    public static By h2Title = By.cssSelector(".pay h2");
    public static By textLink = By.linkText("Подробнее о сервисе");
    public static By phoneInput = By.id("connection-phone");
    public static By sumInput = By.id("connection-sum");
    public static By emailInput = By.id("connection-email");
    public static By submitButton = By.cssSelector("form#pay-connection button[type='submit']");
    public static By iframeElement = By.className("bepaid-iframe");
    public static By wrapper = By.className("app-wrapper");

    public static By logoSelector(String altText) {
        return By.xpath("//img[@alt='" + altText + "']");
    }
}
