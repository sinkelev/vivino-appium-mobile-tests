package org.sinkelev.tests.pages;

import static java.time.temporal.ChronoUnit.SECONDS;

import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.WithTimeout;
import io.qameta.allure.Step;

import org.openqa.selenium.WebElement;
import org.sinkelev.tests.base.page.BasePage;

public class LoginPage extends BasePage {
    @WithTimeout(time = 30, chronoUnit = SECONDS)
    @AndroidFindBy(id = "vivino.web.app:id/btn_email_continue")
    private WebElement emailEnterBtn;

    @WithTimeout(time = 10, chronoUnit = SECONDS)
    @AndroidFindBy(id = "vivino.web.app:id/edit_text")
    private WebElement emailInput;

    @WithTimeout(time = 10, chronoUnit = SECONDS)
    @AndroidFindBy(id = "vivino.web.app:id/btn_fb_continue")
    private WebElement nextBtn;

    @WithTimeout(time = 10, chronoUnit = SECONDS)
    @AndroidFindBy(xpath = "//*[@text='Password']")
    private WebElement passwordInput;

    @AndroidFindBy(xpath = "//android.widget.Button[@text='Log in']")
    private WebElement logInBtn;

    @AndroidFindBy(xpath = "//*[@text='Log in']")
    private WebElement searchInput;

    @Step("Click on 'Continue with email'")
    public LoginPage clickEmailEnterBtn() {
        emailEnterBtn.click();
        return this;
    }

    @Step("Enter email")
    public LoginPage enterEmail() {
        emailInput.sendKeys("apple_909@mail.ru");
        return this;
    }

    @Step("Click 'Continue'")
    public LoginPage clickNextButton() {
        nextBtn.click();
        return this;
    }

    @Step("Enter password")
    public LoginPage enterPassword() {
        passwordInput.isDisplayed();
        passwordInput.sendKeys("111111Qw");
        return this;
    }

    @Step("Click on 'Log in'")
    public LoginPage clickLogInBtn() {
        logInBtn.isDisplayed();
        logInBtn.click();
        return this;
    }

    @Step("Open Home page")
    public HomePage getMainPage() {
        return new HomePage();
    }
}
