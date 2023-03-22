package com.example.selenpractice;

import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ScreenShot {
    public static void takeScreenShot(WebDriver driver) {
        // Take the screenshot and save it to a file
        File screenshotFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);

        //create timestamp variable to name a file based on when it was taken
        String timestamp = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());

        // Save the screenshot to a file
        screenshotFile.renameTo(new File("C:\\Users\\khuba\\JavaProjects\\SelenPractice\\screenshots\\"+ timestamp +".png"));
    }
}
