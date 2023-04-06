package com.example.selenpractice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;


public class TestNGSelenPrac {
    private WebDriver driver;

    @BeforeTest
    public void setup() {
        // Set the system property to use ChromeDriver
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\khuba\\.cache\\selenium\\chromedriver_win32\\chromedriver.exe");

        // Initialize a new instance of ChromeDriver
        driver = new ChromeDriver();

        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");

        // Create a new instance of the ChromeDriver
        driver = new ChromeDriver(options);
    }

    @Test
    public void Webpage() {
        // Navigate to a website
        driver.get("http://127.0.0.1:5000");

        driver.manage().window().maximize();

        String pageTitle = driver.getTitle();
        Assert.assertNotNull(pageTitle);
        Assert.assertNotEquals(pageTitle, "");

        System.out.println(pageTitle);
    }

    @Test
    public void SkyView() {
        //call the webpage loader method
        Webpage();
        sleep.sleeperAgent3();

        // Find the search input field and enter the name of the star
        WebElement searchBox = driver.findElement(By.cssSelector("#target"));
        searchBox.sendKeys("Sirius");
        Assert.assertEquals(searchBox.getAttribute("value"), "Sirius");
        sleep.sleeperAgent3();

    }

    @Test
    public void SkyViewButton(){
        WebElement skySubmit = driver.findElement(By.cssSelector("#form-sky > button"));
        skySubmit.click();
        sleep.sleeperAgent3();

        WebElement zoomout = driver.findElement(By.className("zoomMinus"));
        zoomout.click();
        sleep.sleeperAgent5();
    }

    @Test
    public void RaDecSearch() {
        WebElement RaDec = driver.findElement(By.xpath("//*[@id=\"search_input\"]"));
        RaDec.sendKeys("92.0096, -30.5839");
        Assert.assertEquals(RaDec.getAttribute("value"), "92.0096, -30.5839");
        sleep.sleeperAgent3();

        WebElement radius = driver.findElement(By.xpath("//*[@id=\"radius\"]"));
        radius.sendKeys("178.6367");
        Assert.assertEquals(radius.getAttribute("value"), "178.6367");
        sleep.sleeperAgent3();
    }

    @Test
    public void RaDecButton(){
        WebElement searchButton = driver.findElement(By.cssSelector("body > div > div.query-container > div.search-input > div > form > input[type=submit]:nth-child(4)"));
        searchButton.click();
        sleep.sleeperAgent5();
    }

    @AfterTest
    public void teardown() {
        // Quit the driver and close all associated windows
        driver.quit();
    }
}

