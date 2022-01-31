// This class is obsolete.

package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


public class TestAutomation {
    public static void main (String[] args) {


        WebDriver driver = new ChromeDriver();

        // 1. Open application.
        try {
            driver.get("http://automationpractice.com/");
            System.out.println("1. Application opened.");
        } catch (TimeoutException ex) {
//            System.out.println(e);
            ex.printStackTrace();
        }

        // 2. Verify we're on the correct website.
        String currentURL = driver.getCurrentUrl();
        if (currentURL.equals("http://automationpractice.com/index.php")) {
            System.out.println("2. We are on the correct website.");
        }

        // 3. Click 'Contact Us'.
        driver.findElement(By.linkText("Contact us")).click();
        System.out.println("3. Clicked on 'Contact us.");

        // 4. Select 'Customer Service' from subject heading.
        Select subjectHeading = new Select(driver.findElement(By.id("id_contact")));
        subjectHeading.selectByVisibleText("Customer service");
        System.out.println("4. Selected 'Customer Service' from subject heading.");

        // 5. Enter valid email address, write a message and send it.
        driver.findElement(By.id("email")).sendKeys("varun.chawla@example.com");
        driver.findElement(By.id("message")).sendKeys("This is a test message.");
        driver.findElement(By.id("submitMessage")).click();
        System.out.println("5. Entered valid email address, written a message and sent it.");

        // 6. Verify success message.
        try {
            driver.findElement(By.xpath("//p[text()='Your message has been successfully sent to our team.']"));
            System.out.println("6. Message sent successfully.");
        } catch(NoSuchElementException ex) {
            ex.printStackTrace();
//            System.out.println(e);
        }

        driver.quit();
    }
}
