package comAnswerhubTestcase;




import comAnswerhubBace.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

public class LoginTest extends TestBase {

    @Test
    public void loginValid() {

        //WebDriverWait wait = new WebDriverWait(driver,10);

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(OR.getProperty("usernameField"))));

        log.debug("Inside Login Test");
        driver.findElement(By.xpath(OR.getProperty("usernameField"))).sendKeys("marinac");
        driver.findElement(By.xpath(OR.getProperty("passwordField"))).sendKeys("654321");
        driver.findElement(By.xpath(OR.getProperty("loginBtn"))).click();

        Assert.assertTrue(isElementPresent(By.xpath(OR.getProperty("createBtn"))), "Login is not successful");

        log.debug("Login successfully executed");




    }
}
