package com.seleniumframework.page_functions;

import com.seleniumframework.object_repository.Contact;
import org.testng.SkipException;
import org.testng.asserts.SoftAssert;
import utils.CoreActions;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;

public class ContactImpl extends CoreActions {

    public ContactImpl(WebDriver bot) {
        super(bot);
        if (!bot.findElement(Contact.NAME_TXTBOX).isDisplayed()) {
            throw new SkipException("The 'contact' page did not load.");
        }
    }

    SoftAssert softAssert = new SoftAssert();

    @Step("Input name.")
    public void inputName(final String inputString) {
        waitForVisibility(Contact.NAME_TXTBOX);
        enterText(Contact.NAME_TXTBOX, inputString);
    }

    @Step("Input e-mail address.")
    public void inputEmail(final String inputString) {
        waitForVisibility(Contact.EMAIL_TXTBOX);
        enterText(Contact.EMAIL_TXTBOX, inputString);
    }

    @Step("Input telephone number.")
    public void inputTelephone(final String inputString) {
        waitForVisibility(Contact.TELEPHONE_TXTBOX);
        enterText(Contact.TELEPHONE_TXTBOX, inputString);
    }

    @Step("Type the message.")
    public void inputMessage(final String inputString) {
        waitForVisibility(Contact.MESSAGE_TXTBOX);
        enterText(Contact.MESSAGE_TXTBOX, inputString);
    }

    @Step("Submit message.")
    public void submit() {
        waitForVisibility(Contact.SUBMIT_BTN);
        click(Contact.SUBMIT_BTN);
    }

    @Step("Validate if the message has been sent.")
    public void verifySubmissionMessage() {
        waitForVisibility(Contact.MESSAGE_SENT);
        softAssert.assertTrue(bot.findElement(Contact.MESSAGE_SENT).isDisplayed());
    }

    @Step("Validate for input of invalid email address.")
    public void validateInvalidEmail(){
        waitForVisibility(Contact.MESSAGE_INVALID_EMAIL);
        softAssert.assertTrue(bot.findElement(Contact.MESSAGE_INVALID_EMAIL).isDisplayed());
    }

 /*
//    Other way to do it:
    public boolean validateInvalidEmail(){
        waitForVisibility(Contact.MESSAGE_INVALID_EMAIL);
        return bot.findElement(Contact.MESSAGE_INVALID_EMAIL).isDisplayed();
    }

 */
}
