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
//import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import org.openqa.selenium.support.ui.Select;

public class Stepdefs {

    WebDriver driver = new HtmlUnitDriver();
//    WebDriver driver = new ChromeDriver();
    String baseUrl = "http://localhost:8080";

    @Before
    public void alustus() {
        driver.get(baseUrl);
    }

    @Given("^add new \"([^\"]*)\" is selected$")
    public void add_new_book_is_selected(String refType) throws Throwable {
        driver.get(baseUrl);
        chooseRefType(refType);
    }

    @Given("^add new is selected$")
    public void add_new_is_selected(String refType) throws Throwable {
        driver.get(baseUrl);
        chooseRefType(refType);
    }    

    @When("^correct referenceId \"([^\"]*)\" and title \"([^\"]*)\" and author \"([^\"]*)\" and publisher \"([^\"]*)\" and year \"([^\"]*)\" are added$")
    public void correct_referenceId_and_title_and_author_and_publisher_and_year_are_added(String referenceId, String title, String author, String publisher, String year) throws Throwable {
        //createReference(referenceId, title, author, year, publisher);
        this.addReferenceId(referenceId);
        this.addTitle(title);
        this.addAuthor(author);
        this.addYear(year);
        this.addPublisher(publisher);
        this.makeSubmit();
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

    /*private void createReference(String reference_id, String title, String auth, String year, String publisher) {
        pageHasContent("Lisää uusi viite");
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
    }*/

    private void chooseRefType(String refType) {
        Select dropdown = new Select(driver.findElement(By.id("type")));
        dropdown.selectByValue(refType);
    }

    private void addReferenceId(String refId) {
        WebElement element = driver.findElement(By.name("reference_id"));
        element.sendKeys(refId);
    }

    private void addTitle(String title) {
        WebElement element = driver.findElement(By.name("title"));
        element.sendKeys(title);
    }

    private void addAuthor(String author) {
        WebElement element = driver.findElement(By.name("author"));
        element.sendKeys(author);
    }

    private void addYear(String year) {
        WebElement element = driver.findElement(By.name("year"));
        element.sendKeys(year);
    }

    private void addMonth(String month) {
        WebElement element = driver.findElement(By.name("month"));
        element.sendKeys(month);
    }

    private void addPublisher(String publisher) {
        WebElement element = driver.findElement(By.name("publisher"));
        element.sendKeys(publisher);
    }

    private void addEdition(String edition) {
        WebElement element = driver.findElement(By.name("edition"));
        element.sendKeys(edition);
    }

    private void addVolume(String volume) {
        WebElement element = driver.findElement(By.name("volume"));
        element.sendKeys(volume);
    }

    private void addSeries(String series) {
        WebElement element = driver.findElement(By.name("series"));
        element.sendKeys(series);
    }

    private void addAddress(String address) {
        WebElement element = driver.findElement(By.name("address"));
        element.sendKeys(address);
    }

    private void addNote(String note) {
        WebElement element = driver.findElement(By.name("note"));
        element.sendKeys(note);
    }

    //sivunumeroiden lisäys puuttuu
    
    private void makeSubmit( ) {
        WebElement element = driver.findElement(By.name("submit"));
        element.submit();
    }
}
