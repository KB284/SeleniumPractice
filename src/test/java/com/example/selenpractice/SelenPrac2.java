package com.example.selenpractice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.concurrent.TimeUnit;

public class SelenPrac2 {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\khuba\\.cache\\selenium\\chromedriver_win\\chromedriver.exe");

        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");

        // Create a new instance of the ChromeDriver
        WebDriver driver = new ChromeDriver(options);

        driver.get("https://www.gamestop.com/");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        WebElement searchbar = driver.findElement(By.name("q"));
        searchbar.sendKeys("Mario Kart");


        WebElement searchbutton = driver.findElement(By.xpath("//button[@type= 'submit']"));
        searchbutton.click();


        WebElement dropdown = driver.findElement(By.id("sortby-dropdown"));
        dropdown.click();

        ScreenShot.takeScreenShot(driver);

        sleep.sleeperAgent();

        driver.close();
    }
}
