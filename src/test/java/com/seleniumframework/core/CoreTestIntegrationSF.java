package com.seleniumframework.core;

import com.seleniumframework.object_repository.Index;
import com.seleniumframework.page_functions.ContactImpl;
import com.seleniumframework.page_functions.IndexImpl;
import core.Logger;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.Bot;
import data_provider.Constants;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

public class CoreTestIntegrationSF {

    protected WebDriver bot;
    protected WebDriverWait wait;
    Constants constants;

    protected ContactImpl contact;
    protected IndexImpl index;

    @BeforeTest
    public void openBrowser() {
        bot = new Bot().startBot();
        bot.get(constants.configFileReader("URLSeleniumFramework"));

        index = new IndexImpl(bot);

        wait = new WebDriverWait(bot, 7);
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(Index.CONTACT_PAGE_BUTTON));
    }

    protected static void logStep(String step) {
        Logger.step(step);
    }

    @AfterTest
    public void close() {
        bot.quit();
    }

}

