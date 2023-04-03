package com.example.selenpractice;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TessTest {
    public static void main(String[] args) throws Exception {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\khuba\\.cache\\selenium\\chromedriver_win\\chromedriver.exe");

        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");

        // Create a new instance of the ChromeDriver
        WebDriver driver = new ChromeDriver(options);

        driver.get("http://127.0.0.1:5000");

        SkyView(driver);
        RaDecSearch(driver);
        ObjNameSearch(driver);
        TicIDSearch(driver);
        CSV_upload(driver);
    }

    public static void SkyView(WebDriver driver) {
        // find the search input field and enter the name of the star
        WebElement searchInput = driver.findElement(By.id("target"));
        searchInput.sendKeys("Sirius");
        sleep.sleeperAgent3();

        WebElement skySubmit = driver.findElement(By.cssSelector("#form-sky > button"));
        skySubmit.click();

        WebElement zoomout = driver.findElement(By.className("zoomMinus"));
        zoomout.click();
        sleep.sleeperAgent3();
    }

    public static void RaDecSearch(WebDriver driver) {
        WebElement RaDec = driver.findElement(By.id("search_input"));
        RaDec.sendKeys("92.0096, -30.5839");
        sleep.sleeperAgent1();

        WebElement radius = driver.findElement(By.xpath("//*[@id=\"radius\"]"));
        radius.sendKeys("178.6367");
        sleep.sleeperAgent2();

        WebElement searchButton = driver.findElement(By.xpath("/html/body/div/div[2]/div[1]/div[1]/form/input[3]"));
        searchButton.click();
        sleep.sleeperAgent5();

        //wait time for page to reload
        Duration timeout = Duration.ofSeconds(10);
        WebDriverWait wait = new WebDriverWait(driver, timeout);
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div/div[3]")));
    }

    public static void ObjNameSearch(WebDriver driver) {
        WebElement RaDec = driver.findElement(By.id("search_input"));
        RaDec.sendKeys("Sirius");
        sleep.sleeperAgent1();

        WebElement radius = driver.findElement(By.xpath("//*[@id=\"radius\"]"));
        radius.sendKeys("40");
        sleep.sleeperAgent2();

        WebElement searchButton = driver.findElement(By.xpath("/html/body/div/div[2]/div[1]/div[1]/form/input[3]"));
        searchButton.click();
        sleep.sleeperAgent5();

        //wait time for page to reload
        Duration timeout = Duration.ofSeconds(10);
        WebDriverWait wait = new WebDriverWait(driver, timeout);
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div/div[3]")));
    }

    public static void TicIDSearch(WebDriver driver) {
        WebElement RaDec = driver.findElement(By.id("search_input"));
        RaDec.sendKeys("50559830");
        sleep.sleeperAgent1();

        WebElement radius = driver.findElement(By.xpath("//*[@id=\"radius\"]"));
        radius.sendKeys("178.6367");
        sleep.sleeperAgent2();

        WebElement searchButton = driver.findElement(By.xpath("/html/body/div/div[2]/div[1]/div[1]/form/input[3]"));
        searchButton.click();
        sleep.sleeperAgent5();

        //wait time for page to reload
        Duration timeout = Duration.ofSeconds(10);
        WebDriverWait wait = new WebDriverWait(driver, timeout);
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div/div[3]")));
    }

    public static void CSV_upload(WebDriver driver){
        WebElement fileinput = driver.findElement(By.name("csv_file"));
        String filePath = "C:\\Users\\khuba\\Downloads\\data2.csv";
        fileinput.sendKeys(filePath);

        WebElement CSVradius = driver.findElement(By.xpath("/html/body/div/div[2]/form/div/div/input[2]"));
        CSVradius.sendKeys("20");
        sleep.sleeperAgent3();

        WebElement CSVsubmit = driver.findElement(By.xpath("/html/body/div/div[2]/form/div/div/input[3]"));
        CSVsubmit.click();
        sleep.sleeperAgent3();

    }

}
