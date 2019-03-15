package com.cucumber.framework.base;

import org.openqa.selenium.WebDriver;

public class Browser extends Base {

    public Browser(WebDriver driver) {
        this.driver = driver;
    }

    private WebDriver driver;

    private BrowserType Type;

    public void GoToUrl(String url){
        driver.get(url);
    }

    public void Maximize(){
        driver.manage().window().maximize();
    }

    public void Close(){
        driver.quit();
    }

}









