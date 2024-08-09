package main.java.com.fetch;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class FindFakeGoldBar {

    public static void main(String[] args) {

        System.setProperty("webdriver.chrome.driver", "C:\\Drivers\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        driver.get("http://sdetchallenge.fetch.com/");

        // Initializing the array of gold bars
        int[] bars = {0, 1, 2, 3, 4, 5, 6, 7, 8};

        // Weighing first time
        int fakeBarIndex = findFakeBar(driver, bars);
                
        WebElement result = driver.findElement(By.id("coin_" + fakeBarIndex));
        result.click();

        // Output the result
        System.out.println("Fake gold bar: " + fakeBarIndex);

        // Switch to the alert
        Alert alert = driver.switchTo().alert();

        // Read the text from the alert
        String alertText = alert.getText();
        System.out.println("Alert Message: " + alertText);

        // Accept the alert
        alert.accept();
        
        WebElement weighings = driver.findElement(By.className("game-info"));
        System.out.println(weighings.getText());
        
        driver.quit();
    }

    private static int findFakeBar(WebDriver driver, int[] bars) {
    	
    	// dividing 9 gold bars into 3 groups
        int[] group1 = {bars[0], bars[1], bars[2]};
        int[] group2 = {bars[3], bars[4], bars[5]};
        int[] group3 = {bars[6], bars[7], bars[8]};

        // Weigh group1 vs group2
        String result = weigh(driver, group1, group2);
        if (result.equals("equal")) {
            return findInGroup(driver, group3);		// Fake bar is in group3 if group1=group2
        } else if (result.equals("left")) {
            return findInGroup(driver, group1);		// Fake bar is in group1 if group1<group2
        } else {
            return findInGroup(driver, group2);		// Fake bar is in group2 if group1>group2
        }
    }

    private static int findInGroup(WebDriver driver, int[] group) {
        // Weigh first two bars in a group
    	    	
        String result = weigh(driver, new int[]{group[0]}, new int[]{group[1]});
        if (result.equals("equal")) {
            return group[2]; 	// The third bar is the fake one if group[0] = group[1]
        } else if (result.equals("left")) {
            return group[0]; 	// The first bar is the fake one if group[0] < group[1]
        } else {
            return group[1]; 	// The second bar is the fake one if group[0] > group[1]
        }
    }

    private static String weigh(WebDriver driver, int[] leftGroup, int[] rightGroup) {

    	// Clear previous weighing (Clicking on reset button)
        driver.findElement(By.xpath("(//button[@id='reset'])[2]")).click();
        
        // Filling the bowls
        fillBowl(driver, "left", leftGroup);
        fillBowl(driver, "right", rightGroup);

        // Perform weigh operation (Clicking on weigh button)
        driver.findElement(By.id("weigh")).click();
        
        // Wait until the text under result changes from "?" to something else
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.not(ExpectedConditions.textToBe(By.xpath("(//button[@id='reset'])[1]"), "?")));

        // Get the result from text under result either <,> or =
        WebElement resultElement = driver.findElement(By.xpath("(//button[@id='reset'])[1]"));
        String res = resultElement.getText();

        // Determine which side is lighter based on text we get (<,>,=)
        if (res.contains("<")) {
            return "left";
        } else if (res.contains(">")) {
            return "right";
        } else {
            return "equal";
        }
    }
    
    // function to enter the numbers into the bowl
    private static void fillBowl(WebDriver driver, String bowl, int[] group) {
        for (int i = 0; i < group.length; i++) {
            int bar = group[i];
            WebElement input = driver.findElement(By.id(bowl + "_" + i));
            input.clear();
            input.sendKeys(String.valueOf(bar));
        }
    }
}
