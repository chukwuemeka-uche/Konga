package loginPageTest;

import base.BasePage;
import org.testng.annotations.Test;

public class LoginTest extends BasePage{
    @Test(priority = 1)
    public void testLoginPage() throws InterruptedException
    {
        String userId = "cuche_s@yahoo.com", password = "deFec75t.";

        //Sign in to ​Konga
        var loginPage = homePage.clickLoginSignUpButton();

        //Replace the username and password string with valid user details
        loginPage.enterUsername(userId);
        loginPage.enterPassword(password);

        //Click on Login Button
        homePage = loginPage.clickLoginButton();

    }
}
