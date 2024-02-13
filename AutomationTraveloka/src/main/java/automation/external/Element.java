package automation.external;

import org.openqa.selenium.By;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class Element implements ElementMapper {

    public final WebDriver webDriver;
    public final WebDriverWait webDriverWait;

    public static Element newInstance(WebDriver driver, WebDriverWait driverWait) {
        return new Element(driver, driverWait);
    }

    public Element(WebDriver driver, WebDriverWait driverWait) {
        this.webDriver = driver;
        this.webDriverWait = driverWait;
    }

    @Override
    public void setText(By by, String value) {
        String message = Thread.currentThread().getStackTrace()[1].getMethodName() + ": " + by.toString();
        System.out.println(message);
        webDriver.findElement(by).sendKeys(value);
    }

    @Override
    public String getText(By by) {
        String message = Thread.currentThread().getStackTrace()[1].getMethodName() + ": " + by.toString();
        System.out.println(message);
        return webDriver.findElement(by).getText();
    }

    @Override
    public void click(By by) {
        String message = Thread.currentThread().getStackTrace()[1].getMethodName() + ": " + by.toString();
        System.out.println(message);
        webDriver.findElement(by).click();
    }

    @Override
    public void waitUntil(ExpectedCondition expectedCondition) {
        String message = Thread.currentThread().getStackTrace()[1].getMethodName() + ": " + expectedCondition.toString();
        System.out.println(message);
        webDriverWait.until(expectedCondition);
    }

    @Override
    public int getSize(By by) {
        String message = Thread.currentThread().getStackTrace()[1].getMethodName() + ": " + by.toString();
        System.out.println(message);
        return webDriver.findElements(by).size();
    }

    @Override
    public boolean isEnabled(By by) {
        String message = Thread.currentThread().getStackTrace()[1].getMethodName() + ": " + by.toString();
        System.out.println(message);
        return webDriver.findElement(by).isEnabled();
    }

    @Override
    public boolean isSelected(By by) {
        String message = Thread.currentThread().getStackTrace()[1].getMethodName() + ": " + by.toString();
        System.out.println(message);
        return webDriver.findElement(by).isSelected();
    }

    @Override
    public Boolean verifyElementPresent(By by) {
        String message = Thread.currentThread().getStackTrace()[1].getMethodName() + ": " + by.toString();
        System.out.println(message);
        List<WebElement> elements = webDriver.findElements(by);
        return elements != null && elements.size() > 0;
    }

    @Override
    public Boolean verifyElementNotPresent(By by) {
        String message = Thread.currentThread().getStackTrace()[1].getMethodName() + ": " + by.toString();
        System.out.println(message);
        return webDriver.findElements(by).size() == 0;
    }

    @Override
    public Boolean verifyTextPresent(String text) {
        String funcName = Thread.currentThread().getStackTrace()[1].getMethodName() + ": " + text;
        System.out.println(funcName);
        return webDriver.getPageSource().contains(text);
    }

    @Override
    public WebElement findElement(By by) {
        return webDriver.findElement(by);
    }

    @Override
    public void selectOptionByValue(By by, String value) {
        String message = Thread.currentThread().getStackTrace()[1].getMethodName() + ": " + by.toString();
        System.out.println(message);
        Select select = new Select(webDriver.findElement(by));
        select.selectByValue(value);
    }

    @Override
    public void scrollToElement(By by) {
        try {
            String message = Thread.currentThread().getStackTrace()[1].getMethodName() + ": " + by.toString();
            System.out.println(message);
            JavascriptExecutor js = (JavascriptExecutor) webDriver;
            js.executeScript("arguments[0].scrollIntoView();", webDriver.findElement(by));
            Thread.sleep(2000);
        } catch (InterruptedException exception) {
            exception.printStackTrace();
        }
    }
}
