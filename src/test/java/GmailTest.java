import BusinessLogic.LoginBO;
import BusinessLogic.MailBO;
import Driver.DriverManager;
import Model.Mail;
import Model.User;
import Parser.XMLParser;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertTrue;

public class GmailTest {


    @Test(dataProvider = "user_data")
    public void loginSendDeleteTest(User user) {
        WebDriver driver = DriverManager.init();
        LoginBO loginObj = new LoginBO(driver);
        MailBO mailBO = new MailBO(driver);

        Mail mail = new Mail("vasua.vasua1999@gmail.com", "selenium", "-_-");

        loginObj.login(user.login, user.password);
        assertTrue(loginObj.isUserLogin());
        mailBO.sendMail(mail);
        assertTrue(mailBO.isMailSent());
        mailBO.deleteMail();
        assertTrue(mailBO.isMailDeleted());
    }

    @DataProvider(name = "user_data", parallel  = true)
    public Object[][] provide() {
        XMLParser parser = new XMLParser();
        ArrayList<User> users = parser.getUsers();
        Object[][] object = new Object[users.size()][1];
        for(int i = 0; i < users.size(); i++) {
            object[i][0] = users.get(i);
        }

        return object;
    }


}
