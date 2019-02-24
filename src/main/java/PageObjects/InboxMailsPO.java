package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;

import java.util.logging.Logger;

public class InboxMailsPO {
    private WebDriver driver;

    private static Logger logger = Logger.getLogger(InboxMailsPO.class.getName());

    @FindBy(xpath = "//div[@class = 'T-I J-J5-Ji T-I-KE L3']")
    private WebElement composeBtn;

    @FindBy(xpath = "//*[@id=\"link_vsm\"]")
    private WebElement sentMailBtn;

    public InboxMailsPO(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public MailFormPO clickCompose() {
        logger.info("click compose button");
        composeBtn.click();
        return  new MailFormPO(driver);
    }

    public MailPO clickSent() {
        logger.info("click view message");
        sentMailBtn.click();
        return new MailPO(driver);
    }
}
