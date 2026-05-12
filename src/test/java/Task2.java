//Продолжим работу над блоком «Онлайн пополнение без комиссии» сайта mts.by.
//2. Для варианта «Услуги связи» заполнить поля в соответствии с пререквизитами из предыдущей темы,
//нажать кнопку «Продолжить» и в появившемся окне проверить корректность отображения суммы (в томчисле на кнопке),
//номера телефона, а также надписей в незаполненных полях для ввода реквизитов карты,
//наличие иконок платёжных систем.

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
import static org.junit.jupiter.api.Assertions.assertTrue;

public class Task2 {

    @Test
    public void checkCorrectInputData() {

        String TELEPHONE_NUMBER = "297777777";
        String SUM = "99";
        String EMAIL = "example@emailtest.com";

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

        //Находим и заполняем поле "Номер телефона"
        WebElement inputPhoneNumber = driver.findElement(By.cssSelector("#connection-phone"));
        inputPhoneNumber.sendKeys(TELEPHONE_NUMBER);

        //Находим и заполняем поле "Сумма"
        WebElement inputSum = driver.findElement(By.cssSelector("#connection-sum"));
        inputSum.sendKeys(SUM);

        //Находим и заполняем поле "Емейл"
        WebElement inputEmail = driver.findElement(By.cssSelector("#connection-email"));
        inputEmail.sendKeys(EMAIL);

        //Нажимаем кнопку "Продолжить"
        WebElement continueButton = driver.findElement(By.cssSelector("#pay-connection > button"));
        continueButton.click();

        //Ждем появления фрейма и проверяем его отображение
        WebDriverWait waitFrameCard = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement payFrame = waitFrameCard.until(
                ExpectedConditions.visibilityOfElementLocated(
                        By.cssSelector(".payment-widget-iframe")
                )
        );

        assertTrue(payFrame.isDisplayed());

        //Переключаемся во фрейм для дальнейшей работы
        WebElement iframe = driver.findElement(By.cssSelector("iframe.payment-widget-iframe"));
        driver.switchTo().frame(iframe);
        System.out.println("Успешно переключились в фрейм!");

        //Проверяем ранее введенную сумму в заголовке окна
        WebElement amountSpan = wait.until(
                ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(text(), 'BYN')]"))
        );
        assertTrue(amountSpan.isDisplayed());
        String actualAmount = amountSpan.getText();
        String expectedAmount = SUM + ".00 BYN";
        assertEquals(expectedAmount, actualAmount);

        //Проверяем ранее введенный телефонный номер
        WebElement numberSpan = wait.until(
                ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(text(), '297777777')]"))
        );
        assertTrue(numberSpan.isDisplayed());

        //Проверяем ранне введенную сумму на кнопке формы
        WebElement numberSpanOnButton = wait.until(
                ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(text(), 'Оплатить')]"))
        );
        assertTrue(numberSpanOnButton.isDisplayed());
        String actualAmountOnButton = numberSpanOnButton.getText();
        String expectedAmountOnButton = "Оплатить " + SUM + ".00 BYN";
        assertEquals(expectedAmountOnButton, actualAmountOnButton);

        //Проверяем надпись в поле "Номер карты"
        WebElement creditCardNumber = driver.findElement(By.xpath("//label[text()='Номер карты']"));
        String expectedCreditCardNumberPlaceholder = "Номер карты";
        String actualEmailFieldPlaceholderPlaceholder = creditCardNumber.getText();
        assertEquals(expectedCreditCardNumberPlaceholder, actualEmailFieldPlaceholderPlaceholder);

        //Проверяем надпись в поле "Срок действия"
        WebElement validityPeriod = driver.findElement(By.xpath("//label[text()='Срок действия']"));
        String expectedValidityPeriodPlaceholder = "Срок действия";
        String actualValidityPeriodPlaceholder = validityPeriod.getText();
        assertEquals(expectedValidityPeriodPlaceholder, actualValidityPeriodPlaceholder);

        //Проверяем надпись в поле "CVC"
        WebElement Cvc = driver.findElement(By.xpath("//label[text()='CVC']"));
        String expectedCvcPlaceholder = "CVC";
        String actualCvcPlaceholder = Cvc.getText();
        assertEquals(expectedCvcPlaceholder, actualCvcPlaceholder);

        //Проверяем надпись в поле "Имя и фамилия на карте"
        WebElement initials = driver.findElement(By.xpath("//label[text()='Имя и фамилия на карте']"));
        String expectedInitialsPlaceholder = "Имя и фамилия на карте";
        String actualInitialsPlaceholder = initials.getText();
        assertEquals(expectedInitialsPlaceholder, actualInitialsPlaceholder);

        //Проверяем наличие логотипов платежных систем
        WebElement visaLogo = driver.findElement(By.xpath("//img[contains(@src, 'visa-system.svg')]"));
        assertTrue(visaLogo.isDisplayed());

        WebElement mastercardLogo = driver.findElement(By.xpath("//img[contains(@src, 'mastercard-system.svg')]"));
        assertTrue(mastercardLogo.isDisplayed());

        WebElement belkartLogo = driver.findElement(By.xpath("//img[contains(@src, 'belkart-system.svg')]"));
        assertTrue(belkartLogo.isDisplayed());

//        WebElement mirLogo = wait.until(
//                ExpectedConditions.visibilityOfElementLocated(By.xpath("//img[contains(@src, 'mir-system.svg')]"))
//        );
//        assertTrue(mirLogo.isDisplayed());

        driver.quit();
    }
}
