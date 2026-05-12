//Продолжим работу над блоком «Онлайн пополнение без комиссии» сайта mts.by.
//1. Проверить надписи в незаполненных полях каждого варианта оплаты услуг:
//услуги связи, домашний, интернет, рассрочка, задолженность;


import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Task1 {

    @Test
    public void checkPaymentCommunicationService() {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.mts.by/");

        //Принимаем cookie
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement cookieAgreeButton = wait.until(ExpectedConditions.elementToBeClickable(By.id("cookie-agree")));
        cookieAgreeButton.click();

        //Выпадающий список
        WebElement serviceSelector = driver.findElement(By.cssSelector(".select__header"));
        serviceSelector.click();

        //Пункт "Услуги связи" из выпадающего списка
        WebElement communicationService = driver.findElement(By.cssSelector(".select__list > li:nth-child(1)"));
        communicationService.click();

        //Поле ввода номера телефона
        WebElement subscriberNumberField = driver.findElement(By.id("connection-phone"));
        String expectedSubscriberNumberPlaceholder = "Номер телефона";
        String actualSubscriberNumberPlaceholder = subscriberNumberField.getAttribute("placeholder");
        assertEquals(expectedSubscriberNumberPlaceholder, actualSubscriberNumberPlaceholder);

        //Поле ввода суммы
        WebElement sumInputField = driver.findElement(By.id("connection-sum"));
        String expectedSumInputPlaceholder = "Сумма";
        String actualSumInputPlaceholder = sumInputField.getAttribute("placeholder");
        assertEquals(expectedSumInputPlaceholder, actualSumInputPlaceholder);

        //Поле ввода E-mail
        WebElement emailField = driver.findElement(By.id("connection-email"));
        String expectedEmailFieldPlaceholder = "E-mail для отправки чека";
        String actualEmailFieldPlaceholder = emailField.getAttribute("placeholder");
        assertEquals(expectedEmailFieldPlaceholder, actualEmailFieldPlaceholder);

        driver.quit();
    }

    @Test
    public void checkHomeInternetFields() {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.mts.by/");

        //Принимаем cookie
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement cookieAgreeButton = wait.until(ExpectedConditions.elementToBeClickable(By.id("cookie-agree")));
        cookieAgreeButton.click();

        //Выпадающий список
        WebElement serviceSelector = driver.findElement(By.cssSelector(".select__header"));
        serviceSelector.click();

        //Пункт "Домашний интернет" из выпадающего списка
        WebElement homeInternet = driver.findElement(By.cssSelector(".select__list > li:nth-child(2)"));
        homeInternet.click();

        //Поле ввода номера абонента
        WebElement telephoneNumberField = driver.findElement(By.id("internet-phone"));
        String expectedTelephoneNumberPlaceholder = "Номер абонента";
        String actualTelephoneNumberPlaceholder = telephoneNumberField.getAttribute("placeholder");
        assertEquals(expectedTelephoneNumberPlaceholder, actualTelephoneNumberPlaceholder);

        //Поле ввода суммы
        WebElement sumInputField = driver.findElement(By.id("internet-sum"));
        String expectedSumInputPlaceholder = "Сумма";
        String actualSumInputPlaceholder = sumInputField.getAttribute("placeholder");
        assertEquals(expectedSumInputPlaceholder, actualSumInputPlaceholder);

        //Поле ввода E-mail
        WebElement emailField = driver.findElement(By.id("internet-email"));
        String expectedEmailFieldPlaceholder = "E-mail для отправки чека";
        String actualEmailFieldPlaceholder = emailField.getAttribute("placeholder");
        assertEquals(expectedEmailFieldPlaceholder, actualEmailFieldPlaceholder);

        driver.quit();
    }

    @Test
    public void checkInstallmentFields() {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.mts.by/");

        //Принимаем cookie
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement cookieAgreeButton = wait.until(ExpectedConditions.elementToBeClickable(By.id("cookie-agree")));
        cookieAgreeButton.click();

        //Выпадающий список
        WebElement serviceSelector = driver.findElement(By.cssSelector(".select__header"));
        serviceSelector.click();

        //Пункт "Рассрочка" из выпадающего списка
        WebElement installment = driver.findElement(By.cssSelector(".select__list > li:nth-child(3)"));
        installment.click();

        //Поле ввода счета рассрочки
        WebElement scoreInstallmentField = driver.findElement(By.id("score-instalment"));
        String expectedScoreInstallmentPlaceholder = "Номер счета на 44";
        String actualScoreInstallmentPlaceholder = scoreInstallmentField.getAttribute("placeholder");
        assertEquals(expectedScoreInstallmentPlaceholder, actualScoreInstallmentPlaceholder);

        //Поле ввода суммы
        WebElement sumInputField = driver.findElement(By.id("instalment-sum"));
        String expectedSumInputPlaceholder = "Сумма";
        String actualSumInputPlaceholder = sumInputField.getAttribute("placeholder");
        assertEquals(expectedSumInputPlaceholder, actualSumInputPlaceholder);

        //Поле ввода E-mail
        WebElement emailField = driver.findElement(By.id("instalment-email"));
        String expectedEmailFieldPlaceholder = "E-mail для отправки чека";
        String actualEmailFieldPlaceholder = emailField.getAttribute("placeholder");
        assertEquals(expectedEmailFieldPlaceholder, actualEmailFieldPlaceholder);

        driver.quit();
    }

    @Test
    public void checkArrearsFields() {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.mts.by/");

        //Принимаем cookie
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement cookieAgreeButton = wait.until(ExpectedConditions.elementToBeClickable(By.id("cookie-agree")));
        cookieAgreeButton.click();

        //Выпадающий список
        WebElement serviceSelector = driver.findElement(By.cssSelector(".select__header"));
        serviceSelector.click();

        //Пункт "Задолженность" из выпадающего списка
        WebElement arrears = driver.findElement(By.cssSelector(".select__list > li:nth-child(4)"));
        arrears.click();

        //Поле ввода счета задолженности
        WebElement scoreArrearsField = driver.findElement(By.id("score-arrears"));
        String expectedScoreArrearsPlaceholder = "Номер счета на 2073";
        String actualScoreArrearsPlaceholder = scoreArrearsField.getAttribute("placeholder");
        assertEquals(expectedScoreArrearsPlaceholder, actualScoreArrearsPlaceholder);

        //Поле ввода суммы
        WebElement sumInputField = driver.findElement(By.id("arrears-sum"));
        String expectedSumInputPlaceholder = "Сумма";
        String actualSumInputPlaceholder = sumInputField.getAttribute("placeholder");
        assertEquals(expectedSumInputPlaceholder, actualSumInputPlaceholder);

        //Поле ввода E-mail
        WebElement emailField = driver.findElement(By.id("arrears-email"));
        String expectedEmailFieldPlaceholder = "E-mail для отправки чека";
        String actualEmailFieldPlaceholder = emailField.getAttribute("placeholder");
        assertEquals(expectedEmailFieldPlaceholder, actualEmailFieldPlaceholder);

        driver.quit();
    }
}
