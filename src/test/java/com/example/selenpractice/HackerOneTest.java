package com.example.selenpractice;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

public class HackerOneTest {

    private WebDriver driver;
    private List<String> ips;

    @BeforeTest
    public void setup() {

        // Call getIPRange() to get a list of IP addresses
        ips = IPRange.getIPRange("10.0.0.0/8");

        // Set the system property to use ChromeDriver
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\khuba\\.cache\\selenium\\chromedriver_win32\\chromedriver.exe");

        // Initialize a new instance of ChromeDriver with the updated REMOTE_ADDR environment variable
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        driver = new ChromeDriver(options);

        driver.get("https://www.hackerone.com/");

        driver.manage().window().maximize();

        String pageTitle = driver.getTitle();
        Assert.assertNotNull(pageTitle);
        Assert.assertNotEquals(pageTitle, "");

        System.out.println(pageTitle);
        sleep.sleeperAgent3();

        /*for (String ip : ips) {
            System.setProperty("REMOTE_ADDR", ip);
            System.out.println("Setting REMOTE_ADDR to " + ip);

            // Navigate to a website

        }*/
    }

    @Test(priority = 1)
    public void Hack_Button() {
        WebElement loginbutton = driver.findElement(By.xpath("//*[@id=\"block-topbar\"]/ul/li[1]/a"));
        loginbutton.click();
        sleep.sleeperAgent2();
    }

    @Test(priority = 2)
    public void Hack_email() {
        WebElement login_textbox = driver.findElement(By.xpath("//*[@id=\"sign_in_email\"]"));
        login_textbox.sendKeys("[Enter email]");
    }

    @Test(priority = 3)
    public void Hack_password() {
        WebElement login_password = driver.findElement(By.xpath("//*[@id=\"sign_in_password\"]"));
        login_password.sendKeys("randomness");
    }

    @Test(priority = 4)
    public void Hack_signin_invalid() {
        WebElement signin_button = driver.findElement(By.xpath("//*[@id=\"main-content\"]/div/div/div/form/div/div/div/div[2]/div/div/div[4]/button"));
        signin_button.click();
        sleep.sleeperAgent5();
    }

    @Test(priority = 5)
    public void Invalid_message() {
        WebElement errormessage = driver.findElement(By.xpath("/html/body/div[1]/div"));
        Assert.assertTrue(errormessage.isDisplayed());
    }

    @Test(priority = 6)
    public void valid_login() {
        WebElement login_textbox = driver.findElement(By.xpath("//*[@id=\"sign_in_email\"]"));
        login_textbox.sendKeys("[Enter email]");

        WebElement password = driver.findElement(By.xpath("//*[@id=\"sign_in_password\"]"));
        password.sendKeys("[Enter Password]");

        WebElement signin_button = driver.findElement(By.xpath("//*[@id=\"main-content\"]/div/div/div/form/div/div/div/div[2]/div/div/div[4]/button"));
        signin_button.click();

        //Wait for the page to load
        Duration timeout = Duration.ofSeconds(10);
        WebDriverWait wait = new WebDriverWait(driver, timeout);
        wait.until(ExpectedConditions.urlContains("opportunities"));
        sleep.sleeperAgent5();
    }

    @Test(priority = 7)
    public void bounty_search() {
        WebElement searchbox = driver.findElement(By.xpath("//*[@id=\"main-content\"]/div[3]/div[2]/div[2]/div/form/div/div[1]/div/div/div/input"));
        searchbox.sendKeys("bug bounty");
        sleep.sleeperAgent2();

        searchbox.sendKeys(Keys.ENTER);
        sleep.sleeperAgent3();
    }

    @Test(priority = 8)
    public void bounty_result() {
        WebElement links = driver.findElement(By.xpath("//*[@id=\"main-content\"]/div[2]/div[2]/div[5]/div/div/div[1]/div[1]/div/article/div/div/div[3]/footer/a/span"));
        links.click();
        sleep.sleeperAgent3();
    }

