package com.saucedemo.tests;

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
public class Test1 extends CoreTestIntegrationSD {

    LoginImpl login;
    HomeImpl home;

    @Test
    @Description("Create 'impl' object before class.")
    public void initImpl() {
        login = new LoginImpl(bot);
        home = new HomeImpl(bot);
    }

    @Test(dependsOnMethods = "initImpl")
    @Description("www.saucedemo.com - Tests that the user can make successful purchase of item.")
    @Severity(SeverityLevel.CRITICAL)
    @Story("STORY 1")
    @Feature("FEATURE 1")
    @Owner("Varun Chawla")
    public void test_to_verify_item_purchase_success() {
        logStep("Validate that we're on the correct website.");


        logStep("Get credentials from DOM.");
        login.getCredentials();

        logStep("Login to the application.");
        login.login();

        logStep("Add random item to cart.");
        home.addToCart();

        logStep("Go to cart.");
        home.goToCart();
    }

}
