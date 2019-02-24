package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.logging.Logger;

public class MailPO {
    private WebDriver drivar;

    private static Logger logger = Logger.getLogger(MailPO.class.getName());

    @FindBy(xpath = "//*[@id=\":4\"]/div[3]/div[1]/div/div[2]/div[3]")
    private WebElement deletebtn;

    public MailPO(WebDriver driver) {
        this.drivar = driver;
        PageFactory.initElements(driver, this);
    }

    public void clickDelete() {
        logger.info("click delete message button");
        deletebtn.click();
    }

    public boolean isMailDeleted() {
        try {
            WebElement undo = drivar.findElement(By.xpath("//*[@id=\"link_undo\"]"));
            return true;
        } catch (NoSuchElementException ex) {
            return false;
        }
    }
}
