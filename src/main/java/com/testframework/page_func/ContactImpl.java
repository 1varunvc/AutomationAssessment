package com.testframework.page_func;

import com.testframework.object_repo.Contact;
import com.testframework.object_repo.Index;
import com.testframework.utils.CoreActions;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;

public class ContactImpl extends CoreActions {

    public ContactImpl(WebDriver bot) {
        super(bot);
    }

    @Step("Validate if the user has arrived on the correct website.")
    public boolean validateWebsite() {
        return bot.getCurrentUrl().contains("http://www.seleniumframework.com/");
    }

    @Step("Navigate to 'Contact' page.")
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
    public boolean verifySubmissionMessage() {
        waitForVisibility(Contact.MESSAGE_SENT);
        return bot.findElement(Contact.MESSAGE_SENT).isDisplayed();
    }

    @Step("Validate for input of invalid email address.")
    public boolean validateInvalidEmail(){
        waitForVisibility(Contact.MESSAGE_INVALID_EMAIL);
        return bot.findElement(Contact.MESSAGE_INVALID_EMAIL).isDisplayed();
    }

    @Step("Wait for a few seconds.")
    public void waitFor2s() {
        sleep(2);
    }

    @Step("Close browser tab.")
    public void closeBrowser() {
        bot.close();
    }

    @Step("Navigate to test website.")
    public void openTestWebsite() {
        String websiteURL = "http://www.seleniumframework.com";
        bot.get(websiteURL);
    }
}
