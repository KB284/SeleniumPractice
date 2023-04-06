package com.example.selenpractice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class ExampleTestng {
    private WebDriver driver;

    @BeforeTest
    public void setup() {
        // Set the system property to use ChromeDriver
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\khuba\\.cache\\selenium\\chromedriver_win32\\chromedriver.exe");

        // Initialize a new instance of ChromeDriver
        driver = new ChromeDriver();
    }

    @Test
    public void testGoogleSearchTextbox() {
        // Navigate to Google
        driver.get("https://www.google.com");

        // Find the search text box and enter a search term
        WebElement searchBox = driver.findElement(By.name("q"));
        searchBox.sendKeys("TestNG");

        // Verify that the search text box contains the entered search term
        Assert.assertEquals(searchBox.getAttribute("value"), "TestNG");
    }

    @Test
    public void testGoogleSearchButton() {
        // Navigate to Google
        driver.get("https://www.google.com");

        // Find the search text box and enter a search term
        WebElement searchBox = driver.findElement(By.name("q"));
        searchBox.sendKeys("TestNG");

        // Find the search button and verify that it is enabled
        WebElement searchButton = driver.findElement(By.name("btnK"));
        Assert.assertTrue(searchButton.isEnabled());
    }

    @AfterTest
    public void teardown() {
        // Quit the driver and close all associated windows
        driver.quit();
    }
}

