package utilities;

import browserfactory.BaseTest;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class Utility extends BaseTest {

    //click element method
   public void clickOnElement(By by){
     WebElement login=driver.findElement(by);
     login.click();

   }


    //    this method will send text to element
    public void sendTextToElement(By by, String text) {
        WebElement element = driver.findElement(by);
        element.sendKeys(text);
    }
//    will get text from element
    public String getTextFromElement(By by){
     return   driver.findElement(by).getText();
    }
//    Assert equals method
    public void asserEqualsMethod(String message,String actual,String expected){
       Assert.assertEquals(" ",expected,actual);
    }
//    verify the text
public void verifyElements(String expectedMessage, By by, String displayMessage)
{
    String actualMessage = getTextFromElement(by);
    Assert.assertEquals(displayMessage, expectedMessage, actualMessage);
}
    public void verifyText(By by,String expected){
       String actual=getTextFromElement(by);
       Assert.assertEquals("Error",actual,expected);
    }
//    method will select the option

    //     This method will send text to element
    public void sendKeysToElement(By by, CharSequence keys) {
        driver.findElement(by).sendKeys(keys);
    }

    // This method will clear text from field
    public void clearText(By by) {
        driver.findElement(by).sendKeys(Keys.CONTROL + "a");
//        driver.findElement(By by).sendKeys(Keys.DELETE);
    }
//    method will select the option that displayb the text matvching the parameter

    //This method will select by index number
    public void selectByIndexFromDropDown(By by, int index) {
        WebElement element = driver.findElement(by);
        Select select = new Select(element);
        select.selectByIndex(index);
    }

    //This method will select by visible text
    public void selectByVisibleTextFromDropDown(By by, String text) {
        WebElement dropDown = driver.findElement(by);
        Select select = new Select(dropDown);
        select.selectByVisibleText(text);
    }

    //This method will select by value
    public void selectByValueFromDropdown(By by, String value) {
        WebElement dropdown = driver.findElement(by);
        Select select = new Select(dropdown);
        select.selectByValue(value);
    }
    // This method will mouse hover and click the element

    public void mouseHoverAndClick(By by) {
        Actions actions = new Actions(driver);
        WebElement mouseHoover = driver.findElement(by);
        actions.moveToElement(mouseHoover).click().build().perform();
    }

    //    Mouse hover over an eelement and click
    public void mouseHoverOnElementAndClick(By by1 ,By by2) {
        Actions action = new Actions(driver);
        WebElement element1 = driver.findElement(by1);
        WebElement element2 = driver.findElement(by2);
        action.moveToElement(element1).moveToElement(element2).click().build().perform();

    }}



