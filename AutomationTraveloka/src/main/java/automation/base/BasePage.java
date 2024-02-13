package automation.base;

import automation.external.Helper;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import automation.external.Element;

public abstract class BasePage <C extends BaseModel, M extends BaseLocator> {

    public WebDriver webDriver;
    public WebDriverWait webDriverWait;
    public Element element;
    public Helper stepHelper;

    public Element getElement() {
        return this.element;
    }

    public C mModel;
    public M mLocator;

    public abstract void setupController();
    public abstract void setupPathElement();

    public void initInstance(WebDriver driver, WebDriverWait driverWait) {
        this.webDriver = driver;
        this.webDriverWait = driverWait;
        element = Element.newInstance(webDriver, webDriverWait);
        stepHelper = Helper.newInstance(element);
        setupController();
        setupPathElement();
    }
}
