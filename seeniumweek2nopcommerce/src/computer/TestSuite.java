package computer;

import basetest.BaseTest;
import com.google.common.base.Verify;
import org.checkerframework.checker.units.qual.A;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.Computer;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.w3c.dom.Text;

import java.awt.*;
import java.sql.SQLOutput;

public class TestSuite extends BaseTest {
    String baseurl="https://demo.nopcommerce.com/";
    @Before
    public void startTest(){
        openbrowser(baseurl);
    }
    @Test
    public void testname() throws InterruptedException {
//        1.1 Click on Computer Menu.
        driver.findElement(By.xpath("//div[@class='header-menu']/ul[1]/li[1]/a")).click();
//        1.2 Click on Desktop
        Thread.sleep(1000);
        driver.findElement(By.xpath("//div[@class='page-body']/div[1]/div[1]/div[1]/div/h2")).click();

//        1.3 Select Sort By position "Name: Z to A"
        WebElement dropdown = driver.findElement(By.xpath("//select[@id='products-orderby']"));
        Select selectDropdown = new Select(dropdown);
        Thread.sleep(1000);
        selectDropdown.selectByIndex(2);
    }
@Test
       public void verifyProductAddedToShoppingCartSuccessFully() throws InterruptedException {
//    2.1 Click on Computer Menu.
    driver.findElement(By.xpath("//div[@class='header-menu']/ul[1]/li[1]/a")).click();

//    2.2 Click on Desktop
    driver.findElement(By.xpath("//div[@class='page-body']/div[1]/div[1]/div[1]/div/h2")).click();

//    2.3 Select Sort By position "Name: A to Z"
    Thread.sleep(1000);
    WebElement dropdown = driver.findElement(By.xpath("//select[@id='products-orderby']"));
    Select selectDropdown = new Select(dropdown);
    Thread.sleep(1000);
    selectDropdown.selectByIndex(1);


//    2.4 Click on "Add To Cart"
    Thread.sleep(1000);
    driver.findElement(By.xpath("//div[@class='products-container']/div[2]/div/div/div[1]/div/div[2]/div[3]/div[2]/button[1]")).click();
//    2.5 Verify the Text "Build your own computer"
    Thread.sleep(1000);
    String actualtext1 = driver.findElement(By.xpath("//form[@id='product-details-form']/div[2]/div[1]/div[2]/div[1]/h1")).getText();

    System.out.println(actualtext1);
    Thread.sleep(1000);
    String expectedtext1 = "Build your own computer";
    Assert.assertEquals(actualtext1, expectedtext1);
//    2.6 Select "2.2 GHz Intel Pentium Dual-Core E2200" using Select class
    Thread.sleep(1000);
    WebElement selectprocessor = driver.findElement(By.xpath("//dd[@id='product_attribute_input_1']/select"));
    Thread.sleep(1000);
    Select selectpro = new Select(selectprocessor);
    selectpro.selectByIndex(1);
    Thread.sleep(1000);
//    2.7.Select "8GB [+$60.00]" using Select class.
    WebElement selectMemory = driver.findElement(By.xpath("//dd[@id='product_attribute_input_2']/select"));
    Select selectmemory1 = new Select(selectMemory);
    Thread.sleep(1000);
    selectmemory1.selectByIndex(3);
    Thread.sleep(1000);
//    2.8 Select HDD radio "400 GB [+$100.00]"
    Thread.sleep(1000);
    driver.findElement(By.xpath("//input[@id='product_attribute_3_7']")).click();
    Thread.sleep(1000);
//    2.9 Select OS radio "Vista Premium [+$60.00]"
    driver.findElement(By.xpath("//dd[@id='product_attribute_input_4']/ul/li[2]/input")).click();
//    A 2.10 Check Two Check boxes "Microsoft Office [+$50.00]" and "Total Commander

    driver.findElement(By.xpath("//dd[@id='product_attribute_input_5']/ul/li[1]/input")).isEnabled();
    Thread.sleep(1000);
    driver.findElement(By.xpath("//dd[@id='product_attribute_input_5']/ul/li[3]/input")).click();
//    2.11 Verify the price "$1,475.00
    Thread.sleep(1000);
    String actualPrice = driver.findElement(By.xpath("//span[@id='price-value-1']")).getText();
    System.out.println(actualPrice);
    Thread.sleep(1000);
    String expectedPrice = "$1,475.00";
    Assert.assertEquals(expectedPrice, actualPrice);
//    2.12 Click on "ADD TO CARD" Button.
    Thread.sleep(1000);
    driver.findElement(By.xpath("//button[@id='add-to-cart-button-1']")).click();
//    2.13 Verify the Message "The product has been added to your shopping cart" on Top
    Thread.sleep(1000);
    String actualPriceMessage = driver.findElement(By.xpath("//div[@class='bar-notification success']")).getText();
    System.out.println(actualPriceMessage);
    String expectedPriceMessage = "The product has been added to your shopping cart";
    Assert.assertEquals(actualPriceMessage, expectedPriceMessage);
//    After that close the bar clicking on the cross button.
    driver.findElement(By.xpath("//span[@class=\"close\"]")).click();
//    2.14 Then MouseHover on "Shopping cart" and Click on "GO TO CART" button.
    Actions actions = new Actions(driver);
    Thread.sleep(1000);
    WebElement shoppingCart = driver.findElement(By.xpath("//li[@id='topcartlink']"));
    Thread.sleep(1000);
    actions.moveToElement(shoppingCart).click().build().perform();
    Thread.sleep(1000);
//    2.15 Verify the message "Shopping cart"
    String actualShoppingMessage = driver.findElement(By.xpath("//div[@class='page-title']/h1")).getText();
    System.out.println(actualShoppingMessage);
    String wxpectedShoppingMessage = "Shopping cart";
    Assert.assertEquals(actualShoppingMessage, wxpectedShoppingMessage);
//
//    2.16 Change the Qty to "2" and Click on "Update shopping cart"
    Thread.sleep(1000);
    driver.findElement(By.xpath("//table[@class='cart']/tbody/tr/td[5]/input")).clear();
    Thread.sleep(1000);
    driver.findElement(By.xpath("//table[@class='cart']/tbody/tr/td[5]/input")).sendKeys("2");
    Thread.sleep(1000);
    driver.findElement(By.xpath("//div[@class='cart-options']/div[1]/button[1]")).click();
//    2.17 Verify the Total"$2,950.00"
    Thread.sleep(1000);
    String actualTotal = driver.findElement(By.xpath("//span[@class='product-subtotal']")).getText();
    System.out.println(actualTotal);
    String expectedTotal = "$2,950.00";
    Assert.assertEquals(actualTotal, expectedTotal);
//    2.18 click on checkbox “I agree with the terms of service”
    Thread.sleep(1000);
    driver.findElement(By.xpath("//input[@id='termsofservice']")).click();
//    2.19 Click on “CHECKOUT”
    Thread.sleep(1000);
    driver.findElement(By.xpath("//div[@class='checkout-buttons']/button")).click();
//    2.20 Verify the Text “Welcome, Please Sign In!”
    Thread.sleep(1000);
    String actualTextWelcome = driver.findElement(By.xpath("//div[@class='page-title']/h1")).getText();
    System.out.println(actualTextWelcome);
    String expectedTextWelcome = "Welcome, Please Sign In!";
    Assert.assertEquals(actualTextWelcome, expectedTextWelcome);
//    2.21Click on “CHECKOUT AS GUEST” Tab
    Thread.sleep(1000);
    driver.findElement(By.xpath("//div[@class='page-body']/div[1]/div[1]/div[3]/button[1]")).click();

    Thread.sleep(1000);
//2.22 Fill the all mandatory field
    //firstname
    driver.findElement(By.xpath("//div[@id='checkout-billing-load']/div[1]/div[2]/div/div/div[1]/input[1]")).sendKeys("Bhavini");
// last name
    driver.findElement(By.xpath("//div[@id='checkout-billing-load']/div[1]/div[2]/div/div/div[2]/input[1]")).sendKeys("patel");
    // Email
    driver.findElement(By.xpath("//div[@id='checkout-billing-load']/div[1]/div[2]/div/div/div[3]/input[1]")).sendKeys("bha123@gmail.com");
    //country
    WebElement country = driver.findElement(By.xpath("//div[@id='checkout-billing-load']/div[1]/div[2]/div/div[1]/div[5]/select"));
    Select select = new Select(country);
    select.selectByIndex(15);
//   city
    driver.findElement(By.xpath("//div[@id='checkout-billing-load']/div[1]/div[2]/div/div[1]/div[7]/input")).sendKeys("London");
//    Adress 1
    driver.findElement(By.xpath("//div[@id='checkout-billing-load']/div[1]/div[2]/div/div[1]/div[8]/input")).sendKeys("Borehamholt");
//    Zip/postal code
    driver.findElement(By.xpath("//div[@id='checkout-billing-load']/div[1]/div[2]/div/div[1]/div[10]/input")).sendKeys("Wd65yu");
//    phone
    driver.findElement(By.xpath("//div[@id='checkout-billing-load']/div[1]/div[2]/div/div[1]/div[11]/input")).sendKeys("23456789");


//2.23 Click on “CONTINUE”
    Thread.sleep(1000);
    driver.findElement(By.xpath("//div[@id='billing-buttons-container']/button[4]")).click();
////2.24 Click on Radio Button “Next Day Air($0.00)”
    driver.findElement(By.xpath("//input[@id='shippingoption_1']")).click();
////2.25 Click on “CONTINUE”
    driver.findElement(By.xpath("//button[@class='button-1 shipping-method-next-step-button']")).click();
////2.26 Select Radio Button “Credit Card”

    driver.findElement(By.xpath("//input[@id='paymentmethod_1']")).click();
    driver.findElement(By.xpath("//button[@name='save' and @class='button-1 payment-method-next-step-button']")).click();
////2.27 Select “Master card” From Select credit card dropdown
    Thread.sleep(1000);
    WebElement selectCard = driver.findElement(By.xpath("//select[@id='CreditCardType']"));
    Thread.sleep(1000);
    Select selectcards = new Select(selectCard);
    selectcards.selectByIndex(1);

////2.28 Fill all the details
//    cardholder name
    driver.findElement(By.xpath("//input[@id='CardholderName']")).sendKeys("Karishma");

//    Card number
    driver.findElement(By.xpath("//input[@id='CardNumber']")).sendKeys("5555 1234 1234");
//    Expiry Date(day)

    driver.findElement(By.xpath("//select[@id='ExpireMonth']")).sendKeys("11");
//    expiry year
    driver.findElement(By.xpath("//select[@id='ExpireYear']")).sendKeys("2026");

//    Card code
    driver.findElement(By.xpath("//input[@id='CardCode']")).sendKeys("435");
////2.29 Click on “CONTINUE”
    driver.findElement(By.xpath("//button[@class='button-1 payment-info-next-step-button']")).click();
    Thread.sleep(1000);
///2.30 Verify “Payment Method” is “Credit Card”
    String actuals = driver.findElement(By.xpath("//span[contains(text(),'Credit Card')]")).getText();
    System.out.println(actuals);

    String expects = "Credit Card";
    Assert.assertEquals(actuals, expects);
    Thread.sleep(1000);

//    2.32 Verify “Shipping Method” is “Next Day Air”

    String actual32 = driver.findElement(By.xpath("//li[@class='shipping-method']")).getText();
    System.out.println(actual32);
    String expected32 = "Shipping Method: Next Day Air";
    Thread.sleep(1000);
    Assert.assertEquals(actual32, expected32);


//    2.33 Verify Total is “$2,950.00”
    Thread.sleep(1000);
    String actual33 = driver.findElement(By.xpath("//table[@class='cart-total']/tbody/tr[4]/td[2]/span")).getText();

    String expected33 = "$2,950.00";
    Thread.sleep(1000);
    Assert.assertEquals(actual33, expected33);
//    2.34 Click on “CONFIRM”
    Thread.sleep(1000);
    driver.findElement(By.xpath("//div[@id='confirm-order-buttons-container']/button")).click();

//    2.35 Verify the Text “Thank You”
    Thread.sleep(1000);
    String actualText9 = driver.findElement(By.tagName("h1")).getText();
    System.out.println(actualText9);
    String expectedText9 = "Thank you";
    Thread.sleep(1000);
    Assert.assertEquals(actualText9, expectedText9);
//    2.36 Verify the message “Your order has been successfully processed!”

    Thread.sleep(2000);
    String actualTextcheck = driver.findElement(By.xpath("//div[@class='center-1']/div/div[2]/div[1]/div[1]/strong")).getText();
    System.out.println(actualTextcheck);
    String expectedTextcheck = "Your order has been successfully processed!";
    Thread.sleep(1000);
    Assert.assertEquals(actualTextcheck, expectedTextcheck);
//    2.37 Click on “CONTINUE”
    Thread.sleep(1000);
    driver.findElement(By.xpath("//button[@class='button-1 order-completed-continue-button']")).click();

//    2.37 Verify the text “Welcome to our store”
    Thread.sleep(1000);
    String actuallast = driver.findElement(By.xpath("//div[@class='topic-block-title']/h2")).getText();
    System.out.println(actuallast);

    String expectedlast = "Welcome to our store";
    Thread.sleep(1000);
    Assert.assertEquals(actuallast, expectedlast);
}

    @After
    public void endtest(){
     closebrowser();
    }
}
