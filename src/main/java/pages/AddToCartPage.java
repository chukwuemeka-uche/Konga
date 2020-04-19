package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AddToCartPage {

    private WebDriver driver;
    private By totalItemCount = By.xpath("//div[@class='a03ba_1Zj-T']");
    private By addItem = By.xpath("//button[@name='increment']");
    private By checkOutButton = By.xpath("//div[@class='_2aac2_3bwnD  _841f1_1RZK9']");

    public AddToCartPage(WebDriver driver)
    {
        this.driver = driver;
    }

    //Check the number of items in the cart
    public void itemCount(int count) throws InterruptedException
    {
        int itemNumber = Integer.parseInt(driver.findElement(totalItemCount).getText());

        //If the item is not equal to required amount, keep adding
        while (itemNumber != count)
        {
            //Click the + button to increase the number of the selected item
            driver.findElement(addItem).click();
            //update the count of items
            itemNumber = Integer.parseInt(driver.findElement(totalItemCount).getText());
        }
        Thread.sleep(5000);
    }

    //Click on check out button
    public CheckOutPage clickCheckOut() throws InterruptedException
    {
        driver.findElement(checkOutButton).click();
        Thread.sleep(7000);
        return new CheckOutPage(driver);
    }
}
