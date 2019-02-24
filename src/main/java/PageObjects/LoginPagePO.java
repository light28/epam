package PageObjects;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.logging.Logger;

public class LoginPagePO {
    private WebDriver driver;

    private static Logger logger = Logger.getLogger(LoginPagePO.class.getName());

    @FindBy(tagName = "input")
    private WebElement loginField;

    public LoginPagePO(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void writeLogin(String login) {
        logger.info("filling login");
        loginField.sendKeys(login);
    }

    public PasswordPagePO sendLogin() {
        logger.info("sending login");
        loginField.sendKeys(Keys.ENTER);
        return new PasswordPagePO(driver);
    }
}
