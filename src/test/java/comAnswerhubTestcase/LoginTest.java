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

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(OR.getProperty("usernameField_XPATH"))));

        log.debug("Inside Login Test");
        type("usernameField_XPATH", "marinac");
        type("passwordField_XPATH", "654321");
        click("loginBtn_XPATH");

        Assert.assertTrue(isElementPresent(By.xpath(OR.getProperty("createBtn_XPATH"))), "Login is not successful");

        log.debug("Login successfully executed");




    }
}
