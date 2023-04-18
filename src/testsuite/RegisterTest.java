package testsuite;

import browserfactory.BaseTest;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;

import java.util.Random;

public class RegisterTest extends BaseTest {
    String baseUrl = "https://demo.nopcommerce.com/";

    @Before
    public void setUp() {

        openBrowser(baseUrl);
    }
    @Test
    public void userShouldNavigateToRegisterPageSuccessfully() {
        driver.findElement(By.xpath("//a[contains(text(),'Register')]")).click();
        String expectedMessage = "Register";//Expected displayed text as per requirement
        String actualMessage = driver.findElement(By.xpath("//div[@class='header-links']/ul[1]/li[1]/a")).getText();
        Assert.assertEquals(expectedMessage, actualMessage);// Validating actual and expected message
    }

    public static String getRandomEmail() {

        String chars = "ABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";
        StringBuilder random = new StringBuilder();
        Random rnd = new Random();
        while (random.length() < 10) { // length of the random string.
            int index = (int) (rnd.nextFloat() * chars.length());
            random.append(chars.charAt(index));
        }
        String email = random.toString() + "@gmail.com";
        return email;
    }

    public void userShouldRegisterAccountsSuccessfullySuccessfully() {
        driver.findElement(By.xpath("//a[contains(text(),'Register')]")).click();
        driver.findElement(By.id("gender-female")).click();
        driver.findElement(By.id("FirstName")).sendKeys("Sita");
        driver.findElement(By.id("LastName")).sendKeys("Ram");
        driver.findElement(By.name("DateOfBirthDay")).sendKeys("5");
        driver.findElement(By.name("DateOfBirthMonth")).sendKeys("10");
        driver.findElement(By.name("DateOfBirthYear")).sendKeys("2000");
        driver.findElement(By.id("Email")).sendKeys(getRandomEmail());
        driver.findElement(By.name("Password")).sendKeys("sitaram123");
        driver.findElement(By.name("ConfirmPassword")).sendKeys("sitaram123");
        driver.findElement(By.name("register-button")).click();
        String expectedMessage = "Your registration completed";
        String actualMessage = driver.findElement(By.xpath("//div[@class='result']")).getText();
        Assert.assertEquals("User was not able to register.",expectedMessage, actualMessage);
    }

    @After
    public void tearDown() {
        closeBrowser();

    }
}