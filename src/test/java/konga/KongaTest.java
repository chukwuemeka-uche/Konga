package konga;

import base.BasePage;
import net.bytebuddy.implementation.bytecode.Throw;
import org.testng.annotations.Test;
import pages.*;


public class KongaTest extends BasePage{
    @Test
    public void testLoginPage()
    {
        int addToCartButtonID = 1;
        int numberOfItems = 4;

        try {//Sign in to ​Konga
            LoginPage loginPage = homePage.clickLoginSignUpButton();
            //Replace the username and password string with valid user details
            loginPage.enterUsername("enter a username");
            loginPage.enterPassword("enter a password");
            homePage = loginPage.clickLoginButton();
            //Select any of the categories and subcategory
            SubCategoryPage subCategoryPage = homePage.clickCategoryAndSub();
            //Use the search box, search for an item
            subCategoryPage.searchForAnItem("Drinks");
            SearchPage searchPage = subCategoryPage.clickSearchButton();
            //Click on the add to cart button
            searchPage.clickOnAddToCart(addToCartButtonID);
            //Click on the My Cart Menu
            AddToCartPage addToCartPage = searchPage.clickMyCartButton();
            //Increase the number of item to 4
            addToCartPage.itemCount(numberOfItems);
            //Click on checkout
            CheckOutPage checkOutPage = addToCartPage.clickCheckOut();
            //Select the Pay Now Option to activate the “Continue to Payment” button - the user must have preselected pick up method
            checkOutPage.clickOnPayNow();
            //Click on the “Continue to Payment” button
            checkOutPage.clickContinueToPayment();
            //Select the “CARD” payment method
            checkOutPage.clickOnPaymentType();
            //Input a wrong card number, date, CVV and pin
            checkOutPage.enterCardDetails("5334567822334456", "02/20", "254");
            //Print out the error message for the card number field.
            System.out.println(checkOutPage.invalid_message());
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}
