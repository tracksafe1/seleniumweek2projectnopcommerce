package electronics;

import com.google.common.base.Verify;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.Computer;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;
import org.w3c.dom.Text;
import utilities.Utility;

import java.awt.*;

public class ElectronicsTest extends Utility {
    String baseurl="https://demo.nopcommerce.com/";
    String email="Karishma11@gmail.com";
    @Before
    public void startTest(){
        openBrowser(baseurl);
    }
    public void login() throws InterruptedException {
       clickOnElement(By.xpath("//div[@class='header-links']/ul/li[2]/a"));
        sendTextToElement(By.xpath("//input[@class=\"email\"]"), email);
        sendTextToElement((By.id("Password")), "123456");
        Thread.sleep(1000);
        clickOnElement(By.xpath("//button[@class='button-1 login-button']"));
      mouseHoverOnElementAndClick(By.xpath("//span[contains(text(),'Shopping cart')]"),By.xpath("//button[contains(text(),'Go to cart')]"));
    }
    @Test
    public void  textverified() throws InterruptedException {
//        1.1 Mouse Hover on “Electronics” Tab
//        1.2 Mouse Hover on “Cell phones” and click

        mouseHoverOnElementAndClick(By.xpath("//ul[@class=\"top-menu notmobile\"]/li[2]"),By.xpath("//ul[@class=\"top-menu notmobile\"]/li[2]/ul/li[2]"));
//        1.3 Verify the text “Cell phones”

        verifyElements("Cell phones",By.xpath("//h1[contains(text(),'Cell phones')]"),"Not verified");
    }
    @Test
    public void verifyThatTheProductAddedSuccessfullyAndPlaceOrderSuccessfully() throws InterruptedException {
//        2.1 Mouse Hover on “Electronics” Tab
//        2.2 Mouse Hover on “Cell phones” and click
//        2.3 Verify the text “Cell phones”
        mouseHoverOnElementAndClick(By.xpath("//ul[@class=\"top-menu notmobile\"]/li[2]"),By.xpath("//ul[@class=\"top-menu notmobile\"]/li[2]/ul/li[2]"));
        verifyElements("Cell phones",By.xpath("//h1[contains(text(),'Cell phones')]"),"Not verified");
//        2.4 Click on List View Tab
        clickOnElement(By.xpath("//div[@class='page-body']/div[1]/div[1]/a[2]"));
//        2.5 Click on product name “Nokia Lumia 1020” link
        Thread.sleep(2000);
        clickOnElement(By.xpath("//div[@class='item-grid']/div[3]/div/div[2]/h2/a"));
//        2.6 Verify the text “Nokia Lumia 1020”
        Thread.sleep(3000);
        verifyElements("Nokia Lumia 1020",By.tagName("h1"),"not matched");
        verifyElements( "$349.00",By.xpath("//div[@class='product-essential']/div[2]/div[5]/div[1]"),"Price  is not £349");
//        2.8 Change quantity to 2
        driver.findElement(By.xpath("//input[@id='product_enteredQuantity_20']")).clear();
        sendTextToElement(By.xpath("//input[@id='product_enteredQuantity_20']"),"2");
//        2.9 Click on “ADD TO CART” tab
        clickOnElement(By.xpath("//button[@id='add-to-cart-button-20']"));
//        2.10 Verify the Message "The product has been added to your shopping cart" on Top
//        green Bar
        verifyElements("The product has been added to your shopping cart",By.xpath("//div[@class='bar-notification success']"),"product is not added to shopping cart");
//        After that close the bar clicking on the cross button.
clickOnElement(By.xpath("//span[@class=\"close\"]"));
//        2.11 Then MouseHover on "Shopping cart" and Click on "GO TO CART" button.
        Thread.sleep(1000);
mouseHoverAndClick(By.xpath("//li[@id='topcartlink']"));
        Thread.sleep(2000);
//        2.12 Verify the message "Shopping cart"

    verifyElements("Shopping cart",By.xpath("//div[@class='master-column-wrapper']/div/div/div[1]"),"shopping cart is not written");

//        2.13 Verify the quantity is 2 and Total $698.00
//        verifyElements("$698.00",By.xpath("//td[@class=\"subtotal\"]/span[1]"),"quantity is not 2");
    Thread.sleep(3000);
//        2.15 click on checkbox “I agree with the terms of service
        driver.findElement(By.xpath("//input[@id='termsofservice']")).click();


//        2.16 Click on checkout
        Thread.sleep(1000);
        clickOnElement(By.id("checkout"));
////
//      2.17 Verify the Text “Welcome, Please Sign In!”
        Thread.sleep(1000);
//       verifyText(By.xpath("//h1"),"\"Welcome, Please Sign In!\"");

//        2.18 Click on “REGISTER” tab
         clickOnElement(By.xpath("//button[@class=\"button-1 register-button\"]"));
////        2.19 Verify the text “Register”
   Thread.sleep(2000);
       verifyText(By.xpath("//div[@class=\"page-title\"]/h1"),"Register");
////        2.20 Fill the mandatory field
//        //first name
        sendKeysToElement(By.id("FirstName"),"Karishma");
//        //last name
      sendKeysToElement(By.id("LastName"),"kapur");
//        //email
        sendTextToElement(By.xpath("//div[@class='page-body']/form/div[1]/div[2]/div[5]/input"),email);
//         //password
       sendTextToElement(By.id("Password"),"123456");
//        //confirm password
        sendTextToElement(By.id("ConfirmPassword"),"123456");
////        2.21 Click on “REGISTER” Button
        clickOnElement(By.id("register-button"));
//        2.22 Verify the message “Your registration completed”
        verifyText(By.xpath("//div[@class='center-1']/div/div[2]/div[1]"),"Your registration completed");
//        2.23 Click on “CONTINUE” tab
        clickOnElement(By.xpath("//div[@class='buttons']/a"));

//        2.24 Verify the text “Shopping cart” and then login again
        verifyText(By.xpath("//div[@class='page-title']/h1"),"Shopping cart");
        Thread.sleep(2000);
        login();
//        2.25 click on checkbox “I agree with the terms of service”
        clickOnElement(By.xpath("//input[@id='termsofservice']"));
//        2.26 Click on “CHECKOUT”
        clickOnElement(By.xpath("//button[@id='checkout']"));
//        2.27 Fill the Mandatory fields
Thread.sleep(2000);
        selectByIndexFromDropDown(By.xpath("//div[@class='edit-address']/div[5]/select"),5);
        Thread.sleep(1000);
sendTextToElement(By.xpath("//input[@id=\"BillingNewAddress_City\"]"),"London");
sendTextToElement(By.xpath("//div[@class='edit-address']/div[8]/input"),"Barham Avenue");
sendTextToElement(By.xpath("//div[@class='edit-address']/div[10]/input"),"WD63QJ");
sendTextToElement(By.xpath("//div[@class='edit-address']/div[11]/input"),"123456789");
//        2.28 Click on “CONTINUE”
        clickOnElement(By.xpath("//div[@id='billing-buttons-container']/button[4]"));
//        2.29 Click on Radio Button “2nd Day Air ($0.00)”
        clickOnElement(By.xpath("//input[@id='shippingoption_2']"));
//        2.30 Click on “CONTINUE”
        clickOnElement(By.xpath("//button[@class='button-1 shipping-method-next-step-button']"));
//        2.31 Select Radio Button “Credit Card”
clickOnElement(By.xpath("//div[@class='section payment-method']/ul/li[2]/div/div[2]/input"));
clickOnElement(By.xpath("//div[@id='payment-method-buttons-container']/button"));
//        2.32 Select “Visa” From Select credit card dropdown
selectByIndexFromDropDown(By.id("CreditCardType"),0);
//        2.33 Fill all the details

     //   cardholder name
        sendKeysToElement(By.xpath("//input[@id='CardholderName']"), "Karishma");
        // card number
        sendTextToElement(By.xpath("//input[@id='CardNumber']"), "5555 1111 2222");
        //expiry date
        sendTextToElement(By.xpath("//select[@id='ExpireMonth']"), "11");
        //expiry year
        sendTextToElement(By.xpath("//select[@id='ExpireYear']"), "2025");
        //card code
        sendTextToElement(By.xpath("//input[@id='CardCode']"), "100");

//        2.34 Click on “CONTINUE”CHECKOUT”
clickOnElement(By.xpath("//div[@id='payment-info-buttons-container']/button"));
//        2.35 Verify “Payment Method” is “Credit Card”
        verifyText(By.xpath("//div[@class='payment-method-info']/ul/li/span[2]"),"Credit Card");
//        2.36 Verify “Shipping Method” is “2nd Day Air”
        verifyText(By.xpath("//li[@class='shipping-method']"),"Shipping Method: 2nd Day Air");
//        2.37 Verify Total is “$698.00”
        verifyText(By.xpath("//table[@class='cart-total']/tbody/tr[4]/td[2]"),"$698.00");
//        2.38 Click on “CONFIRM”
        clickOnElement(By.xpath("//button[@class=\"button-1 confirm-order-next-step-button\"]"));
//        2.39 Verify the Text “Thank You”
        Thread.sleep(1000);
        verifyText(By.xpath("//h1[contains(text(),'Thank you')]"),"Thank you");
//        2.40 Verify the message “Your order has been successfully processed!”
//        verifyText(By.xpath("//div[@class='section order-completed']/div/strong"),"Your order has been successfully processed!");

//        2.41 Click on “CONTINUE”
        clickOnElement(By.xpath("//div[@class='page-body checkout-data']/div/div[3]/button"));
//        2.42 Verify the text “Welcome to our store”
        verifyText(By.xpath("//div[@class='topic-block-title']/h2"),"Welcome to our store");
//        2.43 Click on “Logout” link
        clickOnElement(By.className("ico-logout"));
//        2.44 Verify the URL is “https://demo.nopcommerce.com/”

    }
    @After
    public void endTest(){
//        closeBrowser();
    }
}
