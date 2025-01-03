import io.github.bonigarcia.wdm.WebDriverManager;
import io.qameta.allure.Description;
import io.qameta.allure.Owner;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pageObject.HomePage;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Stream;

public class MtsOnlineReplenishmentTest {

    private WebDriver driver;


    private static Stream<Arguments> testCases() {
        Map<String, String> connectionChecks = new HashMap<>();
        connectionChecks.put("connection-phone", "Номер телефона");
        connectionChecks.put("connection-sum", "Сумма");
        connectionChecks.put("connection-email", "E-mail для отправки чека");

        Map<String, String> internetChecks = new HashMap<>();
        internetChecks.put("internet-phone", "Номер абонента");
        internetChecks.put("internet-sum", "Сумма");
        internetChecks.put("internet-email", "E-mail для отправки чека");

        Map<String, String> instalmentChecks = new HashMap<>();
        instalmentChecks.put("score-instalment", "Номер счета на 44");
        instalmentChecks.put("instalment-sum", "Сумма");
        instalmentChecks.put("instalment-email", "E-mail для отправки чека");

        Map<String, String> arrearsChecks = new HashMap<>();
        arrearsChecks.put("score-arrears", "Номер счета на 2073");
        arrearsChecks.put("arrears-sum", "Сумма");
        arrearsChecks.put("arrears-email", "E-mail для отправки чека");

        return Stream.of(
                Arguments.of("Услуги связи", connectionChecks),
                Arguments.of("Домашний интернет", internetChecks),
                Arguments.of("Рассрочка", instalmentChecks),
                Arguments.of("Задолженность", arrearsChecks)
        );
    }


    @BeforeAll
    public static void setupDriver() {
        WebDriverManager.chromedriver().setup();
    }

    @BeforeEach
    public void setUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @AfterEach
    public void closeDriver() {
        driver.close();
    }

    @Owner("Anton Trapeznikov")
    @Severity(SeverityLevel.MINOR)
    @DisplayName("Проверка полей для {0}")
    @Description("В этом тесте проверяется выпадающий список для блока 'Онлайн пополнение без комиссии' и поля, относящиеся к ним.")
    @MethodSource("testCases")
    @ParameterizedTest
    void testSelectAndVerifyFields(String optionToSelect, Map<String, String> fieldChecks) {
        HomePage homePage = new HomePage(driver);
        homePage.open();
        homePage.handleCookiePopup();
        homePage.scrollToRow();
        homePage.fieldSelectionAndVerification(optionToSelect, fieldChecks);
    }

    @Test
    @Owner("Anton Trapeznikov")
    @Severity(SeverityLevel.CRITICAL)
    @DisplayName("Проверка суммы в заголовке платежной системы")
    @Description("В этом тесте проверяется, соответствует ли сумма в заголовке платежного окна сумме в форме 'Услуги связи' при отправке её.")
    void paymentWindowAmountTitleDataTest() {
        HomePage homePage = new HomePage(driver);
        homePage.open();
        homePage.handleCookiePopup();
        homePage.scrollToRow();
        homePage.listItemClick("Услуги связи");
        homePage.fillingFieldsCommunicationServices();
        homePage.comparisonEnteredAmountInTitle();
    }

    @Test
    @Owner("Anton Trapeznikov")
    @Severity(SeverityLevel.CRITICAL)
    @DisplayName("Проверка суммы в кнопке платежной системы")
    @Description("В этом тесте проверяется, соответствует ли сумма на кнопке платежного окна сумме в форме 'Услуги связи' при отправке её.")
    void paymentWindowAmountButtonDataTest() {
        HomePage homePage = new HomePage(driver);
        homePage.open();
        homePage.handleCookiePopup();
        homePage.scrollToRow();
        homePage.listItemClick("Услуги связи");
        homePage.fillingFieldsCommunicationServices();
        homePage.comparisonEnteredAmountInButton();
    }

    @Test
    @Owner("Anton Trapeznikov")
    @Severity(SeverityLevel.CRITICAL)
    @DisplayName("Проверка номера в платежной системе")
    @Description("В этом тесте проверяется, соответствует ли номер телефона в платежном окне номеру телефона в форме 'Услуги связи' при отправке её.")
    void phoneDataPaymentWindowTest() {
        HomePage homePage = new HomePage(driver);
        homePage.open();
        homePage.handleCookiePopup();
        homePage.scrollToRow();
        homePage.listItemClick("Услуги связи");
        homePage.fillingFieldsCommunicationServices();
        homePage.comparisonPhoneNumber();
    }

    @Test
    @Owner("Anton Trapeznikov")
    @Severity(SeverityLevel.TRIVIAL)
    @DisplayName("Проверка плейсхолдера номера карты в платежной системе")
    @Description("В этом тесте проверяется плейсхолдер номера карты в платежном окне.")
    void bankCardNumberTest() {
        HomePage homePage = new HomePage(driver);
        homePage.open();
        homePage.handleCookiePopup();
        homePage.scrollToRow();
        homePage.listItemClick("Услуги связи");
        homePage.fillingFieldsCommunicationServices();
        homePage.bankCardNumber();
    }

    @Test
    @Owner("Anton Trapeznikov")
    @Severity(SeverityLevel.TRIVIAL)
    @DisplayName("Проверка плейсхолдера срока действия банковской карты в платежной системе")
    @Description("В этом тесте проверяется плейсхолдер срока годности карты в платежном окне.")
    void bankCardValidityPeriodTest() {
        HomePage homePage = new HomePage(driver);
        homePage.open();
        homePage.handleCookiePopup();
        homePage.scrollToRow();
        homePage.listItemClick("Услуги связи");
        homePage.fillingFieldsCommunicationServices();
        homePage.bankCardValidityPeriod();
    }

    @Test
    @Owner("Anton Trapeznikov")
    @Severity(SeverityLevel.TRIVIAL)
    @DisplayName("Проверка плейсхолдера CVC банковской карты в платежной системе")
    @Description("В этом тесте проверяется плейсхолдер CVC банковской карты в платежном окне.")
    void bankCardCVCTest() {
        HomePage homePage = new HomePage(driver);
        homePage.open();
        homePage.handleCookiePopup();
        homePage.scrollToRow();
        homePage.listItemClick("Услуги связи");
        homePage.fillingFieldsCommunicationServices();
        homePage.bankCardCVC();
    }

    @Test
    @Owner("Anton Trapeznikov")
    @Severity(SeverityLevel.TRIVIAL)
    @DisplayName("Проверка плейсхолдера имени на банковской карте в платежной системе")
    @Description("В этом тесте проверяется плейсхолдер имени банковской карты в платежном окне.")
    void bankCardNameTest() {
        HomePage homePage = new HomePage(driver);
        homePage.open();
        homePage.handleCookiePopup();
        homePage.scrollToRow();
        homePage.listItemClick("Услуги связи");
        homePage.fillingFieldsCommunicationServices();
        homePage.bankCardName();
    }

    @Test
    @Owner("Anton Trapeznikov")
    @Severity(SeverityLevel.NORMAL)
    @DisplayName("Проверка отображения иконок в платежной системе")
    @Description("В этом тесте проверяется наличие иконок способов оплаты в платежном окне.")
    void paymentWindowPaymentIconsTest() {
        HomePage homePage = new HomePage(driver);
        homePage.open();
        homePage.handleCookiePopup();
        homePage.scrollToRow();
        homePage.listItemClick("Услуги связи");
        homePage.fillingFieldsCommunicationServices();
        homePage.paymentWindowPaymentIcons();
    }
}
