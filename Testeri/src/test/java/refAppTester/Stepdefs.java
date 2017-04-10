package refAppTester;

import cucumber.api.java.After;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import static org.junit.Assert.*;
import org.junit.Before;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.firefox.FirefoxDriver;
//import org.openqa.selenium.htmlunit.HtmlUnitDriver;

public class Stepdefs {

//    WebDriver driver = new HtmlUnitDriver();
    WebDriver driver = new ChromeDriver();
    String baseUrl = "http://localhost:8080";

    @Before
    public void alustus() {
        driver.get(baseUrl);
    }

    @Given("^add new is selected$")
    public void add_new_is_selected() throws Throwable {
        driver.get(baseUrl);
    }

    @When("^correct referenceId \"([^\"]*)\" and title \"([^\"]*)\" and author \"([^\"]*)\" and publisher \"([^\"]*)\" and year \"([^\"]*)\" are added$")
    public void correct_referenceId_and_title_and_author_and_publisher_and_year_are_added(String referenceId, String title, String author, String publisher, String year) throws Throwable {
        createReference(referenceId, title, author, year, publisher);

    }

    @Then("^form is submitted and list of references is displayed$")
    public void form_is_submitted_and_list_of_references_is_displayed() throws Throwable {
        pageHasContent("Referenz-o-matic 3000");
    }

    @After
    public void tearDown() {
        driver.quit();
    }

    /* helper methods */
    private void pageHasContent(String content) {
        assertTrue(driver.getPageSource().contains(content));
    }

    private void createReference(String reference_id, String title, String auth, String year, String publisher) {
//        try{ Thread.sleep(3000); } catch(Exception e){}  // suoritus pysähtyy 3 sekunniksi
        pageHasContent("Lisää uusi viite");
//        assertTrue(driver.getPageSource().contains("Lisää uusi viite"));
        WebElement element = driver.findElement(By.name("title"));
        element.sendKeys(title);
        element = driver.findElement(By.name("reference_id"));
        element.sendKeys(reference_id);
        element = driver.findElement(By.name("author"));
        element.sendKeys(auth);
        element = driver.findElement(By.name("year"));
        element.sendKeys(year);
        element = driver.findElement(By.name("publisher"));
        element.sendKeys(publisher);
        element = driver.findElement(By.name("submit"));
        element.submit();
    }
}
