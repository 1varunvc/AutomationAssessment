package contact;

import com.testframework.page_func.ContactImpl;
import core.CoreTestIntegration;
import core.Listener;
import io.qameta.allure.*;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Test
@Epic("EPIC 1")
@Listeners(Listener.class)
public class ContactTests extends CoreTestIntegration {

    ContactImpl contact;

    @Test
    @Description("Create 'impl' object before class.")
    public void initImpl() {
        contact = new ContactImpl(bot);
    }

    @Test(dependsOnMethods = "initImpl")
    @Description("Tests that the user can submit a message to www.seleniumframework.com via their 'contact' page.")
    @Severity(SeverityLevel.NORMAL)
    @Story("STORY 1")
    @Feature("FEATURE 1")
    @Owner("Varun Chawla")
    public void test_to_submit_message_positive_email() {

        logStep("Validate we're on the correct website.");
        Assert.assertTrue(contact.validateWebsite(), "We are on the correct website.");

        logStep("Navigate to 'contact' page.");
        contact.goToContactPage();

        logStep("Input name.");
        contact.inputName("Varun Chawla");

        logStep("Input e-mail address.");
        contact.inputEmail("varun.chawla@example.com");

        logStep("Input telephone number.");
        contact.inputTelephone("8435673845");

        logStep("Type the message.");
        contact.inputMessage("This is a test message.");

        logStep("Submit form.");
        contact.submit();

        logStep("Form submission message verification.");
        contact.verifySubmissionMessage();

        logStep("Wait for 2 seconds.");
        contact.waitFor2s();

        logStep("Quit browser");
        contact.closeBrowser();
    }

    @Test(dependsOnMethods = "initImpl")
    @Description("Tests that the user cannot submit a message with 'invalid email input', to www.seleniumframework.com via their 'contact' page.")
    @Severity(SeverityLevel.NORMAL)
    @Story("STORY 1")
    @Feature("FEATURE 1")
    @Owner("Varun Chawla")
    public void test_to_submit_message_negative_email() {

        logStep("Open test website.");
        contact.openTestWebsite();

        logStep("Validate we're on the correct website.");
        Assert.assertTrue(contact.validateWebsite(), "We are on the correct website.");

        logStep("Navigate to 'contact' page.");
        contact.goToContactPage();

        logStep("Input name.");
        contact.inputName("Varun Chawla");

        logStep("Input e-mail address.");
        contact.inputEmail("varun.chawla");

        logStep("Input telephone number.");
        contact.inputTelephone("8435673845");

        logStep("Type the message.");
        contact.inputMessage("This is a test message.");

        logStep("Submit form.");
        contact.submit();

        logStep("Form submission message verification.");
        contact.validateInvalidEmail();

        logStep("Wait for 2 seconds.");
        contact.waitFor2s();
    }

}
