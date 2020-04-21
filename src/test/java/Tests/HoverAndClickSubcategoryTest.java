package Tests;

import base.BasePage;
import org.testng.annotations.Test;

public class HoverAndClickSubcategoryTest extends LoginTest {

    @Test(dependsOnMethods = {"testLoginPage"})
    public void testHoverAndClickSubcategory() throws InterruptedException
    {
        //Select any of the categories and subcategory
        homePage.mouseHoverOnACategory();
        homePage.clickOnASubCategory();
    }
}
