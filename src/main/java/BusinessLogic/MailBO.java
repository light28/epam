package BusinessLogic;

import Model.Mail;
import PageObjects.InboxMailsPO;
import PageObjects.MailFormPO;
import PageObjects.MailPO;
import org.openqa.selenium.WebDriver;

public class MailBO {
    private WebDriver driver;

    public MailBO(WebDriver driver) {
        this.driver = driver;
    }

    public void sendMail(Mail mail) {
        InboxMailsPO inbox = new InboxMailsPO(driver);
        MailFormPO mailForm = inbox.clickCompose();
        mailForm.writeEmail(mail);
        mailForm.clickSend();
    }

    public void deleteMail() {
        InboxMailsPO inbox = new InboxMailsPO(driver);
        MailPO smail = inbox.clickSent();
        smail.clickDelete();
    }

    public boolean isMailSent() {
        InboxMailsPO inbox = new InboxMailsPO(driver);
        return inbox.isMailSent();
    }

    public boolean isMailDeleted() {
        MailPO mail = new MailPO(driver);
        return  mail.isMailDeleted();
    }
}
