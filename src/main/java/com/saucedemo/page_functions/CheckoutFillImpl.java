package com.saucedemo.page_functions;

import com.saucedemo.object_repository.CheckoutFill;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import utils.CoreActions;

public class CheckoutFillImpl extends CoreActions {
    public CheckoutFillImpl(WebDriver bot) {super(bot);}

    @Step("Fill checkout form and click continue.")
    public void fillCheckoutDetails() {
        waitForVisibility(CheckoutFill.FIRSTNAME_TXTBOX);
        enterText(CheckoutFill.FIRSTNAME_TXTBOX, "First");

        waitForVisibility(CheckoutFill.LASTNAME_TXTBOX);
        enterText(CheckoutFill.LASTNAME_TXTBOX, "Last");

        waitForVisibility(CheckoutFill.PINCODE_TXTBOX);
        enterText(CheckoutFill.PINCODE_TXTBOX, "548995");

        waitForVisibility(CheckoutFill.CHECKOUT_CONTINUE);
        click(CheckoutFill.CHECKOUT_CONTINUE);
    }
}
