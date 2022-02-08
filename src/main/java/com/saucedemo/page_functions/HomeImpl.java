package com.saucedemo.page_functions;

import com.saucedemo.object_repository.Home;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utils.CoreActions;

import java.util.List;
import java.util.Random;

public class HomeImpl extends CoreActions {
    public HomeImpl(WebDriver bot) {
        super(bot);
    }

    @Step("Add item to cart.")
    public void addToCart() {
        waitForVisibility(Home.ADD_TO_CART);

//        https://stackoverflow.com/a/34895458/14597561
        List<WebElement> addToCartList = bot.findElements(Home.ADD_TO_CART);

//        https://stackoverflow.com/a/5887745/14597561
        Random random = new Random();
        int randomN = random.nextInt(6);

        click(addToCartList.get(randomN));

//        https://stackoverflow.com/a/30232809/14597561
//        The following works as well.
//        addToCartList.get(randomN).click();

    }

    @Step("Go to cart.")
    public void goToCart() {
        click(Home.CART);
    }

}
