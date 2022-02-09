package com.saucedemo.page_functions;

import com.saucedemo.object_repository.Home;
import com.saucedemo.object_repository.Login;
import io.qameta.allure.Step;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import utils.CoreActions;

import static org.junit.Assert.assertTrue;

public class LoginImpl extends CoreActions {
    public LoginImpl(WebDriver bot) {
        super(bot);
    }

    String loginUsernamesString;
    String password;
    String[] loginUsernamesArray;
    String[] passwordArray;

    @Step("Verify that we are on the correct website.")

    public boolean validateWebsite() {
        return bot.getCurrentUrl().contains("https://www.saucedemo.com/");
    }

    @Step("Get tests credentials.")
    public void getCredentials() {
        waitForVisibility(Login.USERNAME_LIST);
        loginUsernamesString = getText(Login.USERNAME_LIST);
        loginUsernamesArray = loginUsernamesString.split(System.lineSeparator());

        waitForVisibility(Login.PASSWORD);
        password = getText(Login.PASSWORD);
        passwordArray = password.split(System.lineSeparator());
    }

    @Step("Login.")
    public HomeImpl login() {
        for(int i = 0; i < loginUsernamesArray.length; i++) {
            waitForVisibility(Login.USERNAME_TXTBOX);
            bot.findElement(Login.USERNAME_TXTBOX).clear();
            enterText(Login.USERNAME_TXTBOX, loginUsernamesArray[1]);

            waitForVisibility(Login.PASSWORD_TXTBOX);
            bot.findElement(Login.PASSWORD_TXTBOX).clear();
            enterText(Login.PASSWORD_TXTBOX, passwordArray[1]);

            click(Login.LOGIN_BUTTON);

            if(bot.getCurrentUrl().equals("https://www.saucedemo.com/inventory.html")) {
                return new HomeImpl(bot);
            } else {
                continue;
            }
        }

        return null;
    }
}
