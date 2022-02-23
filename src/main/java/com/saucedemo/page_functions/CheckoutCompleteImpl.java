package com.saucedemo.page_functions;

import com.saucedemo.object_repository.CheckoutComplete;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.testng.SkipException;
import org.testng.asserts.SoftAssert;
import utils.CoreActions;

public class CheckoutCompleteImpl extends CoreActions {
    public CheckoutCompleteImpl(WebDriver bot) {
        super(bot);
        if(!bot.findElement(CheckoutComplete.CART).isDisplayed()) {
            throw new SkipException("The purchase success/failure page did not get loaded.");
        }
    }

    SoftAssert softAssert = new SoftAssert();

    @Step("Verify purchase success.")
    public void verifyPurchaseSuccess() {
        waitForVisibility(CheckoutComplete.PURCHASE_SUCCESS_TXT);
        softAssert.assertEquals("Your order has been dispatched, and will arrive just as fast as the pony can get there!",
            getText(CheckoutComplete.PURCHASE_SUCCESS_TXT));
    }

    @Step("Click 'Cart'.")
    public void goToCart() {
        click(CheckoutComplete.CART);
    }
}
