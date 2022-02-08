package com.saucedemo.object_repository;

import org.openqa.selenium.By;

public class Home {
    public static final By ADD_TSHIRT_BLACK = By.name("add-to-cart-sauce-labs-bolt-t-shirt");
    public static final By ADD_TO_CART
        = By.cssSelector("button[class*='btn btn_primary btn_small btn_inventory']");
//    public static final By
    public static final By CART = By.className("shopping_cart_link");
}
