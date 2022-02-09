package com.saucedemo.tests;

import com.saucedemo.page_functions.CartImpl;
import com.saucedemo.page_functions.HomeImpl;
import com.saucedemo.page_functions.LoginImpl;
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

    @Test
    @Description("Create 'impl' object before class.")
    public void initImpl() {
        login = new LoginImpl(bot);
        home = new HomeImpl(bot);
        cart = new CartImpl(bot);
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

        logStep("Pick random article.");
        home.pickAnyArticle();

        logStep("Add that article to cart.");
        home.addToCart();

        logStep("Go to cart.");
        home.goToCart();

        logStep("Verify that the article added to cart is correct");
        cart.verifyItem();
    }

}
