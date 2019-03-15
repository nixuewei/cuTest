package com.cucumber.framework.base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.firefox.internal.ProfilesIni;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.safari.SafariOptions;

public class FrameworkInitialize extends Base{
    public void InitializeBrowser(BrowserType types){

        WebDriver driver = null;

        String os = System.getProperty("os.name").toLowerCase();
        System.out.println("Current Operating System is >>> " + os);



        switch (types){
            case Chrome:{
                if(os.contains("mac")){
                    System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir")+"/libs/chromedriver");
                }
                else{
                    System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir")+"\\libs\\chromedriver.exe");
                }

                ChromeOptions opts = new ChromeOptions();
                driver = new ChromeDriver(opts);
                break;
            }
            case HeadlessChrome:{
                if(os.contains("mac")){
                    System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir")+"/libs/chromedriver");
                }
                else{
                    System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir")+"\\libs\\chromedriver.exe");
                }

                ChromeOptions opts = new ChromeOptions();
                opts.setHeadless(true);
                driver = new ChromeDriver(opts);
                break;
            }

            case Firefox:{
                if(os.contains("mac")){
                    System.setProperty("webdriver.gecko.driver",System.getProperty("user.dir")+"/libs/geckodriver");
                }
                else{
                    System.setProperty("webdriver.gecko.driver",System.getProperty("user.dir")+"\\libs\\geckodriver.exe");
                }

                ProfilesIni profile = new ProfilesIni();
                FirefoxProfile myProfile = profile.getProfile("default");

                FirefoxOptions opts = new FirefoxOptions();
                opts.setProfile(myProfile);

                driver = new FirefoxDriver(opts);
                break;
            }
            case HeadlessFirefox:{
                if(os.contains("mac")){
                    System.setProperty("webdriver.gecko.driver",System.getProperty("user.dir")+"/libs/geckodriver");
                }
                else{
                    System.setProperty("webdriver.gecko.driver",System.getProperty("user.dir")+"\\libs\\geckodriver.exe");
                }

                ProfilesIni profile = new ProfilesIni();
                FirefoxProfile myProfile = profile.getProfile("default");

                FirefoxOptions opts = new FirefoxOptions();
                opts.setProfile(myProfile);
                opts.setHeadless(true);

                driver = new FirefoxDriver(opts);
                break;
            }

            case IE:{
                driver = new InternetExplorerDriver();
                break;
            }

            case EDGE:{
                driver = new EdgeDriver();
                break;
            }

            case Safari: {
                SafariOptions safariOptions = new SafariOptions();
                safariOptions.setCapability("safari.cleanSession", true);
                safariOptions.setUseTechnologyPreview(false);

                driver = new SafariDriver(safariOptions);
                break;
            }

        }
        //Setting driver to drivercontext so it can be used anywhere
        DriverContext.setDriver(driver);

        //Setting browser to drivercontext so it can be used anywhere
        DriverContext.Browser = new Browser(driver);

    }


}
