package com.saucedemo.page_functions;

import com.saucedemo.object_repository.Cart;
import com.saucedemo.object_repository.Home;
import io.qameta.allure.Step;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import utils.CoreActions;

import static com.saucedemo.page_functions.HomeImpl.*;

public class CartImpl extends CoreActions {
    public CartImpl(WebDriver bot) {
        super(bot);
    }


    @Step("Verify the correct item has been selected.")
    public void verifyItem() {
        waitForVisibility(Cart.CART_ARTICLE_NAME);
        Assert.assertEquals( bot.findElement(Cart.CART_ARTICLE_NAME).getText(), HomeImpl.articleArray[randomN]);

        for (int i = 0; i < 5; i++) {
            System.out.println(HomeImpl.articleArray[i]);
        }

        waitForVisibility(Cart.CART_ARTICLE_PRICE);
        Assert.assertEquals(bot.findElement(Cart.CART_ARTICLE_PRICE).getText(), priceArray[randomN]);

        System.out.println(bot.findElement(Cart.CART_ARTICLE_NAME).getText());
        System.out.println(bot.findElement(Cart.CART_ARTICLE_PRICE).getText());
    }
}
