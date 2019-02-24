package PageObjects;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.logging.Logger;

public class PasswordPagePO {
    private WebDriver driver;

    private static Logger logger = Logger.getLogger(PasswordPagePO.class.getName());

    @FindBy(name = "password")
    private WebElement passwordField;

    public PasswordPagePO(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void writePassword(String password) {
        logger.info("filling password");
        passwordField.sendKeys(password);
    }

    public void sendPassword() {
        logger.info("sending password");
        passwordField.sendKeys(Keys.ENTER);
    }
}
