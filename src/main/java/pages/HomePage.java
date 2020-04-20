package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class HomePage {
    private WebDriver driver;
    private By loginButton = By.xpath("//a[@class='_7ad32_SD12Y _16536_xxIKG']");
    private By categoryBarElement = By.className("ef511_2c5_i");
    private By subcategory = By.xpath(".//a[contains(text(),'Macbooks')]");
    //Category number where 0 = All Categories and  7 = Wines & Other Categories
    int categoryNumber = 1;
    //Subcategory number where 0 = Mini Laptops and Netbooks and  4 = Macbooks
    int loginButtonElementID = 3;
    private By searchBar = By.xpath("//input[@type='search']");
    private By searchButton = By.className("fdd83_39Iap");
    int searchBarElementsID = 1; //The elements on search were more than 1
    private By AddToCartButton = By.xpath("//button[@class='_0a08a_3czMG']");
    private By MyCartButton= By.xpath("//a[@class='_79484_1sLEt _7ad32_SD12Y _16536_xxIKG']");

    public HomePage(WebDriver driver)
    {
        this.driver = driver;
    }

    //Click the login/sign up button on the landing page
    public LoginPage clickLoginSignUpButton()
    {
        driver.findElements(loginButton).get(loginButtonElementID).click();
        return new LoginPage(driver);
    }

    public void mouseHoverOnACategory() throws InterruptedException
    {
        Actions executeAction = new Actions(driver);
        Thread.sleep(10000);

        //choose the category to mouse hover
        WebElement selectedCategory = driver.findElements(categoryBarElement).get(categoryNumber);
        //Mouse hover on the selected category
        executeAction.moveToElement(selectedCategory).perform();
        Thread.sleep(7000);
    }

    public void clickOnASubCategory() throws InterruptedException
    {
        //Click on the MacBook
        driver.findElement(subcategory).click();
        Thread.sleep(5000);
    }

    public void searchForAnItem(String item)
    {
        //Search for an item on the search bar
        driver.findElements(searchBar).get(searchBarElementsID).sendKeys(item);
    }

    public void clickSearchButton() throws InterruptedException
    {
        //Click on the search button on the search bar
        driver.findElements(searchButton).get(searchBarElementsID).click();
        Thread.sleep(5000);
    }

    //Click the first Add to cart button
    public void clickOnAddToCart(int index) throws InterruptedException
    {
        driver.findElements(AddToCartButton).get(index - 1).click();
        Thread.sleep(5000);
    }

    //Click My Cart Button
    public AddToCartPage clickMyCartButton() throws InterruptedException
    {
        driver.findElement(MyCartButton).click();
        Thread.sleep(3000);
        return new AddToCartPage(driver);
    }
}
