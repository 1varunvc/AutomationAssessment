package com.saucedemo.page_functions;

import com.saucedemo.object_repository.CheckoutOverview;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import utils.CoreActions;

public class CheckoutOverviewImpl extends CoreActions {
    public CheckoutOverviewImpl(WebDriver bot) { super(bot); }

    @Step("Click 'finish' and checkout.")
    public CheckoutCompleteImpl clickFinish(){
        waitForVisibility(CheckoutOverview.CHECKOUT_FINISH);
        click(CheckoutOverview.CHECKOUT_FINISH);

        return new CheckoutCompleteImpl(bot);
    }
}
