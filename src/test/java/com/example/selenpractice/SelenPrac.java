package com.example.selenpractice;

import java.lang.Thread;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import java.util.concurrent.TimeUnit;
import java.util.List;

public class SelenPrac {
    public static void main(String[] args) {
        // Set the path to the ChromeDriver executable
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\khuba\\.cache\\selenium\\chromedriver_win\\chromedriver.exe");

        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");

        // Create a new instance of the ChromeDriver
        WebDriver driver = new ChromeDriver(options);
//----------------------------------------------------------------------------------------
//add/delete web element

        // Navigate to the URL
        driver.get("http://www.tutorialsninja.com/demo/");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        // Find the "Phones & PDAs" category and click on it
        WebElement phonesAndPDAsLink = driver.findElement(By.xpath("//a[contains(text(), 'Phones & PDAs')]"));
        phonesAndPDAsLink.click();

        // Find the first item and click on its "Add to Cart" button
        WebElement firstItem = driver.findElement(By.xpath("//div[@id='content']//div[1]//div[2]//button[1]"));
        firstItem.click();

        // Wait for the "success" message to appear
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        // Find the "Cart" button and click on it
        WebElement cartButton = driver.findElement(By.cssSelector("button span#cart-total"));
        cartButton.click();

        // Wait for the "Checkout" button to appear
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        // Find the "Remove" button and click on it
        WebElement removeButton = driver.findElement(By.xpath("//button[@title='Remove']"));
        removeButton.click();

        // Wait for the "success" message to appear
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
//------------------------------------------------------------------------------------------------------

//enter text in textbox and search
        // Find the search box and enter text
        WebElement searchBox = driver.findElement(By.name("search"));
        searchBox.sendKeys("iPhone");

        // Click on the search button
        WebElement searchButton = driver.findElement(By.cssSelector("button.btn.btn-default.btn-lg"));
        searchButton.click();

        // Wait for the search results to load
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
//---------------------------------------------------------------------------------------------

//checkboxes and radio buttons
        // Navigate to the URL
        driver.get("https://demo.automationtesting.in/Register.html");

        // Find the radio button for "Male" and select it
        WebElement radioMale = driver.findElement(By.cssSelector("input[value='Male']"));
        radioMale.click();

        // Wait for a few seconds
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        // Find the checkbox for "Cricket" and select it
        WebElement checkboxCricket = driver.findElement(By.xpath("//input[@type='checkbox' and @value='Cricket']"));
        checkboxCricket.click();

        // Wait for a few seconds
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
//-----------------------------------------------------------------------------------------------
//Access drop down menu

        // Find the "Skills" drop down and click on it.
        WebElement SkillsDropdown = driver.findElement(By.id("Skills"));
        SkillsDropdown.click();
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        //Select the "Android" option from the dropdown.
        WebElement androidOption = driver.findElement(By.xpath("//option[contains(text(), 'Android')]"));
        androidOption.click();
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

//--------------------------------------------------------------------------------------------
//Drag and Drop

        driver.get("https://demoqa.com/droppable/");
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        // find source element
        WebElement sourceElement = driver.findElement(By.id("draggable"));

        // find target element
        WebElement targetElement = driver.findElement(By.id("droppable"));

        // create Actions object
        Actions actions = new Actions(driver);

        // perform drag and drop action
        actions.dragAndDrop(sourceElement, targetElement).build().perform();

        try{
            Thread.sleep(3000);
        } catch (InterruptedException e){
            throw new RuntimeException(e);
        }

//--------------------------------------------------------------------------------------------
//get title and current url of the website

        // Get the title and current URL
        driver.get("https://phptravels.com/demo/");

        String title = driver.getTitle();
        String url = driver.getCurrentUrl();

        // Print the title and current URL
        System.out.println("Title: " + title);
        System.out.println("Current URL: " + url);


//-----------------------------------------------------------------------------------------------------
//List the size and display the number of web elements present in the current webpage

        // Find all web elements on the page and display size
        List<WebElement> allElements = driver.findElements(By.xpath("//*"));
        Dimension screenSize = driver.manage().window().getSize();


        int height = screenSize.getHeight();
        int width = screenSize.getWidth();

        // Display the size of the list
        System.out.println("Total number of web elements on the page: " + allElements.size());
        System.out.println("Height of webpage is: "+height);
        System.out.println("Width of webpage is: "+width);

        for (WebElement i : allElements){
            String str = i.getText();
            if(!str.isEmpty())
                System.out.println(i.getText());
        }

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        // Close the browser
        driver.quit();
    }
}
