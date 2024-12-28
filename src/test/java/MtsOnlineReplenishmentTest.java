import io.github.bonigarcia.wdm.WebDriverManager;
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

    @ParameterizedTest
    @MethodSource("testCases")
    @DisplayName("Проверка полей для {0}")
    void testSelectAndVerifyFields(String optionToSelect, Map<String, String> fieldChecks) {
        HomePage homePage = new HomePage(driver);
        homePage.open();
        homePage.handleCookiePopup();
        homePage.scrollToRow();
        homePage.fieldSelectionAndVerification(optionToSelect, fieldChecks);
    }

    @Test
    @DisplayName("Проверка суммы в заголовке платежной системы")
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
    @DisplayName("Проверка суммы в кнопке платежной системы")
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
    @DisplayName("Проверка номера в платежной системе")
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
    @DisplayName("Проверка плейсхолдера номера карты в платежной системе")
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
    @DisplayName("Проверка плейсхолдера срока действия банковской карты в платежной системе")
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
    @DisplayName("Проверка плейсхолдера CVC банковской карты в платежной системе")
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
    @DisplayName("Проверка плейсхолдера имени на банковской карте в платежной системе")
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
    @DisplayName("Проверка отображения иконок в платежной системе")
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
