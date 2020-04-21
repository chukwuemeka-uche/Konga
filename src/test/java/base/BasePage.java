package base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;
import pages.HomePage;

import java.util.concurrent.TimeUnit;

public class BasePage {

    static WebDriver driver;
    public HomePage homePage;

    //Initialize WebDriver, open the browser  & go to the URL before conducting the test
    @BeforeSuite
    public void setup()
    {

        System.setProperty ( "webdriver.chrome.driver" , "C:/Users/User/eclipse-workspace/driver/chromedriver.exe" );

        //Initializing WebDriver
        driver = new ChromeDriver ();

        //Delete cookies
        driver.manage ().deleteAllCookies ();

        //Maximize web browser
        driver.manage().window().maximize();

        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

        //Open URL on browser

    }


    public static  HomePage sample(String url)
    {
        driver.get(url);

        return new HomePage ( driver );
    }

    //Close WebDriver and browser after completing the test
    @AfterSuite
    public void tearDown()
    {
        driver.quit();
    }
}
