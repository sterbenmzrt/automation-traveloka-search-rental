package org.traveloka.base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.*;

import java.util.concurrent.TimeUnit;

public abstract class BaseWebDriver {

    public WebDriver webDriver;
    public WebDriverWait webDriverWait;
    public String url;

    public abstract void initInstance();

    @BeforeSuite
    public void globalSetup() {
        System.out.println("Global setup");
        url = "https://www.traveloka.com/";
    }

    @AfterSuite
    public void globalTearDown() {
        System.out.println("Global teardown");
        if (webDriver != null) {
            webDriver.quit();
            webDriver = null;
        }
    }

    @BeforeTest
    public void onBeforeTest(){
        initWebDriver();
        initInstance();
        openBrowser();
    }

    @AfterTest
    public void onAfterTest(){
    }

    @BeforeMethod
    public void setupMethod(){
        if (webDriver == null) {
            initWebDriver();
            openBrowser();
        }
    }

    @AfterMethod
    public void tearDown(){
        if (webDriver != null) {
            webDriver.quit();
            webDriver = null;
        }
    }

    public void initWebDriver(){
        webDriver = new ChromeDriver();
        webDriver.manage().window().maximize();
        webDriver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        webDriverWait = new WebDriverWait(webDriver, 30);
    }

    public void openBrowser(){
        webDriver.navigate().to(url);
        try {
            Thread.sleep(2000);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
