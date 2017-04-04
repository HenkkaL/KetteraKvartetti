package refApp;


import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import static org.junit.Assert.*;
import org.openqa.selenium.By;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Stepdefs {
    
    WebDriver driver = new FirefoxDriver();

    private void createReference(String title, String auth, String publisher, String year, String pages_start, String pages_end, String address) {
        assertTrue(driver.getPageSource().contains(""));
        WebElement element = driver.findElement(By.name("name"));
        element.sendKeys(title);
        element = driver.findElement(By.name("author"));
        element.sendKeys(auth);
        element = driver.findElement(By.name("year"));
        element.sendKeys(year);
        element = driver.findElement(By.name("publisher"));
        element.sendKeys(publisher);
        element = driver.findElement(By.name("pages_start"));
        element.sendKeys(pages_start);
        element = driver.findElement(By.name("pages_end"));
        element.sendKeys(pages_end);
        element = driver.findElement(By.name("String address"));
        element.sendKeys(address);
        element = driver.findElement(By.name("submit"));
        element.sendKeys();
    }
}
