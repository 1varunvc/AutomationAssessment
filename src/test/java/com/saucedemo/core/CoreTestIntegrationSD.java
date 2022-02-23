package com.saucedemo.core;

import com.saucedemo.object_repository.Login;
import com.saucedemo.page_functions.*;
import core.Logger;
import data_provider.Constants;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import utils.Bot;

public class CoreTestIntegrationSD {

    protected WebDriver bot;
    protected WebDriverWait wait;
    Constants constants;

    protected LoginImpl login;
    protected HomeImpl home;
    protected CartImpl cart;
    protected CheckoutFillImpl checkoutFill;
    protected CheckoutOverviewImpl checkoutOverview;
    protected CheckoutCompleteImpl checkoutComplete;

    @BeforeTest
    public void openBrowser() {
        bot = new Bot().startBot();
        bot.get(constants.configFileReader("URLSauceDemo"));

        login = new LoginImpl(bot);

        wait = new WebDriverWait(bot, 7);
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(Login.USERNAME_LIST));
    }

    protected static void logStep(String step) {
        Logger.step(step);
    }

    @AfterTest
    public void close() {
        bot.quit();
    }

}

