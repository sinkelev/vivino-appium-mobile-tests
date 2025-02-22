package org.sinkelev.tests.pages;

import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.qameta.allure.Step;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.sinkelev.tests.base.page.BasePage;

import java.time.Duration;

public class LoginPage extends BasePage {

    public LoginPage() {
        PageFactory.initElements(new AppiumFieldDecorator(driver, Duration.ofSeconds(20)), this);
    }

    @AndroidFindBy(id = "vivino.web.app:id/btn_email_continue")
    private WebElement emailEnterBtn;

    @AndroidFindBy(id = "vivino.web.app:id/edit_text")
    private WebElement emailInput;

    @AndroidFindBy(id = "vivino.web.app:id/btn_fb_continue")
    private WebElement nextBtn;

    @AndroidFindBy(xpath = "//*[@text='Password']")
    private WebElement passwordInput;

    @AndroidFindBy(xpath = "//android.widget.Button[@text='Log in']")
    private WebElement logInBtn;

    @AndroidFindBy(xpath = "//*[@text='Log in']")
    private WebElement searchInput;

    @Step("Click on 'Continue with email'")
    public LoginPage clickEmailEnterBtn() {
        emailEnterBtn.isDisplayed();
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

    @Step("Check text on the page")
    public WebElement checkText(String text) {
        return wait.visibility(text(text));
    }
}
