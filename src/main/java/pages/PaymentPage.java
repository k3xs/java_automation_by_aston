package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class PaymentPage extends BasePage {

    private final PaymentType paymentType;

    // Константы для ID полей (разные для разных типов оплаты)
    private static final String COMMUNICATION_PHONE_ID = "connection-phone";
    private static final String HOME_INTERNET_PHONE_ID = "internet-phone";

    private static final String COMMUNICATION_SUM_ID = "connection-sum";
    private static final String HOME_INTERNET_SUM_ID = "internet-sum";
    private static final String INSTALLMENT_SUM_ID = "instalment-sum";
    private static final String ARREARS_SUM_ID = "arrears-sum";

    private static final String COMMUNICATION_EMAIL_ID = "connection-email";
    private static final String HOME_INTERNET_EMAIL_ID = "internet-email";
    private static final String INSTALLMENT_EMAIL_ID = "instalment-email";
    private static final String ARREARS_EMAIL_ID = "arrears-email";

    public PaymentPage(WebDriver driver, PaymentType paymentType) {
        super(driver);
        this.paymentType = paymentType;
    }

    @Override
    public boolean isLoaded() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(getSumFieldLocator())).isDisplayed();
    }

    // Локаторы (ленивая инициализация)
    private By getPhoneFieldLocator() {
        return By.id(getPhoneFieldId());
    }

    private By getSumFieldLocator() {
        return By.id(getSumFieldId());
    }

    private By getEmailFieldLocator() {
        return By.id(getEmailFieldId());
    }

    // Методы для получения элементов
    public String getPhonePlaceholder() {
        return driver.findElement(getPhoneFieldLocator()).getAttribute("placeholder");
    }

    public String getSumPlaceholder() {
        return driver.findElement(getSumFieldLocator()).getAttribute("placeholder");
    }

    public String getEmailPlaceholder() {
        return driver.findElement(getEmailFieldLocator()).getAttribute("placeholder");
    }

    public String getScoreInstallmentPlaceholder() {
        return driver.findElement(By.id("score-instalment")).getAttribute("placeholder");
    }

    public String getScoreArrearsPlaceholder() {
        return driver.findElement(By.id("score-arrears")).getAttribute("placeholder");
    }

    // Вспомогательные методы для получения ID полей в зависимости от типа оплаты
    private String getPhoneFieldId() {
        switch (paymentType) {
            case COMMUNICATION:
                return COMMUNICATION_PHONE_ID;
            case HOME_INTERNET:
                return HOME_INTERNET_PHONE_ID;
            default:
                throw new IllegalArgumentException("Для типа " + paymentType + " не требуется поле телефона");
        }
    }

    private String getSumFieldId() {
        switch (paymentType) {
            case COMMUNICATION:
                return COMMUNICATION_SUM_ID;
            case HOME_INTERNET:
                return HOME_INTERNET_SUM_ID;
            case INSTALLMENT:
                return INSTALLMENT_SUM_ID;
            case ARREARS:
                return ARREARS_SUM_ID;
            default:
                throw new IllegalArgumentException("Неизвестный тип оплаты: " + paymentType);
        }
    }

    private String getEmailFieldId() {
        switch (paymentType) {
            case COMMUNICATION:
                return COMMUNICATION_EMAIL_ID;
            case HOME_INTERNET:
                return HOME_INTERNET_EMAIL_ID;
            case INSTALLMENT:
                return INSTALLMENT_EMAIL_ID;
            case ARREARS:
                return ARREARS_EMAIL_ID;
            default:
                throw new IllegalArgumentException("Неизвестный тип оплаты: " + paymentType);
        }
    }
}