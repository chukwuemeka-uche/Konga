package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage {
    private WebDriver driver;
    private By loginButton = By.xpath("//a[@class='_7ad32_SD12Y _16536_xxIKG']");
    private By categoryBarElement = By.className("ef511_2c5_i");
    private By subcategory = By.xpath(".//a[contains(text(),'Macbooks')]");
    //Category number where 0 = All Categories and  7 = Wines & Other Categories
    int categoryNumber = 1;
    //Subcategory number where 0 = Mini Laptops and Netbooks and  4 = Macbooks
    int loginButtonElementID = 3;

    public HomePage(WebDriver driver)
    {
        this.driver = driver;
    }

    public LoginPage clickLoginSignUpButton()
    {
        driver.findElements(loginButton).get(loginButtonElementID).click();
        return new LoginPage(driver);
    }


    public SubCategoryPage clickCategoryAndSub() throws InterruptedException
    {
        Actions executeAction = new Actions(driver);

        WebDriverWait wait = new WebDriverWait(driver, 30);
        WebElement selectedCategory = driver.findElements(categoryBarElement).get(categoryNumber);
        //Mouse hover on the selected category
        executeAction.moveToElement(selectedCategory).perform();
        Thread.sleep(7000);

        //Wait for the element to appear before clicking on the selected subcategory
        //wait.until(ExpectedConditions.visibilityOfElementLocated(subcategory));
        //Click on the MacBook
        driver.findElement(subcategory).click();
        Thread.sleep(5000);

        return new SubCategoryPage(driver);
    }
}
