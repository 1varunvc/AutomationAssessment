package com.saucedemo.page_functions;

import com.saucedemo.object_repository.Cart;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.testng.SkipException;
import org.testng.asserts.SoftAssert;
import utils.CoreActions;

public class CartImpl extends CoreActions {
    public CartImpl(WebDriver bot) {
        super(bot);

        if(!bot.findElement(Cart.CART_ARTICLE_NAME).isDisplayed()) {
            throw new SkipException("The 'Cart' page did not get loaded.");
        }
    }

    SoftAssert softAssert = new SoftAssert();

    @Step("Verify the correct item has been selected.")
    public void verifyArticle(String articleName, String articlePrice) {
        waitForVisibility(Cart.CART_ARTICLE_NAME);

        softAssert.assertEquals( bot.findElement(Cart.CART_ARTICLE_NAME).getText(), articleName, "Expected article name: " + articleName + "Actual article name:" + bot.findElement(Cart.CART_ARTICLE_NAME).getText());

        waitForVisibility(Cart.CART_ARTICLE_PRICE);
        softAssert.assertEquals(bot.findElement(Cart.CART_ARTICLE_PRICE).getText(), articlePrice);
    }

    @Step("Click checkout.")
    public CheckoutFillImpl clickCheckout() {
        click(Cart.CHECKOUT);
        return new CheckoutFillImpl(bot);
    }

    @Step("Verify that the cart is empty.")
    public void validateCartEmptiness() {
        softAssert.assertTrue(bot.findElements(Cart.CART_ARTICLE_NAME).isEmpty());
    }

    @Step("Read the overall status of all the soft asserts.")
    public void assertAll() { softAssert.assertAll(); }
}
