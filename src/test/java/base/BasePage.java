package base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.*;
import pages.HomePage;

public class BasePage {

    private static WebDriver driver;
    public static HomePage homePage;

    //Initialize WebDriver, open the browser  & go to the URL before conducting the test
    @BeforeSuite
    public void setup()
    {
        System.setProperty("webdriver.gecko.driver", "E:/test_automation/resources/geckodriver2.exe");
        //Initializing WebDriver
        driver = new FirefoxDriver();

        //Maximize web browser
        driver.manage().window().maximize();
        //Open URL on browser
        driver.get("https://www.konga.com/");
    }

    @BeforeClass
    //Make this static to prevent No exception error
    public static void instantiate()
    {
        homePage = new HomePage(driver);
    }

    //Close WebDriver and browser after completing the test
    @AfterSuite
    public void tearDown()
    {
        driver.quit();
    }
}
