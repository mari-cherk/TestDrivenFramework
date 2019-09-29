package comAnswerhubBace;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class TestBase {

    public static WebDriver driver;
    public static Properties config = new Properties();
    public static Properties OR = new Properties();
    public static FileInputStream fis;

    @BeforeSuite
    public void setUp(){

        if(driver==null) {

            try {
                fis = new FileInputStream(System.getProperty("user.dir") + "\\src\\test\\resources\\properties\\Config.properties");

            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
            try {
                config.load(fis);
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                fis = new FileInputStream(System.getProperty("user.dir")+"\\src\\test\\resources\\properties\\OR.properties");
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
            try {
                OR.load(fis);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        if(config.getProperty("browser").equals("firefox")) {
            System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir")+"\\src\\test\\resources\\executable\\geckodriver.exe");
            driver = new FirefoxDriver();
        } else if(config.getProperty("browser").equals("chrome")) {
            System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"\\src\\test\\resources\\executable\\chromedriver.exe");
            driver = new ChromeDriver();
        }

        driver.get(config.getProperty("testsiteurl"));
        driver.manage().window().maximize();

        WebDriverWait wait = new WebDriverWait(driver, 10);

    }

    @AfterSuite
    public void tearDOwn(){

        if(driver!=null){
            driver.quit();
        }

    }
}
