package base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import pages.HomePage;

import java.util.concurrent.TimeUnit;

import static java.util.concurrent.TimeUnit.SECONDS;

public class BasePage {

    private WebDriver driver;
    public HomePage homePage;

    @BeforeClass
    public void setup()
    {
        System.setProperty("webdriver.gecko.driver", "E:/test_automation/resources/geckodriver2.exe");
        driver = new FirefoxDriver();

        //Maximize web browser
        driver.manage().window().maximize();
        //Open URL on browser
        driver.get("https://www.konga.com/");
        homePage = new HomePage(driver);
    }

    @AfterClass
    public void tearDown()
    {
        driver.quit();
    }
}
