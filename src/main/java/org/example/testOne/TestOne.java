package main.java.org.example.testOne;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestOne {
    public static void main (String[] args) {

//        System.setProperty("webdriver.chrome.driver","G:\\My Drive\\Workspaces\\eclipse-workspace\\qa-automation\\qa-automation-1\\resources\\chromedriver.exe");

        WebDriver driver = new ChromeDriver();

        driver.get("https://open.spotify.com/");

    }
}
