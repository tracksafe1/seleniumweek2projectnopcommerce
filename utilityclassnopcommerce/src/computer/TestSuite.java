package computer;

import com.google.common.base.Verify;
import org.checkerframework.checker.units.qual.A;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.Computer;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.w3c.dom.Text;
import utilities.Utility;

import java.awt.*;
import java.sql.ClientInfoStatus;
import java.util.ArrayList;
import java.util.List;

public class TestSuite extends Utility {
    String baseUrl = "https://demo.nopcommerce.com/";

    @Before
    public void startTest() {
        openBrowser(baseUrl);
    }




    @Test
    public void testName() throws InterruptedException {
//                1.1 Click on Computer Menu.
        clickOnElement(By.xpath("//ul[@class='top-menu notmobile']/li[1]/a"));
        Thread.sleep(1000);
//                1.2 Click on Desktop
        clickOnElement(By.partialLinkText("Desktops"));
//                1.3 Select Sort By position "Name: Z to A"
        selectByIndexFromDropDown(By.xpath("//select[@id=\"products-orderby\"]"), 2);
//                1.4 Verify the Product will arrange in Descending order.
        verifyText(By.xpath("//select[@id='products-orderby']/option[3]"), "Name: Z to A");

    }

    @Test
//                1.1 Click on Computer Menu.
    public void verifyProductAddedToShoppingCartSuccessFully() throws InterruptedException {
//                    2.1 Click on Computer Menu.
        clickOnElement(By.xpath("//ul[@class='top-menu notmobile']/li[1]/a"));
        Thread.sleep(1000);
//                    2.2 Click on Desktop
        clickOnElement(By.partialLinkText("Desktops"));
//               2.3 Select Sort By position "Name: A to z"
        selectByIndexFromDropDown(By.xpath("//select[@id=\"products-orderby\"]"), 1);
//         2.4 Click on "Add To Cart"
        Thread.sleep(2000);
        clickOnElement(By.xpath("//div[@class='products-container']/div[2]/div[1]/div[1]/div[1]/div[1]/div[2]/div[3]/div[2]/button[1]"));
//            2.5 Verify the Text "Build your own computer"
        verifyText(By.xpath("//h1[contains(text(),'Build your own computer')]"), "Build your own computer");
//            2.6 Select "2.2 GHz Intel Pentium Dual-Core E2200" using Select class
        Thread.sleep(1000);
        selectByIndexFromDropDown(By.xpath("//select[@id='product_attribute_1']"), 1);
//2.7.Select "8GB [+$60.00]" using Select class.
        Thread.sleep(1000);
        selectByIndexFromDropDown(By.xpath("//select[@id='product_attribute_2']"), 3);
//            2.8 Select HDD radio "400 GB [+$100.00]"
        Thread.sleep(1000);
        clickOnElement(By.xpath("//input[@id=\"product_attribute_3_7\"]"));
//            2.9 Select OS radio "Vista Premium [+$60.00]"
        Thread.sleep(1000);
        clickOnElement(By.xpath("//input[@id=\"product_attribute_4_9\"]"));
//    A 2.10 Check Two Check boxes "Microsoft Office [+$50.00]" and "Total Commander
//            [+$5.00]"
        Thread.sleep(1000);
        driver.findElement(By.xpath("//input[@id=\"product_attribute_5_10\"]")).isEnabled();
        Thread.sleep(1000);
        clickOnElement(By.xpath("//input[@id=\"product_attribute_5_12\"]"));
        Thread.sleep(1000);
//                    2.11 Verify the price "$1,475.00"
        Thread.sleep(1000);
        verifyText(By.xpath("//span[@id='price-value-1']"), "$1,475.00");
//                    2.12 Click on "ADD TO CARD" Button.
        Thread.sleep(1000);
        clickOnElement(By.xpath("//button[@id='add-to-cart-button-1']"));

//                    2.13 Verify the Message "The product has been added to your shopping cart" on Top
//                    green Bar
        Thread.sleep(1000);
        verifyText(By.xpath("//div[@class='bar-notification success']"), "The product has been added to your shopping cart");

//                   After that close the bar clicking on the cross button.
        clickOnElement(By.xpath("//span[@class='close']"));
//                    2.14 Then MouseHover on "Shopping cart" and Click on "GO TO CART" button.
        Thread.sleep(1000);
        mouseHoverAndClick(By.xpath("//li[@id='topcartlink']"));
//                    Thread.sleep(2000);
//                    clickOnElement(By.xpath("//button[@class=\"button-1 cart-button\"]"));
//                    2.15 Verify the message "Shopping cart"
        Thread.sleep(1000);
        verifyText(By.xpath("//div[@class='page-title']/h1"), "Shopping cart");
//                    2.16 Change the Qty to "2" and Click on "Update shopping cart"
        driver.findElement(By.xpath("//table[@class='cart']/tbody/tr/td[5]/input")).clear();
        sendTextToElement(By.xpath("//table[@class='cart']/tbody/tr/td[5]/input"), "2");
//                    2.17 Verify the Total"$2,950.00"
        Thread.sleep(2000);
//                    verifyText(By.xpath("//table[@class=\"cart-total\"]/tbody/tr[4]/td[2]/span[1]/strong"),"$2,950.00");
//                    2.18 click on checkbox “I agree with the terms of service”
        Thread.sleep(1000);
        clickOnElement(By.xpath("//input[@id='termsofservice']"));
//                    2.19 Click on “CHECKOUT”
        clickOnElement(By.xpath("//div[@class='checkout-buttons']/button"));
//                    2.20 Verify the Text “Welcome, Please Sign In!”
        Thread.sleep(1000);
        verifyText(By.xpath("//div[@class='page-title']/h1"), "Welcome, Please Sign In!");
//                    2.21Click on “CHECKOUT AS GUEST” Tab
        Thread.sleep(1000);
        clickOnElement(By.xpath("//div[@class='page-body']/div[1]/div[1]/div[3]/button[1]"));
//                    2.22 Fill the all mandatory field
        //first name
        sendTextToElement(By.xpath("//div[@id='checkout-billing-load']/div[1]/div[2]/div/div/div[1]/input[1]"), "sam");
//                    // last name
        sendTextToElement(By.xpath("//div[@id='checkout-billing-load']/div[1]/div[2]/div/div/div[2]/input[1]"), "Kap");
        //email
        sendTextToElement(By.xpath("//div[@id='checkout-billing-load']/div[1]/div[2]/div/div/div[3]/input[1]"), "sam@gmail.com");
//                    country
        selectByValueFromDropdown(By.xpath("//div[@id='checkout-billing-load']/div[1]/div[2]/div/div[1]/div[5]/select"), "15");
        // city
        sendKeysToElement(By.xpath("//div[@id='checkout-billing-load']/div[1]/div[2]/div/div[1]/div[7]/input"), "London");
        // address
        sendKeysToElement(By.xpath("//div[@id='checkout-billing-load']/div[1]/div[2]/div/div[1]/div[8]/input"), "braham avenue");
        // zip postal code
        sendKeysToElement(By.xpath("//div[@id='checkout-billing-load']/div[1]/div[2]/div/div[1]/div[10]/input"), "WD43YG");
        //phone no
        sendKeysToElement(By.xpath("//div[@id='checkout-billing-load']/div[1]/div[2]/div/div[1]/div[11]/input"), "123456789");
//                    2.23 Click on “CONTINUE”
        clickOnElement(By.xpath("//div[@id='billing-buttons-container']/button[4]"));
//                    2.24 Click on Radio Button “Next Day Air($0.00)”
        clickOnElement(By.xpath("//input[@id='shippingoption_1']"));
//                    2.25 Click on “CONTINUE”
        clickOnElement(By.xpath("//button[@class='button-1 shipping-method-next-step-button']"));
//                    2.26 Select Radio Button “Credit Card”
        clickOnElement(By.xpath("//input[@id='paymentmethod_1']"));
        clickOnElement(By.xpath("//button[@name='save' and @class='button-1 payment-method-next-step-button']"));
//                    2.27 Select “Master card” From Select credit card dropdown
        selectByIndexFromDropDown(By.xpath("//select[@id='CreditCardType']"), 1);
//                    2.28 Fill all the details
//                    cardholder name
        sendKeysToElement(By.xpath("//input[@id='CardholderName']"), "Karishma");
        // card number
        sendTextToElement(By.xpath("//input[@id='CardNumber']"), "5555 1111 2222");
        //expiry date
        sendTextToElement(By.xpath("//select[@id='ExpireMonth']"), "11");
        //expiry year
        sendTextToElement(By.xpath("//select[@id='ExpireYear']"), "2025");
        //card code
        sendTextToElement(By.xpath("//input[@id='CardCode']"), "100");
//                    2.29 Click on “CONTINUE”
        clickOnElement(By.xpath("//button[@class='button-1 payment-info-next-step-button']"));
//                    2.30 Verify “Payment Method” is “Credit Card”
        verifyElements("Credit Card", By.xpath("//span[contains(text(),'Credit Card')]"), "not a valid card");
//                    2.32 Verify “Shipping Method” is “Next Day Air”
        Thread.sleep(1000);
        verifyElements("Shipping Method: Next Day Air", By.xpath("//li[@class='shipping-method']"), "shipping method is not next day");
//                    2.33 Verify Total is “$2,950.00”
        Thread.sleep(2000);
//                   verifyElements("$2,950.00",By.xpath("//table[@class='cart-total']/tbody/tr[4]/td[2]/span"),"Total is not £ 2950");
//                    2.34 Click on “CONFIRM”
        clickOnElement(By.xpath("//div[@id='confirm-order-buttons-container']/button"));
//                    2.35 Verify the Text “Thank You”
        Thread.sleep(2000);
        verifyElements("Thank you", By.tagName("h1"), "Thank you is not displayed");
//                 2.37 Click on “CONTINUE”
        clearText(By.xpath("//button[@class='button-1 order-completed-continue-button']"));
//                    2.37 Verify the text “Welcome to our store”
    }

    @After
    public void endTest() {
//                closeBrowser();
    }

}
