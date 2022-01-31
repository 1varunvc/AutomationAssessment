package com.testframework.object_repo;

import org.openqa.selenium.By;

public class Contact {
    public static final By INPUT_NAME = By.name("name");
    public static final By INPUT_EMAIL = By.name("email");
    public static final By INPUT_TELEPHONE = By.name("telephone");
    public static final By INPUT_MESSAGE = By.name("message");
    public static final By SUBMIT = By.linkText("Send message");
    public static final By MESSAGE_SENT = By.xpath("//div[text()='Feedback has been sent to the administrator']");
    public static final By MESSAGE_INVALID_EMAIL = By.xpath("//div[text()='* Invalid email address']");
}
