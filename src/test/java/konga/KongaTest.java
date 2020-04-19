package konga;

import base.BasePage;
import org.testng.annotations.Test;
import pages.*;


public class KongaTest extends BasePage{
    @Test
    public void testLoginPage()
    {
        int addToCartButtonID = 1, numberOfItems = 4;;
        String userId = "Enter username", password = "Enter password", item = "Drinks",
                cardNumber = "5334567822334456", date = "02/20", cvv = "254";

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
            //Input a wrong card number, date, CVV and pin
            checkOutPage.enterCardDetails(cardNumber, date , cvv);
            //Print out the error message for the card number field.
            System.out.println(checkOutPage.invalid_message());
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}
