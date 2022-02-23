package com.saucedemo.page_functions;

import com.saucedemo.object_repository.CheckoutOverview;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.testng.SkipException;
import utils.CoreActions;

public class CheckoutOverviewImpl extends CoreActions {
    public CheckoutOverviewImpl(WebDriver bot) {
        super(bot);

        if(!bot.findElement(CheckoutOverview.CHECKOUT_FINISH).isDisplayed()) {
            throw new SkipException("The webpage that gives checkout overview did not get loaded.");
        }
    }

    @Step("Click 'finish' and checkout.")
    public CheckoutCompleteImpl clickFinish(){
        waitForVisibility(CheckoutOverview.CHECKOUT_FINISH);
        click(CheckoutOverview.CHECKOUT_FINISH);

        return new CheckoutCompleteImpl(bot);
    }
}
