package com.saucedemo.tests;

import com.saucedemo.core.CoreTestIntegrationSD;
import core.Listener;
import io.qameta.allure.*;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import java.security.NoSuchAlgorithmException;

@Test
@Epic("Epic 1")
@Listeners(Listener.class)
public class PurchaseTest extends CoreTestIntegrationSD {

    @Test
    @Description("www.saucedemo.com - Tests that the user can make successful purchase of item.")
    @Severity(SeverityLevel.CRITICAL)
    @Story("STORY 1")
    @Feature("FEATURE 1")
    @Owner("Varun Chawla")
    public void test_to_verify_item_purchase_success() throws NoSuchAlgorithmException {
        logStep("Validate that we're on the correct website.");
        login.validateWebsite();

        logStep("Get credentials from DOM.");
        login.getCredentials();

        logStep("Login to the application.");
        home = login.login();

        logStep("Generate random number. Range: No. of articles on the page.");
        home.generateRandom();

        logStep("Pick random article.");
        String articleName = home.storeArticleName();

        logStep("Store price of all the articles");
        String articlePrice = home.storeArticlePrice();

        logStep("Add that article to cart.");
        home.addToCart();

        logStep("Go to cart.");
        cart = home.goToCart();

        logStep("Verify that the article added to the cart is correct.");
        cart.verifyArticle(articleName, articlePrice);

        logStep("Click checkout.");
        checkoutFill = cart.clickCheckout();

        logStep("Fill checkout details and click 'continue.");
        checkoutOverview = checkoutFill.fillCheckoutDetails();

        logStep("Click 'finish' and checkout.");
        checkoutComplete = checkoutOverview.clickFinish();

        logStep("Verify purchase success message.");
        checkoutComplete.verifyPurchaseSuccess();

        logStep("Click 'cart'.");
        checkoutComplete.goToCart();

        logStep("Validate that the cart is empty.");
        cart.validateCartEmptiness();

        logStep("Read the overall status of all the soft asserts.");
        cart.assertAll();
    }

}
