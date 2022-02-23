package com.seleniumframework.contact;

import com.seleniumframework.core.CoreTestIntegrationSF;
import core.Listener;
import io.qameta.allure.*;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Test
@Epic("EPIC 1")
@Listeners(Listener.class)
public class ContactTests extends CoreTestIntegrationSF {

    @Test (priority = 1)
    @Description("Verify that the user can submit a message to www.seleniumframework.com via their 'contact' page.")
    @Severity(SeverityLevel.NORMAL)
    @Story("STORY 1")
    @Feature("FEATURE 1")
    @Owner("Varun Chawla")
    public void test_to_submit_message_positive_email() {

        logStep("Navigate to 'contact' page.");
        contact = index.goToContactPage();

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

        logStep("Read the overall status of all the soft asserts.");
        contact.assertAll();
    }

    @Test (priority = 2)
    @Description("Verify that the user cannot submit a message with 'invalid email input', to www.seleniumframework.com via their 'contact' page.")
    @Severity(SeverityLevel.NORMAL)
    @Story("STORY 1")
    @Feature("FEATURE 1")
    @Owner("Varun Chawla")
    public void test_to_submit_message_negative_email() {

        logStep("Navigate to 'contact' page.");
        contact = index.goToContactPage();

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

        logStep("Read the overall status of all the soft asserts.");
        contact.assertAll();
    }
}


