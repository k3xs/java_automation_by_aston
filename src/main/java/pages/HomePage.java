package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class HomePage extends BasePage {

    // Локаторы
    private final By cookieAgreeButton = By.id("cookie-agree");
    private final By serviceSelector = By.cssSelector(".select__header");
    private final By communicationService = By.cssSelector(".select__list > li:nth-child(1)");
    private final By homeInternetService = By.cssSelector(".select__list > li:nth-child(2)");
    private final By installmentService = By.cssSelector(".select__list > li:nth-child(3)");
    private final By arrearsService = By.cssSelector(".select__list > li:nth-child(4)");

    public HomePage(WebDriver driver) {
        super(driver);
    }

    @Override
    public boolean isLoaded() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(serviceSelector)).isDisplayed();
    }

    public void acceptCookies() {
        wait.until(ExpectedConditions.elementToBeClickable(cookieAgreeButton)).click();
    }

    public PaymentPage selectCommunicationService() {
        openServiceSelector();
        wait.until(ExpectedConditions.elementToBeClickable(communicationService)).click();
        return new PaymentPage(driver, PaymentType.COMMUNICATION);
    }

    public PaymentPage selectHomeInternetService() {
        openServiceSelector();
        wait.until(ExpectedConditions.elementToBeClickable(homeInternetService)).click();
        return new PaymentPage(driver, PaymentType.HOME_INTERNET);
    }

    public PaymentPage selectInstallmentService() {
        openServiceSelector();
        wait.until(ExpectedConditions.elementToBeClickable(installmentService)).click();
        return new PaymentPage(driver, PaymentType.INSTALLMENT);
    }

    public PaymentPage selectArrearsService() {
        openServiceSelector();
        wait.until(ExpectedConditions.elementToBeClickable(arrearsService)).click();
        return new PaymentPage(driver, PaymentType.ARREARS);
    }

    private void openServiceSelector() {
        wait.until(ExpectedConditions.elementToBeClickable(serviceSelector)).click();
    }
}