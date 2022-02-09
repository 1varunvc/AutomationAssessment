package com.saucedemo.page_functions;

import com.saucedemo.object_repository.CheckoutComplete;
import io.qameta.allure.Step;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import utils.CoreActions;

public class CheckoutCompleteImpl extends CoreActions {
    public CheckoutCompleteImpl(WebDriver bot) { super(bot); }

    @Step("Verify purchase success")
    public void verifyPurchaseSuccess() {
        waitForVisibility(CheckoutComplete.PURCHASE_SUCCESS_TXT);
        Assert.assertEquals("Your order has been dispatched, and will arrive just as fast as the pony can get there!",
            getText(CheckoutComplete.PURCHASE_SUCCESS_TXT));
    }

    @Step("Click 'Cart'.")
    public CartImpl goToCart() {
        click(CheckoutComplete.CART);
        return new CartImpl(bot);
    }

}
