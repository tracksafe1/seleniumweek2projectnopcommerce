package homepage;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.Utility;

import java.awt.*;
import java.util.List;

public class TopMenuTest extends Utility {
    String baseurl = "https://demo.nopcommerce.com/";

    @Before
    public void StartTest() {
        openBrowser(baseurl);
    }
//
//     1.1 create method with name "selectMenu" it has one parameter name "menu" of type string
//1.2 This method should click on the menu whatever name is passed as parameter.
    public void selectMenu(String menu) throws InterruptedException {
     List<WebElement> selection= driver.findElements(By.xpath("//ul[@class='top-menu notmobile']/li"));
      for(WebElement selection1:selection){
          if(selection1.getText().equalsIgnoreCase(menu)){
              Thread.sleep(2000);
              selection1.click();
              break;
          }
      }
    }


    @Test
    public void verifyComputersPageNavigation() throws InterruptedException {

        selectMenu("Computers");//1.1 method

        //verification using assertion
        verifyElements("Computers", By.partialLinkText("Computers"), "User has not navigated to the Computers Page");

    }



    //1.3. create the @Test
//    method name verifyPageNavigation.use selectMenu method to
//    select the Menu and click on it and verify the page navigation.
    @Test
    public void verifyElectronicPageNavigation() throws InterruptedException {

        selectMenu("Electronics");
        verifyElements("Electronics", By.partialLinkText("Electronics"), "User has not navigated to the Electronics Page");
        Thread.sleep(1000);


    }

    @Test
    public void verifyBooksPageNavigation() throws InterruptedException {
        selectMenu("Books");
        verifyElements("Books", By.partialLinkText("Books"), "User has not navigated to the Books Page");
        Thread.sleep(1000);

    }
@Test
public void verifycomputerPageNavigation() throws InterruptedException {
    selectMenu("Computers");
    verifyElements("Computers", By.partialLinkText("Computers"), "User has not navigated to the Computers Page");

    }

    @Test
    public void verifyJewelryPageNavigation() throws InterruptedException {
        selectMenu("Jewelry");
        verifyElements("Jewelry", By.partialLinkText("Jewelry"), "User has not navigated to the Jewelry  Page");



    }


      @Test
        public void verifyApparelPageNavigation() throws InterruptedException {
        selectMenu("Apparel");
        verifyElements("Apparel", By.partialLinkText("Apparel"),"User is not navigated toApparel page");

      }

    @After
    public void endTest() {
       closeBrowser();
    }
}