package refApp;

import cucumber.api.java.After;
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
    String baseUrl = "localhost:8080";

    @Given("^add new is selected$")
    public void add_new_is_selected() throws Throwable {
        driver.get(baseUrl);
    }

    @When("^correct title \"([^\"]*)\" and author \"([^\"]*)\" and publisher \"([^\"]*)\" and year \"([^\"]*)\"  are added$")
    public void correct_title_and_author_and_year(String title, String author, String publisher, String year, String pages_start, String pages_end, String address) {
        createReference(title, author, year);
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

    private void createReference(String title, String auth, String year) {
        assertTrue(driver.getPageSource().contains("Lisää uusi kirja"));
        WebElement element = driver.findElement(By.name("name"));
        element.sendKeys(title);
        element = driver.findElement(By.name("author"));
        element.sendKeys(auth);
        element = driver.findElement(By.name("year"));
        element.sendKeys(year);
    /*    element = driver.findElement(By.name("publisher"));
        element.sendKeys(publisher);
        element = driver.findElement(By.name("pages_start"));
        element.sendKeys(pages_start);
        element = driver.findElement(By.name("pages_end"));
        element.sendKeys(pages_end);
        element = driver.findElement(By.name("String address"));
        element.sendKeys(address);
        element = driver.findElement(By.name("submit"));   */
        element.submit();
    }
}
