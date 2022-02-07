package utils;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class CoreActions {

    protected final WebDriver bot;
    protected final WebDriverWait waiter;

    protected CoreActions(WebDriver bot) {
        this.bot  = bot;
        this.waiter = new WebDriverWait(bot, Duration.ofSeconds(10));
    }

    protected boolean waitForVisibility(By element) {
        boolean isVisible = true;
        try {
            waiter.until(ExpectedConditions.visibilityOfElementLocated(element));
        } catch (TimeoutException te) {
            isVisible = false;
        }
        return isVisible;
    }

    protected void click(By element) {
        bot.findElement(element).click();
    }

    protected void click(WebElement element) {
        element.click();
    }

    protected void enterText(By element, String text) {
        bot.findElement(element).sendKeys(text);
    }

    public static void sleep(double sec) {
        try {
            Thread.sleep((long) (sec * 1000));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
