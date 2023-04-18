package testsuite;

import browserfactory.BaseTest;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class LoginTest extends BaseTest {
    String baseUrl = "https://demo.nopcommerce.com/";

    @Before
    public void setUp() {

        openBrowser(baseUrl);
    }

    @Test
    public void verifyUserShouldNavigateLoginPageSuccessfully() {
        //find login link and click on login link
        WebElement loginLink = driver.findElement(By.linkText("Log in"));
        loginLink.click();
        String expectedMessage = "Welcome, Please Sign In!";
        WebElement actualTextElement = driver.findElement(By.xpath("//h1[contains(text(), 'Welcome, Please Sign In!')]"));
        //your xpath you actual
        String actualMessage = actualTextElement.getText();//Getting the text of element
        Assert.assertEquals("Not Redirected to Login Page", expectedMessage, actualMessage);
        //System.out.println("Page Title : " + driver.getTitle());
    }

    @Test
    public void verifyUserShouldLoginSuccessfullyWithValidCredentials() {
        WebElement loginLink = driver.findElement(By.linkText("Log in"));
        loginLink.click();
        WebElement emailField = driver.findElement(By.id("Email"));
        emailField.sendKeys(("sitaram123@gmail.com"));
        driver.findElement(By.name("Password")).sendKeys("sitaram123");
        WebElement loginBtn = driver.findElement(By.xpath("//button[contains(text(),'Log in')]"));
        loginBtn.click();

    }

    @Test
    public void verifyErrorMessageWithInvalidCredentials() {
        WebElement loginLink = driver.findElement(By.linkText("Log in"));
        loginLink.click();
        WebElement emailField = driver.findElement(By.id("Email"));
        emailField.sendKeys(("sitaram123@gmail.com"));
        driver.findElement(By.name("Password")).sendKeys("Sitaram123");
        WebElement loginBtn = driver.findElement(By.xpath("//button[contains(text(),'Log in')]"));
        loginBtn.click();

        String expectedMessage = "Login was unsuccessful. Please correct the errors and try again.\n" +
                "No customer account found";
        WebElement actualTextElement = driver.findElement(By.xpath("//div[@class='message-error validation-summary-errors']"));
        String actualMessage = actualTextElement.getText();
        Assert.assertEquals("Error message not displayed", expectedMessage, actualMessage);
    }

    @After
    public void tearDown() {
        closeBrowser();
    }

}
