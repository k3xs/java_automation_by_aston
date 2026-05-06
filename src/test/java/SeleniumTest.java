//Необходимо написать автотесты для сайта mts.by.
// Суть тестов заключается в проверке блока «Онлайн пополнение без комиссии»:
//1. Проверить название указанного блока;
//2. Проверить наличие логотипов платёжных систем;
//3. Проверить работу ссылки «Подробнее о сервисе»;
//4. Заполнить поля и проверить работу кнопки «Продолжить» (проверяем только вариант «Услуги связи», номер для теста 297777777)

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class SeleniumTest {


    @Test
    public void checkBlockOnlinePay() {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.mts.by/");

        WebElement blockOnlinePay = driver.findElement(By.xpath("//h2[contains(text(),'Онлайн пополнение')]"));
        assertTrue(blockOnlinePay.isDisplayed());

        String expectedText = "Онлайн пополнение без комиссии";
        String actualText = blockOnlinePay.getText().replace("\n", " ");

        assertTrue(actualText.contains("Онлайн пополнение"));

        driver.quit();
    }

    @Test
    public void checkPayPartnersLogo() {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.mts.by/");

        WebElement payPartnerVisa = driver.findElement(By.cssSelector("#pay-section > div > div > div.col-12.col-xl-8 > section > div > div.pay__partners > ul > li:nth-child(1)"));
        assertTrue(payPartnerVisa.isDisplayed());

        WebElement payPartnerVerifiedByVisa = driver.findElement(By.cssSelector("#pay-section > div > div > div.col-12.col-xl-8 > section > div > div.pay__partners > ul > li:nth-child(2)"));
        assertTrue(payPartnerVerifiedByVisa.isDisplayed());

        WebElement payPartnerMasterCard = driver.findElement(By.cssSelector("#pay-section > div > div > div.col-12.col-xl-8 > section > div > div.pay__partners > ul > li:nth-child(3)"));
        assertTrue(payPartnerMasterCard.isDisplayed());

        WebElement payPartnerMasterCardSecure = driver.findElement(By.cssSelector("#pay-section > div > div > div.col-12.col-xl-8 > section > div > div.pay__partners > ul > li:nth-child(4)"));
        assertTrue(payPartnerMasterCardSecure.isDisplayed());

        WebElement payPartnerBelkart = driver.findElement(By.cssSelector("#pay-section > div > div > div.col-12.col-xl-8 > section > div > div.pay__partners > ul > li:nth-child(5)"));
        assertTrue(payPartnerBelkart.isDisplayed());

        driver.quit();
    }

    @Test
    public void checkLinkAboutService() {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.mts.by/");

        WebElement linkAboutService = driver.findElement(By.cssSelector("#pay-section > div > div > div.col-12.col-xl-8 > section > div > a"));
        assertTrue(linkAboutService.isDisplayed());
        String currentUrl = driver.getCurrentUrl();
        linkAboutService.click();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.not(ExpectedConditions.urlToBe(currentUrl)));

        String newUrl = driver.getCurrentUrl();
        assertTrue(newUrl.contains("poryadok-oplaty"),
                "URL не содержит ожидаемый путь. Текущий URL: " + newUrl);

        driver.quit();

    }

    @Test
    public void checkContinueButton() throws InterruptedException{
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.mts.by/");

        WebElement inputPhoneNumber = driver.findElement(By.cssSelector("#connection-phone"));
        inputPhoneNumber.sendKeys("297777777");
        Thread.sleep(3000);


        WebElement inputSum = driver.findElement(By.cssSelector("#connection-sum"));
        inputSum.sendKeys("99");
        Thread.sleep(3000);

        WebElement inputEmail = driver.findElement(By.cssSelector("#connection-email"));
        inputEmail.sendKeys("example@emailtest.com");
        Thread.sleep(3000);

        WebElement continueButton = driver.findElement(By.cssSelector("#pay-connection > button"));
        continueButton.click();
        Thread.sleep(5000);

//        WebElement payModal = driver.findElement(By.cssSelector("#cc-number"));
//        assertTrue(payModal.isDisplayed());

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement payModal = wait.until(
                ExpectedConditions.visibilityOfElementLocated(
                        By.cssSelector("body > div.payment-widget-app")
                )
        );

        assertTrue(payModal.isDisplayed());

        driver.quit();
    }
}