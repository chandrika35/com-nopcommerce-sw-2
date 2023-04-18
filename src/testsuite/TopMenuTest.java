package testsuite;

import browserfactory.BaseTest;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;

public class TopMenuTest extends BaseTest {
    String baseUrl = "https://demo.nopcommerce.com/";

    @Before
    public void setUp() {

        openBrowser(baseUrl);
    }
    @Test
       public void  userShouldNavigateToComputerPageSuccessfully(){
driver.findElement(By.xpath("//a[text()='Computers ']")).click();
              }
public void userShouldNavigateToElectronicsPageSuccessfully(){
driver.findElement(By.linkText("Electronics")).click();
}
public void userShouldNavigateToApparelPageSuccessfully(){
driver.findElement(By.linkText(" Apparel ")).click();
}
    public void userShouldNavigateToDigitalDownloadsPageSuccessfully(){
driver.findElement(By.linkText(" Digital downloads ")).click();
    }
    public void userShouldNavigateToBooksPageSuccessfully(){
driver.findElement(By.linkText("Books")).click();
    }
    public void userShouldNavigateToGiftCardsPageSuccessfully(){
driver.findElement(By.linkText("Gift Cards ")).click();
    }
    @After
    public void tearDown() {
        closeBrowser();
    }
        }





