package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import Model.Mail;

import java.util.logging.Logger;

public class MailFormPO {
    private WebDriver driver;

    private static Logger logger = Logger.getLogger(MailFormPO.class.getName());

    @FindBy(name = "to")
    private WebElement toField;

    @FindBy(name = "subjectbox")
    private WebElement subjectField;

    @FindBy(xpath = "//div[@role = 'textbox']")
    private WebElement textField;

    @FindBy(xpath = "//div[@class='J-J5-Ji btA']//div[@role='button']")
    private WebElement sendBtn;

    MailFormPO(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void writeTo(String to) {
        toField.sendKeys(to);
    }

    public void writeSubject(String subject) {
        subjectField.sendKeys(subject);
    }

    public void writeText(String text) {
        textField.sendKeys(text);
    }

    public void writeEmail(Mail mail) {
        logger.info("filling to field");
        writeTo(mail.to);
        logger.info("filling subject field");
        writeSubject(mail.subject);
        logger.info("filling textbox");
        writeText(mail.text);
    }

    public void clickSend() {
        sendBtn.click();
    }
}
