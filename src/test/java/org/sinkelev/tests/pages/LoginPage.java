package org.sinkelev.tests.pages;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

    private AppiumDriver<MobileElement> driver;

    @AndroidFindBy(id = "com.google.android.gm:id/welcome_tour_got_it")
    private MobileElement gotItButton;

    @AndroidFindBy(id = "com.google.android.gm:id/account_setup_text")
    private MobileElement addAccountButton;

    @AndroidFindBy(id = "com.google.android.gm:id/account_address")
    private MobileElement emailInput;

    @AndroidFindBy(id = "com.google.android.gm:id/next")
    private MobileElement nextButton;

    @AndroidFindBy(id = "com.google.android.gm:id/password")
    private MobileElement passwordInput;

    @AndroidFindBy(id = "com.google.android.gm:id/next")
    private MobileElement signInButton;

    public LoginPage(AppiumDriver<MobileElement> driver) {
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    public void clickGotItButton() {
        gotItButton.click();
    }

    public void clickAddAccountButton() {
        addAccountButton.click();
    }

    public void enterEmail(String email) {
        emailInput.sendKeys(email);
    }

    public void clickNextButton() {
        nextButton.click();
    }

    public void enterPassword(String password) {
        passwordInput.sendKeys(password);
    }

    public void clickSignInButton() {
        signInButton.click();
    }
}
