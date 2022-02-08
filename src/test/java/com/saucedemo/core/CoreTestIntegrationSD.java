package com.saucedemo.core;

import core.Logger;
import data_provider.Constants;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import utils.Bot;

public class CoreTestIntegrationSD {

    protected WebDriver bot;
    Constants constants;

    @BeforeTest
    public void openBrowser() {
        bot = new Bot().getBot();
        bot.get(constants.configFileReader("URLSauceDemo"));
    }

    protected static void logStep(String step) {
        Logger.step(step);
    }

    @AfterTest
    public void close() {
        bot.quit();
    }

}

