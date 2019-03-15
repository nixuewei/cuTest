package com.cucumber.framework.base;

import com.cucumber.framework.config.Settings;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DriverContext {

    public static WebDriver Driver;

    public static Browser Browser;

    public static void setDriver(WebDriver driver) {
        Driver = driver;
    }

    public static void WaitForPageToLoad(){
        WebDriverWait wait = new WebDriverWait(Driver, 30);
        JavascriptExecutor jsExecutor = (JavascriptExecutor) Driver;
        ExpectedCondition<Boolean> jsLoad = webDriver -> ((JavascriptExecutor)Driver)
                .executeScript("return document.readyState").toString().equals("complete");

        boolean jsReady = jsExecutor.executeScript("return document.readyState").toString().equals("complete");

        if(!jsReady)
            wait.until(jsLoad);
        else
            Settings.Logs.Write("Page is ready!");
        //ToDo: Failing for Safari
    }

    public static void WaitForElementVisible(final WebElement elementFindBy){
        WebDriverWait wait = new WebDriverWait(Driver, 30);
        wait.until(ExpectedConditions.visibilityOf(elementFindBy));
    }

    public static void WaitForElementTextVisible(final WebElement elementFindBy, String text){
        WebDriverWait wait = new WebDriverWait(Driver, 30);
        wait.until(ExpectedConditions.textToBePresentInElement(elementFindBy, text));
    }

    public static void WaitUntilTextDisplayed(final By element, String text){
        WebDriverWait wait = new WebDriverWait(Driver, 30);
        wait.until(webDriver -> webDriver.findElement(element).getText().contains(text));
    }

    public static void WaitElementEnabled(final By element, String text){
        WebDriverWait wait = new WebDriverWait(Driver, 30);
        wait.until(webDriver -> webDriver.findElement(element).isEnabled());
    }

}
