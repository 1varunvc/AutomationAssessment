package core;

import com.testframework.Bot;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class CoreTestIntegration {

    protected WebDriver bot;
    protected static final String URL = "http://www.seleniumframework.com/";

    @BeforeClass
    public void openBrowser() {
        bot = new Bot().getBot();
        bot.get(URL);
    }

    protected static void logStep(String step) {
        Logger.step(step);
    }

    @AfterClass
    public void close() {
        bot.quit();
    }

}