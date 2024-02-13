package automation.external;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;

public interface ElementMapper {
    void setText(By by, String value);

    String getText(By by);

    void click(By by);

    void waitUntil(ExpectedCondition expectedCondition);

    int getSize(By by);

    boolean isEnabled(By by);

    boolean isSelected(By by);

    Boolean verifyElementPresent(By by);

    Boolean verifyElementNotPresent(By by);

    Boolean verifyTextPresent(String text);

    WebElement findElement(By by);

    void selectOptionByValue(By by, String value);

    void scrollToElement(By by);
}
