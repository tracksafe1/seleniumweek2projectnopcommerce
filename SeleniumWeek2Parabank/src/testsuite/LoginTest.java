package testsuite;

import browserfactory.BaseTest;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class LoginTest extends BaseTest {
    String baseUrl = "https://parabank.parasoft.com/parabank/index.htm";

    @Before
    public void setUp() {
        openbrowser(baseUrl);
    }

    @Test
    public void userShouldLoginSuccessfullyWithValidCredentials() {
//        * Enter valid username
        WebElement username = driver.findElement(By.xpath("//div[@id=\"loginPanel\"]/form/div[1]/input"));
        username.sendKeys("shiv123");
//        * Enter valid password
        WebElement password = driver.findElement(By.xpath("//div[@id=\"loginPanel\"]/form/div[2]/input"));
        password.sendKeys("12345");
        //      * Click on Login button
        WebElement login = driver.findElement(By.xpath("//div[@id=\"loginPanel\"]/form/div[3]/input"));
        login.click();
//        * Verify the ‘Accounts Overview’ text is display
        String actualResult = driver.findElement(By.xpath("//div[@id=\"rightPanel\"]/div[1]/div[1]/h1")).getText();
        System.out.println(actualResult);
        String expectedResult = "Accounts Overview";
        Assert.assertEquals(actualResult, expectedResult);
    }

    @Test
    public void verifyTheErrorMessage() {
//      * Enter invalid username
        WebElement username = driver.findElement(By.xpath("//div[@id=\"loginPanel\"]/form/div[1]/input"));
        username.sendKeys("shiva");
//      * Enter invalid password
        WebElement password = driver.findElement(By.xpath("//div[@id=\"loginPanel\"]/form/div[2]/input"));
        password.sendKeys("2222");
        //      * Click on Login button
        WebElement login = driver.findElement(By.xpath("//div[@id=\"loginPanel\"]/form/div[3]/input"));
        login.click();
//      * Verify the error message ‘The username and password could not be verified.’
        String actualResult2= driver.findElement(By.xpath("//div[@id=\"rightPanel\"]/p")).getText();
        System.out.println(actualResult2);
        String expectedResult2 = "The username and password could not be verified.";
        Assert.assertEquals(actualResult2,expectedResult2);
    }
    @Test
    public void userShouldLogOutSuccessfully(){
//        * Enter valid username
        WebElement username = driver.findElement(By.xpath("//div[@id=\"loginPanel\"]/form/div[1]/input"));
        username.sendKeys("shiv1234");
//        * Enter valid password
        WebElement password = driver.findElement(By.xpath("//div[@id=\"loginPanel\"]/form/div[2]/input"));
        password.sendKeys("123456");
        //        * Click on ‘LOGIN’ button
        WebElement login = driver.findElement(By.xpath("//div[@id=\"loginPanel\"]/form/div[3]/input"));
        login.click();
//        * Click on ‘Log Out’ link
        WebElement logOut = driver.findElement(By.xpath("//div[@id=\"leftPanel\"]/ul/li[8]/a"));
        logOut.click();
//        * Verify the text ‘Customer Login’
        String actualResult3= driver.findElement(By.xpath("//div[@id=\"leftPanel\"]/h2")).getText();
        System.out.println(actualResult3);
        String expectedResult3 = "Customer Login";
        Assert.assertEquals(actualResult3,expectedResult3);
    }
    @After
    public void endTest(){
        closebrowser();
    }

    }
