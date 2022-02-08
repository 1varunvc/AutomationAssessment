package com.seleniumframework.core;

import core.Logger;
import utils.Bot;
import data_provider.Constants;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

public class CoreTestIntegrationSF {

    protected WebDriver bot;
    Constants constants;

    @BeforeTest
    public void openBrowser() {
        bot = new Bot().getBot();
        bot.get(constants.configFileReader("URLSeleniumFramework"));
    }

    protected static void logStep(String step) {
        Logger.step(step);
    }

    @AfterTest
    public void close() {
        bot.quit();
    }

}

