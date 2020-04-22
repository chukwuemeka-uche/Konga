package searchForAnItemTest;

import base.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;
import pages.HomePage;

import java.util.Random;

public class SearchTest extends BasePage {


    String item = "Drinks";
    int addToCartButtonID = 1;
    int numberOfItems = 4;
    String  cardNumber = "5334 5678 2233 4456", date = "02/20", cvv = "254";
    int  minPin =0, maxPin = 9, pinEntries = 1, totalPinEntered = 4;
    Random random = new Random();

    @Test(priority = 3)
    public void testSearchForAnItem() throws InterruptedException
    {
        //Click on Login Button
        homePage.searchForAnItem(item);
        homePage.clickSearchButton();
    }

    @Test(priority = 4)
    public void clickAddToCartButton() throws InterruptedException
    {
        //Click on the add to cart button
        homePage.clickOnAddToCart(addToCartButtonID);
    }

    @Test(priority = 5)
    public void manageCartMenu() throws InterruptedException
    {
        //Click on the My Cart Menu
        var addToCartPage = homePage.clickMyCartButton();
        addToCartPage.itemCount(numberOfItems);

        var checkOutPage = addToCartPage.clickCheckOut();
        //Click "Pay Now" to enable “Continue to Payment” button - the user must have preselected pick up method
        checkOutPage.clickOnPayNow();
        //Click on the “Continue to Payment” button
        checkOutPage.clickContinueToPayment();
        //Select the “CARD” payment method
        checkOutPage.clickOnPaymentType();
        //Input a wrong card number, date, CVV
        checkOutPage.enterCardDetails(cardNumber, date , cvv);
        //Click on the Field for entering card pin
        checkOutPage.clickOnPinField();

        //Enter pin randomly
        while(pinEntries != totalPinEntered) {
            //Store randomly entered pin
            int enterPin = random.nextInt((maxPin - minPin + 1) + minPin);
            //Enter the pin
            checkOutPage.clickOnPin(enterPin);
            //Increment pin entry
            pinEntries++;
        }

        //Print out the error message for the card number field.
        System.out.println(checkOutPage.invalid_message());
    }
}
