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


public class TessTest {
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

        // Navigate to a website
        driver.get("http://127.0.0.1:5000");

        driver.manage().window().maximize();

        String pageTitle = driver.getTitle();
        Assert.assertNotNull(pageTitle);
        Assert.assertNotEquals(pageTitle, "");

        System.out.println(pageTitle);

    }

    @Test(priority = 1)
    public void SkyView() {
        //call the webpage loader method
        sleep.sleeperAgent3();

        // Find the search input field and enter the name of the star
        WebElement searchBox = driver.findElement(By.cssSelector("#target"));
        searchBox.sendKeys("Sirius");
        Assert.assertEquals(searchBox.getAttribute("value"), "Sirius");
        sleep.sleeperAgent3();

    }

    @Test(priority = 2)
    public void SkyViewButton(){
        WebElement skySubmit = driver.findElement(By.cssSelector("#form-sky > button"));
        skySubmit.click();
        sleep.sleeperAgent3();

        WebElement zoomout = driver.findElement(By.className("zoomMinus"));
        zoomout.click();
        sleep.sleeperAgent5();
    }

    @Test(priority = 3)
    public void RaDecSearch() {
        WebElement RaDec = driver.findElement(By.xpath("//*[@id=\"search_input\"]"));
        RaDec.sendKeys("92.0096, -30.5839");
        Assert.assertEquals(RaDec.getAttribute("value"), "92.0096, -30.5839");
        sleep.sleeperAgent3();

        WebElement radius = driver.findElement(By.cssSelector("#radius"));
        radius.sendKeys("1");
        Assert.assertEquals(radius.getAttribute("value"), "1");
        sleep.sleeperAgent3();
    }

    @Test(priority = 4)
    public void RaDecButton(){
        WebElement searchButton = driver.findElement(By.cssSelector("body > div > div.query-container > div.search-input > div > form > input[type=submit]:nth-child(4)"));
        searchButton.click();
        sleep.sleeperAgent5();
    }

    @Test(priority = 5)
    public void ObjNameSearch(){
        WebElement ObjName = driver.findElement(By.xpath("//*[@id=\"search_input\"]"));
        ObjName.sendKeys("Sirius");
        Assert.assertEquals(ObjName.getAttribute("value"), "Sirius");
        sleep.sleeperAgent5();

        WebElement radius = driver.findElement(By.cssSelector("#radius"));
        radius.sendKeys("1.5");
        Assert.assertEquals(radius.getAttribute("value"), "1.5");
        sleep.sleeperAgent5();

        WebElement searchButton = driver.findElement(By.cssSelector("body > div > div.query-container > div.search-input > div > form > input[type=submit]:nth-child(4)"));
        searchButton.click();
        sleep.sleeperAgent5();
    }

    /*@Test(priority = 6)
    public void TicIDSearch() {
        WebElement TicID = driver.findElement(By.xpath("//*[@id=\"search_input\"]"));
        TicID.sendKeys("50559830");
        Assert.assertEquals(TicID.getAttribute("value"), "50559830");
        sleep.sleeperAgent3();

        WebElement radius = driver.findElement(By.xpath("//*[@id=\"radius\"]"));
        radius.sendKeys("178.6367");
        Assert.assertEquals(radius.getAttribute("value"), "178.6367");
        sleep.sleeperAgent3();

        WebElement searchButton = driver.findElement(By.cssSelector("body > div > div.query-container > div.search-input > div > form > input[type=submit]:nth-child(4)"));
        searchButton.click();
        sleep.sleeperAgent5();
    }*/

    @Test(priority = 6)
    public void CSV_upload() {
        WebElement fileinput = driver.findElement(By.xpath("/html/body/div/div[2]/form/div/div/div[1]/input"));
        String filePath = "C:\\Users\\khuba\\Downloads\\data2.csv";
        fileinput.sendKeys(filePath);
    }

    @Test(priority = 7)
    public void CSV_Radius_Textbox(){
        WebElement CSVradius = driver.findElement(By.xpath("/html/body/div/div[2]/form/div/div/div[2]/input[1]"));
        CSVradius.sendKeys("0.5");
        sleep.sleeperAgent3();
    }

    @Test(priority = 8)
    public void CSV_Submit_Button(){
        WebElement CSVsubmit = driver.findElement(By.xpath("/html/body/div/div[2]/form/div/div/div[2]/input[2]"));
        CSVsubmit.click();
        sleep.sleeperAgent3();
    }



    @AfterTest
    public void teardown() {
        // Quit the driver and close all associated windows
        driver.quit();
    }
}

