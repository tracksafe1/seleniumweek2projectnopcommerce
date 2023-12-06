package electronics;

import basetest.BaseTest;
import com.google.common.base.Verify;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.awt.*;

public class ElectronicsTest extends BaseTest {
    String baseurl="https://demo.nopcommerce.com/";
    @Before
    public void startTest(){
        openbrowser(baseurl);
    }
    @Test
    public  void  textVerified() throws InterruptedException {

//1.1 Mouse Hover on “Electronics” Tab
        Actions action=new Actions(driver);
        WebElement electronicsHover=driver.findElement(By.linkText("Electronics"));
        action.moveToElement(electronicsHover).click().build().perform();

//1.2 Mouse Hover on “Cell phones” and click
        Actions actions =new Actions(driver);
        WebElement cellphonehover=driver.findElement(By.linkText("Cell phones"));
        actions.moveToElement(cellphonehover).click().click().perform();
//1.3 Verify the text “Cell phones”
        Thread.sleep(1000);
        String actualtextCellPhone=driver.findElement(By.xpath("//h1[contains(text(),'Cell phones')]")).getText();
        System.out.println(actualtextCellPhone);
        String expectedtextCellPhone="Cell phones";
        Assert.assertEquals(actualtextCellPhone,expectedtextCellPhone);

    }
    @Test
            public void verifyThatTheProductAddedSuccessfullyAndPlaceOrderSuccessfully() throws InterruptedException {
//    2.1 Mouse Hover on “Electronics” Tab
        Actions action = new Actions(driver);
        WebElement electronicsHover = driver.findElement(By.linkText("Electronics"));
        action.moveToElement(electronicsHover).click().build().perform();

//2.2 Mouse Hover on “Cell phones” and click
        Actions actions =new Actions(driver);
        WebElement cellphonehover=driver.findElement(By.linkText("Cell phones"));
        actions.moveToElement(cellphonehover).click().click().perform();

//2.3 Verify the text “Cell phones”
        Thread.sleep(2000);
        String actualtextCellPhone=driver.findElement(By.xpath("//h1[contains(text(),'Cell phones')]")).getText();
        System.out.println(actualtextCellPhone);
        String expectedtextCellPhone="Cell phones";
        Assert.assertEquals(actualtextCellPhone,expectedtextCellPhone);

//        2.4 Click on List View
        driver.findElement(By.xpath("//div[@class='page-body']/div[1]/div[1]/a[2]")).click();
        Thread.sleep(2000);
//        2.5 Click on product name “Nokia Lumia 1020” link
        Thread.sleep(2000);
        driver.findElement(By.xpath("//div[@class='item-grid']/div[3]/div/div[2]/h2/a")).click();
//        2.6 Verify the text “Nokia Lumia 1020”
       Thread.sleep(2000);
        Thread.sleep(1000);
        String actualText1 = driver.findElement(By.tagName("h1")).getText();
        System.out.println(actualText1);
        String expectedResult1 ="Nokia Lumia 1020";
        Assert.assertEquals(actualText1,expectedResult1);
//
//       2.7 Verify the price “$349.00”
        Thread.sleep(2000);
        String actualPrice=driver.findElement(By.xpath("//div[@class='product-essential']/div[2]/div[5]/div[1]")).getText();
        String expectedPrice="$349.00";
        Assert.assertEquals(actualPrice,expectedPrice);
//        2.8 Change quantity to 2
        Thread.sleep(2000);
        driver.findElement(By.xpath("//input[@id='product_enteredQuantity_20']")).clear();
        driver.findElement(By.xpath("//input[@id='product_enteredQuantity_20']")).sendKeys("2");
//        2.9 Click on “ADD TO CART” tab
         driver.findElement(By.xpath("//button[@id='add-to-cart-button-20']")).click();
//        2.10 Verify the Message "The product has been added to your shopping cart" on Top
//        green Bar
        Thread.sleep(2000);
        Thread.sleep(1000);
        String actualPriceMessage = driver.findElement(By.xpath("//div[@class='bar-notification success']")).getText();
        System.out.println(actualPriceMessage);
        String expectedPriceMessage = "The product has been added to your shopping cart";
        Assert.assertEquals(actualPriceMessage, expectedPriceMessage);
//        After that close the bar clicking on the cross button.
        driver.findElement(By.xpath("//span[@class=\"close\"]")).click();
//        2.11 Then MouseHover on "Shopping cart" and Click on "GO TO CART" button.
        Actions actions2 = new Actions(driver);
        Thread.sleep(1000);
        WebElement shoppingCart = driver.findElement(By.xpath("//li[@id='topcartlink']"));
        Thread.sleep(1000);
        actions2.moveToElement(shoppingCart).click().build().perform();
//
//        2.12 Verify the message "Shopping cart"
        String actualShoppingMessage = driver.findElement(By.xpath("//div[@class='page-title']/h1")).getText();
        System.out.println(actualShoppingMessage);
        String wxpectedShoppingMessage = "Shopping cart";
        Thread.sleep(1000);
        Assert.assertEquals(actualShoppingMessage, wxpectedShoppingMessage);
//        2.13 Verify the quantity is 2
        Thread.sleep(3000);
        String actualQuantity=driver.findElement(By.xpath("//div[@class='order-summary-content']/form/div[1]/table/tbody/tr/td[5]/input[1]")).getText();
        Thread.sleep(1000);
        System.out.println(actualQuantity);
//        String expectedQuantity="2";
//        Thread.sleep(1000);
//        Assert.assertEquals(actualQuantity,expectedQuantity);

//      2.15 click on checkbox “I agree with the terms of service”
        Thread.sleep(1000);
        driver.findElement(By.id("termsofservice")).click();

//2.16 Click on checkout
        Thread.sleep(1000);
        driver.findElement(By.id("checkout")).click();
//      2.17 Verify the Text “Welcome, Please Sign In!”
        Thread.sleep(1000);
        String actualResult8 = driver.findElement(By.tagName("h1")).getText();
        System.out.println(actualResult8);
        String expectedTesult8= "Welcome, Please Sign In!";
        Assert.assertEquals(actualResult8,expectedTesult8);
//      2.18 Click on “REGISTER” tab
        driver.findElement(By.xpath("//div[@class='customer-blocks']/div[1]/div[3]/button[2]")).click();
//        2.19 Verify the text “Register”
        Thread.sleep(1000);
        String actualResult9 = driver.findElement(By.tagName("h1")).getText();
        System.out.println(actualResult9);
        String expectedResult9= "Register";
        Assert.assertEquals(actualResult9,expectedResult9);
//        2.20 Fill the mandatory fields
        Thread.sleep(1000);
        driver.findElement(By.id("FirstName")).sendKeys("Karishma");
        driver.findElement(By.id("LastName")).sendKeys("Kap");
        driver.findElement(By.id("Email")).sendKeys("karish@gmail.com");
        driver.findElement(By.id("Password")).sendKeys("123456");
        driver.findElement(By.id("ConfirmPassword")).sendKeys("123456");
//        2.21 Click on “REGISTER”Button
        driver.findElement(By.id("register-button")).click();
//        2.22 Verify the message “Your registration completed”
        Thread.sleep(1000);
        String actualResult10 = driver.findElement(By.xpath("//div[@class='master-wrapper-page']/div[3]/div[1]/div[1]/div/div[2]/div[1]")).getText();
        System.out.println(actualResult10);
        String expectedResult10= "Your registration completed";
        Assert.assertEquals(actualResult10,expectedResult10);
//        2.23 Click on “CONTINUE” tab
        Thread.sleep(1000);
        driver.findElement(By.xpath("//div[@class='buttons']/a")).click();
//        2.24 Verify the text “Shopping cart”
        Thread.sleep(1000);
        String actualResult11 = driver.findElement(By.xpath("//div[@class='page-title']/h1")).getText();
        System.out.println(actualResult11);
        String expectedResult11= "Shopping cart";
        Assert.assertEquals(actualResult11,expectedResult11);
//        2.25 click on checkbox “I agree with the terms of service”
        Thread.sleep(1000);
        driver.findElement(By.id("termsofservice")).click();
//        2.26 Click on “CHECKOUT”
        Thread.sleep(1000);
        driver.findElement(By.id("checkout")).click();
//       2.27 Select “Master card” From Select credit card dropdown
    }
    @After
    public  void endTest(){
        closebrowser();
    }
}
