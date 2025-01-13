package mts.online_replenishment;

import dev.failsafe.internal.util.Assert;
import locators.PageObject;
import mts.MtsBaseTest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.*;

public class MtsOnlineReplenishment extends MtsBaseTest {


    @Test
    @DisplayName("Проверка названия указанного блока: \"Онлайн пополнение без комиссии\"")
    public void testTitle() {
        basicFunctionality();
        WebElement h2Element = driver.findElement(PageObject.h2Title);
        String h2Text = h2Element.getText().replace("\n", " ").trim();
        assertEquals("Онлайн пополнение без комиссии", h2Text);
    }

    @DisplayName("Проверка наличия логотипов платёжных систем")
    @ValueSource(strings = {"Visa", "Verified By Visa", "MasterCard", "MasterCard Secure Code", "Белкарт"})
    @ParameterizedTest
    public void testLogo(String altText) {
        basicFunctionality();
        driver.findElement(PageObject.logoSelector(altText));
    }

    @Test
    @DisplayName("Проверка работы ссылки \"Подробнее о сервисе\"")
    public void testServiceLink() {
        basicFunctionality();
        WebElement serviceLink = driver.findElement(PageObject.textLink);

        assertNotNull(serviceLink, "Ссылка 'Подробнее о сервисе' не найдена");

        String expectedUrl = "help/poryadok-oplaty-i-bezopasnost-internet-platezhey/";
        String actualUrl = serviceLink.getAttribute("href");

        assertTrue(actualUrl.contains(expectedUrl), "Ссылка ведет на неправильный URL: " + actualUrl);

        serviceLink.click();
        assertEquals(url + expectedUrl, driver.getCurrentUrl());
    }

    @Test
    @DisplayName("Проверка кнопки \"Продолжить\" в форме \"Услуги связи\" при заполненных полях")
    public void testInstalmentFormFields() {
        basicFunctionality();
        WebElement phoneInput = driver.findElement(PageObject.phoneInput);
        phoneInput.sendKeys("297777777");

        WebElement sumInput = driver.findElement(PageObject.sumInput);
        sumInput.sendKeys("50");

        WebElement emailInput = driver.findElement(PageObject.emailInput);
        emailInput.sendKeys("test@example.com");

        WebElement submitButton = driver.findElement(PageObject.submitButton);
        submitButton.click();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        WebElement iframeElement = wait.until(ExpectedConditions.visibilityOfElementLocated(PageObject.iframeElement));
        driver.switchTo().frame(iframeElement);
        isInsideFrame = true;
        wait.until(ExpectedConditions.visibilityOfElementLocated(PageObject.wrapper));
    }

}
