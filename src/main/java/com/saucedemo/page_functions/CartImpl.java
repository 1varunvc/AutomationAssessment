package com.saucedemo.page_functions;

import com.saucedemo.object_repository.Cart;
import io.qameta.allure.Step;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import utils.CoreActions;

public class CartImpl extends CoreActions {
    public CartImpl(WebDriver bot) {
        super(bot);
    }

    @Step("Verify the correct item has been selected.")
    public void verifyArticle(String[] articleArray, String[] priceArray, int randomN) {
        waitForVisibility(Cart.CART_ARTICLE_NAME);
        Assert.assertEquals( bot.findElement(Cart.CART_ARTICLE_NAME).getText(), articleArray[randomN]);

        waitForVisibility(Cart.CART_ARTICLE_PRICE);
        Assert.assertEquals(bot.findElement(Cart.CART_ARTICLE_PRICE).getText(), priceArray[randomN]);
    }

    @Step("Click checkout.")
    public CheckoutFillImpl clickCheckout() {
        click(Cart.CHECKOUT);
        return new CheckoutFillImpl(bot);
    }

    @Step("Verify that the cart is empty.")
    public void validateCartEmptiness() {
        Assert.assertTrue(bot.findElements(Cart.CART_ARTICLE_NAME).isEmpty());
    }
}
