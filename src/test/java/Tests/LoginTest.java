package Tests;

import base.BasePage;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class LoginTest extends BasePage{

    @Test
    public void testLoginPage() throws InterruptedException
    {
        String userId = "cuche_s@yahoo.com", password = "deFec75t.";

        //Sign in to ​Konga
        homePage = BasePage.sample("https://www.konga.com/");

        var loginPage = homePage.clickLoginSignUpButton();

        //Replace the username and password string with valid user details
        loginPage.enterUsername(userId);
        loginPage.enterPassword(password);

        //Click on Login Button
        homePage = loginPage.clickLoginButton();

    }
}
