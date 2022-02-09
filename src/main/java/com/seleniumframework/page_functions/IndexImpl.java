package com.seleniumframework.page_functions;

import com.seleniumframework.object_repository.Index;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import utils.CoreActions;

public class IndexImpl extends CoreActions {
    public IndexImpl(WebDriver bot) {
        super(bot);
    }

    @Step("Navigate to 'Contact' page.")
    public ContactImpl goToContactPage() {
        waitForVisibility(Index.CONTACT_PAGE_BUTTON);
        click(Index.CONTACT_PAGE_BUTTON);
        return new ContactImpl(bot);
    }
}
