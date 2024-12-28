package pageObject;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class HomePage extends BasePage {

    private By onlineReplenishmentPhoneInput = By.id("connection-phone");
    private By onlineReplenishmentSumInput = By.id("connection-sum");
    private By onlineReplenishmentEmailInput = By.id("connection-email");
    private By onlineReplenishmentSubmitButton = By.cssSelector("form#pay-connection button[type='submit']");
    private By iframeElement = By.className("bepaid-iframe");
    private By wrapper = By.className("app-wrapper");
    private By cookie = By.className("cookie__wrapper");
    private By cookieOkButton = By.id("cookie-agree");
    private By onlineReplenishment = By.className("pay");
    private By onlineReplenishmentFields = By.className("select__header");
    private By onlineReplenishmentList = By.className("select__item");
    private By paymentWindoweHaderAmount = By.cssSelector(".pay-description__cost span");
    private By paymentWindowAmountButton = By.cssSelector(".colored.disabled");
    private By phonePaymentWindow = By.cssSelector(".pay-description__text");
    private By bankCardPaymentWindow = By.cssSelector("input[formcontrolname='creditCard']");
    private By paymentWindowCardExpirationDate = By.cssSelector("input[formcontrolname='expirationDate']");
    private By paymentWindowCVC = By.cssSelector("input[formcontrolname='cvc']");
    private By paymentWindowName = By.cssSelector("input[formcontrolname='holder']");
    private By paymentWindowPlaceholders = By.xpath("./following-sibling::label");
    private By paymentWindowIconContainer = By.cssSelector("div.icons-container");


    public HomePage(WebDriver driver) {
        super(driver);
        URL = "https://www.mts.by/";
    }


    public void handleCookiePopup() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        try {

            WebElement cookiePopup = wait.until(ExpectedConditions.visibilityOfElementLocated(cookie));
            WebElement acceptButton = wait.until(ExpectedConditions.elementToBeClickable(cookieOkButton));

            acceptButton.click();
        } catch (TimeoutException e) {
            // Игнорируем, если элемент не найден
        }
    }

    public void scrollToRow() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true);", driver.findElement(onlineReplenishment));
    }


    public void fieldSelectionAndVerification(String optionToSelect, Map<String, String> fieldChecks) {
        WebElement selectHeader = driver.findElement(onlineReplenishmentFields);
        selectHeader.click();
        listItemClick(optionToSelect);
        checkPlaceholder(fieldChecks);
    }

    public void listItemClick(String optionToSelect) {
        List<WebElement> selectOptions = driver.findElements(onlineReplenishmentList);
        for (WebElement option : selectOptions) {
            String currentOptionText = option.getText();
            if (currentOptionText.equals(optionToSelect)) {
                option.click();
                break;
            }
        }
    }


    private void checkPlaceholder(Map<String, String> fieldChecks) {
        for (Map.Entry<String, String> entry : fieldChecks.entrySet()) {
            String fieldId = entry.getKey();
            String expectedPlaceholder = entry.getValue();
            WebElement fieldElement = driver.findElement(By.id(fieldId));
            String actualPlaceholder = fieldElement.getAttribute("placeholder");
            assertEquals(expectedPlaceholder, actualPlaceholder);
        }
    }

    public void fillingFieldsCommunicationServices() {
        WebElement phoneInput = driver.findElement(onlineReplenishmentPhoneInput);
        System.out.println(phoneInput.isDisplayed() + "  " + phoneInput.getText());
        phoneInput.sendKeys("297777777");

        WebElement sumInput = driver.findElement(onlineReplenishmentSumInput);
        sumInput.sendKeys("50");

        WebElement emailInput = driver.findElement(onlineReplenishmentEmailInput);
        emailInput.sendKeys("test@example.com");

        WebElement submitButton = driver.findElement(onlineReplenishmentSubmitButton);
        submitButton.click();
    }

    private void openIframe() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        WebElement iframeElement = wait.until(ExpectedConditions.visibilityOfElementLocated(this.iframeElement));
        driver.switchTo().frame(iframeElement);
        wait.until(ExpectedConditions.visibilityOfElementLocated(this.wrapper));
    }

    public void comparisonEnteredAmountInTitle() {
        comparisonEnteredValues("50.00 BYN", paymentWindoweHaderAmount);
    }

    public void comparisonEnteredAmountInButton() {
        comparisonEnteredValues("Оплатить 50.00 BYN", paymentWindowAmountButton);
    }

    public void comparisonPhoneNumber() {
        comparisonEnteredValues("375297777777", phonePaymentWindow);
    }

    private void comparisonEnteredValues(String text, By selector) {
        openIframe();
        WebElement sumDisplay = driver.findElement(selector);
        String displayedSum = sumDisplay.getText();
        displayedSum = phoneNumberValidation(displayedSum);
        assertEquals(text, displayedSum);
        driver.switchTo().defaultContent();
    }

    private String phoneNumberValidation(String phoneNumber) {
        int lastIndex = phoneNumber.lastIndexOf(":");
        if (lastIndex != -1 && lastIndex + 1 < phoneNumber.length()) {
            return phoneNumber.substring(lastIndex + 1).trim();
        }
        return phoneNumber;
    }

    public void bankCardNumber() {
        comparisonEmptyBankCardFields("Номер карты", bankCardPaymentWindow);
    }

    public void bankCardValidityPeriod() {
        comparisonEmptyBankCardFields("Срок действия", paymentWindowCardExpirationDate);
    }

    public void bankCardCVC() {
        comparisonEmptyBankCardFields("CVC", paymentWindowCVC);
    }

    public void bankCardName() {
        comparisonEmptyBankCardFields("Имя держателя (как на карте)", paymentWindowName);
    }

    private void comparisonEmptyBankCardFields(String text, By selector) {
        openIframe();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement cardInput = wait.until(ExpectedConditions.visibilityOfElementLocated(selector));

        WebElement label = cardInput.findElement(paymentWindowPlaceholders);

        String actualPlaceholder = label.getText();

        assertEquals(text, actualPlaceholder);
        driver.switchTo().defaultContent();
    }

    public void paymentWindowPaymentIcons() {
        openIframe();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        try {
            WebElement iconsContainer = wait.until(ExpectedConditions.visibilityOfElementLocated(paymentWindowIconContainer));
            List<WebElement> icons = iconsContainer.findElements(By.tagName("img"));
            if (icons.size() > 0) {
                System.out.println("Иконки найдены: " + icons.size());
                for (WebElement icon : icons) {
                    System.out.println("Источник иконки: " + icon.getAttribute("src"));
                }
            } else {
                System.out.println("Иконки не найдены.");
            }
        } catch (Exception e) {
            System.out.println("Ошибка при поиске иконок: " + e.getMessage());
        } finally {
            driver.switchTo().defaultContent();
        }
    }
}
