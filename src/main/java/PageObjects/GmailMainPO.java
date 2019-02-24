package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import java.util.logging.Logger;

public class GmailMainPO {
    private WebDriver driver;
    private static Logger logger = Logger.getLogger(GmailMainPO.class.getName());

    @FindBy(xpath = "//*/a[2]")
    private WebElement signIn;

    public GmailMainPO(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public LoginPagePO clickSignIn() {
        logger.info("sign in click");
        signIn.click();
        return new LoginPagePO(driver);
    }
}
