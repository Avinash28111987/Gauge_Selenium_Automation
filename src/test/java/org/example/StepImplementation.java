package org.example;


import com.thoughtworks.gauge.Step;
import driver.Driver;
import org.openqa.selenium.By;
import org.testng.Assert;


import java.util.Objects;
import java.util.concurrent.TimeUnit;

import static org.testng.Assert.assertTrue;

public class StepImplementation extends Driver

{
    @Step("Go to Automation Startup Page")
    public void gotoStartupPage()
    {
        driver.manage().window().maximize();
        driver.get("https://rahulshettyacademy.com/AutomationPractice/");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @Step("Validate the current URL and title")
    public void validateURLandTitle()
    {
        String baseURL = driver.getCurrentUrl();
        String ValidURL = "https://rahulshettyacademy.com/AutomationPractice/";
        Boolean verifyURL = Objects.equals(driver.getCurrentUrl(), ValidURL);
        assertTrue(verifyURL);
        String Valid_title = "Practice Page";
        Boolean verifyTitle = driver.getTitle().equals(Valid_title);
        assertTrue(verifyTitle);
    }

    @Step("Enter text in a textbox and get it")
    public void validateText()
    {
        String input_text = "Gauge Automation";
        driver.findElement(By.id("autocomplete")).sendKeys(input_text);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        String text = driver.findElement(By.id("autocomplete")).getAttribute("value");
        Assert.assertEquals(text, input_text, "text matched");
        System.out.println(text);
    }
}
