package com.indu;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriverException;
import java.time.Duration;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Implementation
{
    static WebDriver driver;
    public static void driverimplementation() throws InterruptedException {
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.manage().deleteAllCookies();
        driver.get("https://apsrtclivetrack.com/#/ ");
        System.out.println("Launched website");
        Thread.sleep(4000);
    }
    public static String getPageTitle()
    {
        return driver.getTitle();
    }
    public static void codeImplementation()
    {
        try {
            JavascriptExecutor js = (JavascriptExecutor) driver;
            WebElement ele=driver.findElement(By.tagName("flt-glass-pane"));
            WebElement shadowRoot = (WebElement) js.executeScript("return arguments[0].shadowRoot", ele);
            WebElement shadowElement = shadowRoot.findElement(By.xpath("//input[contains(@class,'flt-text-editing transparentTextEditing')]"));
        } catch (NoSuchElementException e) {
            System.out.println("Shadow element not found: " + e.getMessage());
        } catch (WebDriverException e) {
            System.out.println("WebDriver error: " + e.getMessage());
        }

    }
    public static void driverclose()
    {
        driver.quit();
        System.out.println("driver quit");
    }
}
