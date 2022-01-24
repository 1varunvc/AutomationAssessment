package com.testframework.actions;

import com.testframework.pages.Contact;
import com.testframework.pages.Index;
import io.qameta.allure.Step;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;

public class ContactImpl extends CoreActions {

    public ContactImpl(WebDriver bot) {
        super(bot);
    }

    @Step("Validate if the user has arrived on the correct website.")
    public boolean validateWebsite() {
        return bot.getCurrentUrl().contains("http://www.seleniumframework.com/");
    }

    @Step("Navigate to 'Contact' pagr.")
    public void goToContactPage() {
        waitForVisibility(Index.CONTACT_PAGE_BUTTON);
        click(Index.CONTACT_PAGE_BUTTON);
    }

    @Step("Input name.")
    public void inputName(final String inputString) {
        waitForVisibility(Contact.INPUT_NAME);
        enterText(Contact.INPUT_NAME, inputString);
    }

    @Step("Input e-mail address.")
    public void inputEmail(final String inputString) {
        waitForVisibility(Contact.INPUT_EMAIL);
        enterText(Contact.INPUT_EMAIL, inputString);
    }

    @Step("Input telephone number.")
    public void inputTelephone(final String inputString) {
        waitForVisibility(Contact.INPUT_TELEPHONE);
        enterText(Contact.INPUT_TELEPHONE, inputString);
    }

    @Step("Type the message.")
    public void inputMessage(final String inputString) {
        waitForVisibility(Contact.INPUT_MESSAGE);
        enterText(Contact.INPUT_MESSAGE, inputString);
    }

    @Step("Submit message.")
    public void submit() {
        waitForVisibility(Contact.SUBMIT);
        click(Contact.SUBMIT);
    }

    @Step("Validate if the message has been sent.")
    public void verifySubmissionMessage() {
        Assert.assertEquals("Feedback has been sent to the administrator", "There was an error sending feedback to the administrator.");
    }

    @Step("Validate for input of invalid email address.")
    public boolean validateInvalidEmail(){
        return Contact.MESSAGE_INVALID_EMAIL.equals("* Invalid email address");
    }

    @Step("Wait for a few seconds.")
    public void waitFor2s() {
        sleep(2);
    }
}
