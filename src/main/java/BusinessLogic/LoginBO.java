package BusinessLogic;

import PageObjects.GmailMainPO;
import PageObjects.InboxMailsPO;
import PageObjects.LoginPagePO;
import PageObjects.PasswordPagePO;
import org.openqa.selenium.WebDriver;

public class LoginBO {
    private WebDriver driver;

    public LoginBO(WebDriver driver) {
        this.driver = driver;
    }

    public void login(String userLogin, String userPassword) {
        GmailMainPO gmail = new GmailMainPO(driver);
        LoginPagePO login = gmail.clickSignIn();
        login.writeLogin(userLogin);
        PasswordPagePO password = login.sendLogin();
        password.writePassword(userPassword);
        password.sendPassword();
    }

    public boolean isUserLogin() {
        InboxMailsPO inbox = new InboxMailsPO(driver);
        return inbox.isInboxPage();
    }
}
