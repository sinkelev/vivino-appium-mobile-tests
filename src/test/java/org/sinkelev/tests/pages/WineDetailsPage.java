package org.sinkelev.tests.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.sinkelev.tests.base.page.BasePage;

import java.time.Duration;

import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.qameta.allure.Step;

public class WineDetailsPage extends BasePage {

    public WineDetailsPage() {
        PageFactory.initElements(new AppiumFieldDecorator(driver, Duration.ofSeconds(20)), this);
    }

    @AndroidFindBy(id = "vivino.web.app:id/star_rating")
    public WebElement starsRating;

    @AndroidFindBy(id = "vivino.web.app:id/rating_count")
    public WebElement ratingCount;

    @AndroidFindBy(id = "vivino.web.app:id/avg_price_value")
    public WebElement avgPriceValue;

    @AndroidFindBy(id = "vivino.web.app:id/avg_price_label")
    public WebElement avgPriceLabel;

    @Step("Check text on the page")
    public WebElement checkText(String text) {
        return wait.visibility(text(text));
    }
}
