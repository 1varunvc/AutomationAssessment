package com.saucedemo.object_repository;

import org.openqa.selenium.By;

public class Home {
    public static final By ADD_TO_CARTS = By.cssSelector("button[class*='btn btn_primary btn_small btn_inventory']");
    public static final By ARTICLES = By.className("inventory_item_name");
    public static final By PRICES = By.className("inventory_item_price");
    public static final By CART = By.className("shopping_cart_link");
}
