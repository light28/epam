package Decorator.Elements;

import Decorator.Element;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class Input extends Element implements WebElement {

    public Input(WebElement webElement) {
        super(webElement);
    }

    public boolean isHideField(WebDriver driver) {
        boolean isHide = true;
        try {
            (new WebDriverWait(driver, 15)).until(ExpectedConditions.visibilityOf(webElement));
        } catch (Exception ex) {
            isHide = false;
        }
        return isHide;
    }

    public void sendToHideField(WebDriver driver, String msg)
    {
        if(isHideField(driver)){
            webElement.sendKeys(msg);
        }
    }

    @Override
    public void click() {
        webElement.click();
    }

    @Override
    public void submit() {
        webElement.submit();
    }

    @Override
    public void sendKeys(CharSequence... charSequences) {

        webElement.sendKeys(charSequences);
    }

    public void clear() {
        if (!webElement.getText().isEmpty()) {
            webElement.clear();
        }
    }

    @Override
    public String getTagName() {
        return null;
    }

    @Override
    public String getAttribute(String s) {
        return null;
    }

    @Override
    public boolean isSelected() {
        return false;
    }

    @Override
    public boolean isEnabled() {
        return false;
    }

    @Override
    public String getText() {
        return null;
    }

    @Override
    public List<WebElement> findElements(By by) {
        return null;
    }

    @Override
    public WebElement findElement(By by) {
        return null;
    }

    @Override
    public boolean isDisplayed() {
        return false;
    }

    @Override
    public Point getLocation() {
        return null;
    }

    @Override
    public Dimension getSize() {
        return null;
    }

    @Override
    public Rectangle getRect() {
        return null;
    }

    @Override
    public String getCssValue(String s) {
        return null;
    }

    public boolean isReadOnly() {
        String readonly = webElement.getAttribute("readonly");
        if (readonly == null) return false;
        return true;
    }


    @Override
    public <X> X getScreenshotAs(OutputType<X> outputType) throws WebDriverException {
        return null;
    }
}