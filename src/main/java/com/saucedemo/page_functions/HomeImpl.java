package com.saucedemo.page_functions;

import com.saucedemo.object_repository.Home;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.SkipException;
import utils.CoreActions;

import java.util.List;
import java.util.Random;

public class HomeImpl extends CoreActions {
    public HomeImpl(WebDriver bot) {
        super(bot);

        if(!bot.findElement(Home.ARTICLES).isDisplayed()) {
            throw new SkipException("Homepage did not get loaded.");
        }
    }

    int randomN;

    @Step("Generate random number.")
    public int generateRandom() {
        // https://stackoverflow.com/a/5887745/14597561
        Random random = new Random();
        return randomN = random.nextInt(6);
    }

    @Step("Store the name of all the articles")
    public String[] createArticleArray() {
        waitForVisibility(Home.ARTICLES);
        List<WebElement> articleList = bot.findElements(Home.ARTICLES);

        String[] articleArray = new String[articleList.size()];

        for (int i = 0; i < articleList.size(); i++ ) {
            articleArray[i] = articleList.get(i).getText();
        }
        return articleArray;
    }

    @Step("Store price of all the articles.")
    public String[] createPriceArray() {
        waitForVisibility(Home.PRICES);
        List<WebElement> priceList = bot.findElements(Home.PRICES);

        String[] priceArray = new String[priceList.size()];

        for (int i = 0; i < priceList.size(); i++) {
            priceArray[i] = priceList.get(i).getText();
        }

        return priceArray;
    }

    @Step("Add random article to cart.")
    public void addToCart() {
        waitForVisibility(Home.ADD_TO_CARTS);

        // https://stackoverflow.com/a/34895458/14597561
        List<WebElement> addToCartList = bot.findElements(Home.ADD_TO_CARTS);

        click(addToCartList.get(randomN));

/*
        https://stackoverflow.com/a/30232809/14597561
        The following works as well.
        addToCartList.get(randomN).click();
*/
    }

    @Step("Go to cart.")
    public CartImpl goToCart() {
        click(Home.CART);
        return new CartImpl(bot);
    }

}
