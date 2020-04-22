package konga;

import base.BasePage;
import org.testng.annotations.Test;
import pages.*;
import java.util.Random;


public class KongaTest extends BasePage{
    @Test
    public void testLoginPage()
    {
        int addToCartButtonID = 1, numberOfItems = 4, minPin =0, maxPin = 9, pinEnteries = 0, totalPinEntered = 4;
        String userId = "Enter Username", password = "Enter Password" , item = "Drinks",
                cardNumber = "5334 5678 2233 4456", date = "02/20", cvv = "254";
        //Instantiate random class
        Random random = new Random();

        try {//Sign in to ​Konga
            //Replaced the class type name 'LoginPage' with 'var'
            var loginPage = homePage.clickLoginSignUpButton();
            //Replace the username and password string with valid user details
            loginPage.enterUsername(userId);
            loginPage.enterPassword(password);
            //Click on Login Button
            loginPage.clickLoginButton();
            //Select any of the categories and subcategory
            var subCategoryPage = homePage.clickCategoryAndSub();
            //Use the search box, search for an item
            subCategoryPage.searchForAnItem(item);
            SearchPage searchPage = subCategoryPage.clickSearchButton();
            //Click on the add to cart button
            searchPage.clickOnAddToCart(addToCartButtonID);
            //Click on the My Cart Menu
            var addToCartPage = searchPage.clickMyCartButton();
            //Increase the number of item to 4
            addToCartPage.itemCount(numberOfItems);
            //Click on checkout
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
            while(pinEnteries != totalPinEntered) {
                //Store randomly entered pin
                int enterPin = random.nextInt((maxPin - minPin + 1) + minPin);
                //Enter the pin
                checkOutPage.clickOnPin(enterPin);
                //Increment pin entry
                pinEnteries++;
            }
            //Print out the error message for the card number field.
            System.out.println(checkOutPage.invalid_message());
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}
