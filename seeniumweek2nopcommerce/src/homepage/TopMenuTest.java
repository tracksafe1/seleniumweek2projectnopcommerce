package homepage;

import basetest.BaseTest;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class TopMenuTest extends BaseTest {
    String baseurl="https://demo.nopcommerce.com/";
//    create method with name "selectMenu" it has one parameter name "menu" of type String
    public void selectMenu(String menu){

        WebElement elements= driver.findElement(By.xpath(menu));
        elements.click();
    }

   @Before
   public void startTest(){
       openbrowser(baseurl);
   }
@Test
public void verifyPageNavigation(){
     selectMenu("//div[@class='master-wrapper-page']/div[2]");
}
@After
public void closetest(){
    closebrowser();
}}