    @Test(priority = 9)
    public void submit_report_button(){
        WebElement submit_button= driver.findElement(By.xpath("//*[@id=\"main-content\"]/div[1]/div[1]/div/div/div/div/div/div/div/div/div/div/div[1]/div/div[3]/div/div/a/button"));
        submit_button.click();
        sleep.sleeperAgent3();
    }

    @Test(priority = 10)
    public void asset_verify(){
        WebElement select_asset= driver.findElement(By.xpath("//*[@id=\"main-content\"]/div[2]/div[1]/div/div/div/div/form/div/div[2]/div[3]/div/div/div[2]/div/div[1]/ul/li[2]/div"));
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView({behavior: 'auto', block: 'center', inline: 'center'});", select_asset);
        select_asset.click();
        ScreenShot.takeScreenShot(driver, "asset_verify");
        sleep.sleeperAgent3();
    }

    @Test(priority = 11)
    public void weakness_verify(){
        WebElement select_weakness = driver.findElement(By.xpath("//*[@id=\"main-content\"]/div[2]/div[1]/div/div/div/div/form/div/div[3]/div[3]/div/div/div[2]/div/div[1]/ul/li[1]"));
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView({behavior: 'auto', block: 'center', inline: 'center'});", select_weakness);
        select_weakness.click();
        ScreenShot.takeScreenShot(driver, "weakness_verify");
        sleep.sleeperAgent3();
    }

    @Test(priority = 12)
    public void severity_verify(){
        WebElement button_container = driver.findElement(By.xpath("//*[@id=\"main-content\"]/div[2]/div[1]/div/div/div/div/form/div/div[4]/div[3]/div/div"));
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView({behavior: 'auto', block: 'center', inline: 'center'});", button_container);
        List<WebElement> buttons = button_container.findElements(By.tagName("button"));
        sleep.sleeperAgent1();

        for (WebElement button :buttons){
            button.click();
            ScreenShot.takeScreenShot(driver, "severity_verify");
            sleep.sleeperAgent05();
        }

    }

    @Test(priority = 13)
    public void proof_of_concept(){
        WebElement Title = driver.findElement(By.xpath("//*[@id=\"report_title\"]"));
        Title.sendKeys("Random Title");
        ScreenShot.takeScreenShot(driver, "proof_of_concept_Title");
        sleep.sleeperAgent1();

        WebElement Description = driver.findElement(By.xpath("//*[@id=\"report_vulnerability_information\"]"));
        Description.sendKeys(Keys.chord(Keys.CONTROL, "a"));
        sleep.sleeperAgent1();
        Description.sendKeys(Keys.DELETE);
        sleep.sleeperAgent1();
        Description.sendKeys("Anything the user wants to input for the description.");
        ScreenShot.takeScreenShot(driver, "proof_of_concept_Description");
        sleep.sleeperAgent1();

        WebElement Impact = driver.findElement(By.xpath("//*[@id=\"report_impact\"]"));
        Impact.sendKeys("How severe is the impact?");
        ScreenShot.takeScreenShot(driver, "proof_of_concept_Impact");
        sleep.sleeperAgent1();

    }

    @Test(priority = 14)
    public void discovery_details(){
        WebElement time_spent = driver.findElement(By.xpath("//*[@id=\"report_time_spent\"]"));

        time_spent.sendKeys("12");
        ScreenShot.takeScreenShot(driver, "discovery_details");
        sleep.sleeperAgent1();
    }

    @Test(priority = 15)
    public void dashboard(){
        WebElement dash_redirect= driver.findElement(By.xpath("//*[@id=\"vertical-navigation\"]/div[2]/div[3]/div[2]/a"));
        dash_redirect.click();
        sleep.sleeperAgent5();
    }


    @AfterTest
    public void teardown() {
        // Quit the driver and close all associated windows
        driver.quit();
    }
}
