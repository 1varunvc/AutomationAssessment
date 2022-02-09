package com.saucedemo.object_repository;

import org.openqa.selenium.By;

public class Cart {

    public static final By CART_ARTICLE_NAME = By.className("inventory_item_name");
    public static final By CART_ARTICLE_PRICE = By.className("inventory_item_price");
    public static final By CHECKOUT = By.id("checkout");

//    The following locators would be more ideal for scalability, but are hit or miss.
//    public static final By CART_ARTICLE_NAME = By.cssSelector("a[id=item_1_title_link]:first-child");
//    public static final By CART_ARTICLE_PRICE = By.cssSelector("div[class=inventory_item_price]");

}
