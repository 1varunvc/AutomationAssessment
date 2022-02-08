package com.seleniumframework.object_repository;

import org.openqa.selenium.By;

public class Contact {
    public static final By NAME_TXTBOX = By.name("name");
    public static final By EMAIL_TXTBOX = By.name("email");
    public static final By TELEPHONE_TXTBOX = By.name("telephone");
    public static final By MESSAGE_TXTBOX = By.name("message");
    public static final By SUBMIT_BTN = By.linkText("Send message");
    public static final By MESSAGE_SENT = By.xpath("//div[text()='Feedback has been sent to the administrator']");
    public static final By MESSAGE_INVALID_EMAIL = By.xpath("//div[text()='* Invalid email address']");
}
