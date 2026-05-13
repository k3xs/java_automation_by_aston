package tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.HomePage;
import pages.PaymentPage;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PaymentTests {

    private WebDriver driver;
    private HomePage homePage;

    @BeforeEach
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("https://www.mts.by/");
        driver.manage().window().maximize();

        homePage = new HomePage(driver);
        homePage.acceptCookies();
    }

    @AfterEach
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }

    @Test
    public void testCommunicationServiceFieldsPlaceholders() {
        PaymentPage paymentPage = homePage.selectCommunicationService();

        assertEquals("Номер телефона", paymentPage.getPhonePlaceholder(),
                "Placeholder поля 'Номер телефона' не соответствует ожидаемому");
        assertEquals("Сумма", paymentPage.getSumPlaceholder(),
                "Placeholder поля 'Сумма' не соответствует ожидаемому");
        assertEquals("E-mail для отправки чека", paymentPage.getEmailPlaceholder(),
                "Placeholder поля 'E-mail для отправки чека' не соответствует ожидаемому");
    }

    @Test
    public void testHomeInternetFieldsPlaceholders() {
        PaymentPage paymentPage = homePage.selectHomeInternetService();

        assertEquals("Номер абонента", paymentPage.getPhonePlaceholder(),
                "Placeholder поля 'Номер абонента' не соответствует ожидаемому");
        assertEquals("Сумма", paymentPage.getSumPlaceholder(),
                "Placeholder поля 'Сумма' не соответствует ожидаемому");
        assertEquals("E-mail для отправки чека", paymentPage.getEmailPlaceholder(),
                "Placeholder поля 'E-mail для отправки чека' не соответствует ожидаемому");
    }

    @Test
    public void testInstallmentFieldsPlaceholders() {
        PaymentPage paymentPage = homePage.selectInstallmentService();

        assertEquals("Номер счета на 44", paymentPage.getScoreInstallmentPlaceholder(),
                "Placeholder поля 'Номер счета на 44' не соответствует ожидаемому");
        assertEquals("Сумма", paymentPage.getSumPlaceholder(),
                "Placeholder поля 'Сумма' не соответствует ожидаемому");
        assertEquals("E-mail для отправки чека", paymentPage.getEmailPlaceholder(),
                "Placeholder поля 'E-mail для отправки чека' не соответствует ожидаемому");
    }

    @Test
    public void testArrearsFieldsPlaceholders() {
        PaymentPage paymentPage = homePage.selectArrearsService();

        assertEquals("Номер счета на 2073", paymentPage.getScoreArrearsPlaceholder(),
                "Placeholder поля 'Номер счета на 2073' не соответствует ожидаемому");
        assertEquals("Сумма", paymentPage.getSumPlaceholder(),
                "Placeholder поля 'Сумма' не соответствует ожидаемому");
        assertEquals("E-mail для отправки чека", paymentPage.getEmailPlaceholder(),
                "Placeholder поля 'E-mail для отправки чека' не соответствует ожидаемому");
    }
}