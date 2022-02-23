package com.saucedemo.page_functions;

import com.saucedemo.object_repository.Home;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.SkipException;
import utils.CoreActions;

import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.List;

public class HomeImpl extends CoreActions {
    public HomeImpl(WebDriver bot) {
        super(bot);

        if(!bot.findElement(Home.ARTICLES).isDisplayed()) {
            throw new SkipException("Homepage did not get loaded.");
        }
    }

    int rValue;

    /**
     * We can also write it as:
     *  ```Random random = new Random();
     *  return randomN = random.nextInt(articleList.size());```
     * Refer https://stackoverflow.com/a/5887745/14597561
     */
    @Step("Generate random number.")
    public void generateRandom() throws NoSuchAlgorithmException {
        List<WebElement> articleList = bot.findElements(Home.ARTICLES);

        // SonarLint told about SecureRandom.
        rValue = SecureRandom.getInstanceStrong().nextInt(articleList.size());
    }

    @Step ("Store the name of the random article to be added to cart.")
    public String storeArticleName() {
        waitForVisibility(Home.ARTICLES);
        List<WebElement> articleList = bot.findElements(Home.ARTICLES);

        return articleList.get(rValue).getText();
    }

    @Step ("Store the price of the random article to be added to cart.")
    public String storeArticlePrice() {
        waitForVisibility(Home.PRICES);
        List<WebElement> priceList = bot.findElements(Home.PRICES);

        return priceList.get(rValue).getText();
    }

    /**
     * We can also use:
     * `addToCartList.get(randomN).click();`
     * Refer https://stackoverflow.com/a/30232809/14597561
     */
    @Step("Add random article to cart.")
    public void addToCart() {
        waitForVisibility(Home.ADD_TO_CARTS);

        // https://stackoverflow.com/a/34895458/14597561
        List<WebElement> addToCartList = bot.findElements(Home.ADD_TO_CARTS);

        click(addToCartList.get(rValue));
    }

    @Step("Go to cart.")
    public CartImpl goToCart() {
        click(Home.CART);
        return new CartImpl(bot);
    }

}
