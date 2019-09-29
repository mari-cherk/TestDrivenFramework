package comAnswerhubTestcase;

import comAnswerhubBace.TestBase;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class LoginTest extends TestBase {

    @Test
    public void loginValid() {

        driver.findElement(By.xpath(OR.getProperty("usernameField"))).sendKeys("marinac");
        driver.findElement(By.xpath(OR.getProperty("passwordField"))).sendKeys("654321");
        driver.findElement(By.xpath(OR.getProperty("loginBtn"))).click();



    }
}
