package hoverCategoryAndClickSubcategoryPageTest;

import base.BasePage;
import org.testng.annotations.Test;

public class HoverAndClickSubcategoryTest extends BasePage {

    @Test(priority = 2)
    public void testHoverAndClickSubcategory() throws InterruptedException
    {
        //Select any of the categories and subcategory
        homePage.mouseHoverOnACategory();
        homePage.clickOnASubCategory();
    }
}
