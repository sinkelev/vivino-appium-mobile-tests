package org.sinkelev.tests;

/*import org.sinkelev.tests.pages.ComposeEmailPage;
import org.sinkelev.tests.pages.EmailDetailsPage;
import org.sinkelev.tests.pages.InboxPage;*/
import org.sinkelev.tests.pages.LoginPage;
import org.sinkelev.utils.DriverManager;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.net.MalformedURLException;

public class MobileTest {

    private AppiumDriver<MobileElement> driver;
    private LoginPage loginPage;
/*    private InboxPage inboxPage;
    private ComposeEmailPage composeEmailPage;
    private EmailDetailsPage emailDetailsPage;*/

    @BeforeMethod
    public void setUp() throws MalformedURLException {
        DriverManager.uninstallApp();
        DriverManager.installApp();
        driver = DriverManager.getDriver();
        loginPage = new LoginPage(driver);
/*        inboxPage = new InboxPage(driver);
        composeEmailPage = new ComposeEmailPage(driver);
        emailDetailsPage = new EmailDetailsPage(driver);*/
    }

    @Test
    public void sendEmailTest() {
        // Пример теста для Gmail
        loginPage.clickGotItButton();
        loginPage.clickAddAccountButton();
        loginPage.enterEmail("your-email@example.com");
        loginPage.clickNextButton();
        loginPage.enterPassword("your-password");
        loginPage.clickSignInButton();
/*
        inboxPage.clickComposeButton();
        composeEmailPage.enterTo("recipient@example.com");
        composeEmailPage.enterSubject("Test Email");
        composeEmailPage.enterBody("This is a test email.");
        composeEmailPage.clickSendButton();*/

        // Добавьте проверки, чтобы убедиться, что письмо было отправлено
        // Например, проверьте, что письмо появилось в папке "Отправленные"
    }

    @AfterMethod
    public void tearDown() {
        DriverManager.quitDriver();
    }
}