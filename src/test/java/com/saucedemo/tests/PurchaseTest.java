package com.saucedemo.tests;

import com.saucedemo.page_functions.*;
import com.saucedemo.core.CoreTestIntegrationSD;
import core.Listener;
import io.qameta.allure.*;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Test
@Epic("Epic 1")
@Listeners(Listener.class)
public class PurchaseTest extends CoreTestIntegrationSD {

    LoginImpl login;
    HomeImpl home;
    CartImpl cart;
    CheckoutFillImpl checkoutFill;
    CheckoutOverviewImpl checkoutOverview;
    CheckoutCompleteImpl checkoutComplete;

    @Test
    @Description("Create 'impl' object before class.")
    public void initImpl() {
        login = new LoginImpl(bot);
        home = new HomeImpl(bot);
        cart = new CartImpl(bot);
        checkoutFill = new CheckoutFillImpl(bot);
        checkoutOverview = new CheckoutOverviewImpl(bot);
        checkoutComplete = new CheckoutCompleteImpl(bot);
    }

    @Test(dependsOnMethods = "initImpl")
    @Description("www.saucedemo.com - Tests that the user can make successful purchase of item.")
    @Severity(SeverityLevel.CRITICAL)
    @Story("STORY 1")
    @Feature("FEATURE 1")
    @Owner("Varun Chawla")
    public void test_to_verify_item_purchase_success() {
        logStep("Validate that we're on the correct website.");
        login.validateWebsite();

        logStep("Get credentials from DOM.");
        login.getCredentials();

        logStep("Login to the application.");
        login.login();

        logStep("Generate random number. Range: No. of articles on the page.");
        int randomN = home.generateRandom();

        logStep("Pick random article.");
        String[] articleArray = home.pickAnyArticle();

        logStep("Store price of all the articles");
        String[] priceArray = home.storePrice();

        logStep("Add that article to cart.");
        home.addToCart();

        logStep("Go to cart.");
        home.goToCart();

        logStep("Verify that the article added to the cart is correct.");
        cart.verifyArticle(articleArray, priceArray, randomN);

        logStep("Click checkout.");
        cart.clickCheckout();

        logStep("Fill checkout details and click 'continue.");
        checkoutFill.fillCheckoutDetails();

        logStep("Click 'finish' and checkout.");
        checkoutOverview.clickFinish();

        logStep("Verify purchase success message.");
        checkoutComplete.verifyPurchaseSuccess();

        logStep("Click 'cart'.");
        checkoutComplete.goToCart();

        logStep("Validate that the cart is empty.");
        cart.validateCartEmptiness();
    }

}
