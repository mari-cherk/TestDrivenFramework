package comAnswerhubTestcase;


import comAnswerhubBace.TestBase;
import comAnswerhubUtilities.TestUtil;
import org.openqa.selenium.By;
import org.testng.SkipException;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.lang.reflect.Method;
import java.util.Hashtable;

import static jdk.nashorn.internal.objects.NativeJava.type;


public class SiteSearch extends TestBase {

    @Test(dataProvider="getData")
    public void siteSearchForQuestion(String query1, String query2, String query3){

        System.out.println(excel.path);


        type("searchField_XPATH", query1);
        click("searchIcon_XPATH");
        String numberOfSearchResults1 = driver.findElement((By.xpath(OR.getProperty("numberOfResults_XPATH")))).getText();
        System.out.println("Number of Search Results is " + numberOfSearchResults1);
        driver.findElement(By.xpath(OR.getProperty("searchField_XPATH"))).clear();

        type("searchField_XPATH", query2);
        click("searchIcon_XPATH");
        String numberOfSearchResults2 = driver.findElement((By.xpath(OR.getProperty("numberOfResults_XPATH")))).getText();
        System.out.println("Number of Search Results is " + numberOfSearchResults2);
        driver.findElement(By.xpath(OR.getProperty("searchField_XPATH"))).clear();

        type("searchField_XPATH", query3);
        click("searchIcon_XPATH");
        String numberOfSearchResults3 = driver.findElement((By.xpath(OR.getProperty("numberOfResults_XPATH")))).getText();
        System.out.println("Number of Search Results is " + numberOfSearchResults3);



    }

    @DataProvider
    public Object[][] getData() {
        return new Object[][]{{"question", "article", "idea"}};
    }



}
