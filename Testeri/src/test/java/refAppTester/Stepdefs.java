package refAppTester;

import cucumber.api.java.After;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import java.util.concurrent.TimeUnit;
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


    @Given("^add new \"([^\\\"]*)\" is selected$")
    public void add_new_is_selected(String refType) throws Throwable {
        driver.get(baseUrl);
        chooseRefType(refType);
    }   
    
    @When("^correct referencId \"([^\"]*)\" is given")
    public void correct_referenceId_is_given(String referenceId) {
        this.addReferenceId(referenceId);
    }
    
    @When("^correct title \"([^\"]*)\" is given")
    public void correct_title_is_given(String title) {
        this.addTitle(title);
    }    
    
    @When("^correct author \"([^\"]*)\" is given")
    public void correct_author_is_given(String author) {
        this.addAuthor(author);
    }        
    
    @When("^correct year \"([^\"]*)\" is given")
    public void correct_year_is_given(String year) {
        this.addYear(year);
    }    
    
    @When("^correct publisher \"([^\"]*)\" is given")
    public void correct_publisher_is_given(String publisher) {
        this.addPublisher(publisher);
    }        

    @When("^correct month \"([^\"]*)\" is given")
    public void correct_month_is_given(String month) {
        this.addMonth(month);
    }       

    @When("^correct edition \"([^\"]*)\" is given")
    public void correct_edition_is_given(String edition) {
        this.addEdition(edition);
    }       

    @When("^correct volume \"([^\"]*)\" is given")
    public void correct_volume_is_given(String volume) {
        this.addVolume(volume);
    }       

    @When("^correct series \"([^\"]*)\" is given")
    public void correct_series_is_given(String series) {
        this.addSeries(series);
    }       

    @When("^correct address \"([^\"]*)\" is given")
    public void correct_address_is_given(String address) {
        this.addAddress(address);
    }       

    @When("^correct note \"([^\"]*)\" is given")
    public void correct_note_is_given(String note) {
        this.addNote(note);
    }   
    
    @When("^correct book_title \"([^\"]*)\" is given")
    public void correct_book_title_is_given(String book_title) {
        this.addBookTitle(book_title);
    }   

    @When("^correct editor \"([^\"]*)\" is given")
    public void correct_editor_is_given(String editor) {
        this.addEditor(editor);
    }
    
    @When("^correct volume_number \"([^\"]*)\" is given")
    public void correct_volume_number_is_given(String volume_number) {
        this.addVolumeNumber(volume_number);
    }    
    
    @When("^correct organisation \"([^\"]*)\" is given")
    public void correct_organisation_is_given(String organisation) {
        this.addVolumeNumber(organisation);
    }    
    
    @When("^correct pages start \"([^\"]*)\" and end \"([^\"]*)\" is given")
    public void correct_organisation_is_given(String start, String end) {
        this.addPages(start, end);
    }      
    
    @When("^form is submitted")
    public void submit() {
        //this.makeSubmit();
        WebElement element = driver.findElement(By.name("submit"));
        element.click();
    }               

    @Then("^page has content \"([^\"]*)\"")
    public void list_of_references_is_displayed(String content) throws Throwable {
        pageHasContent(content);
    }
    
    @Then("^form is submitted and missing metadata alert is displayed$")
    public void form_is_submitted_and_metadata_alert_is_displayed() throws Throwable {
       //driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        pageHasContent("Lisää uusi viite");
    }    

    @After
    public void tearDown() {
        driver.quit();
    }

    /* helper methods */
    private void pageHasContent(String content) {
        assertTrue(driver.getPageSource().contains(content));
    }

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
    
    private void addBookTitle(String bookTitle) {
        WebElement element = driver.findElement(By.name("book_title"));
        element.sendKeys(bookTitle);
    }    
    
    private void addEditor(String editor) {
        WebElement element = driver.findElement(By.name("editor"));
        element.sendKeys(editor);
    }      

    private void addVolumeNumber(String volume_number) {
        WebElement element = driver.findElement(By.name("volume_number"));
        element.sendKeys(volume_number);
    }          
    
    private void addOrganisation(String organisation) {
        WebElement element = driver.findElement(By.name("organisation"));
        element.sendKeys(organisation);
    }    
    
    private void addPages(String pagesStart, String pagesEnd) {
        WebElement element = driver.findElement(By.name("pages_start"));
        element.sendKeys(pagesStart);
        element = driver.findElement(By.name("pages_end"));
        element.sendKeys(pagesEnd);
    }    
    
    private void makeSubmit( ) {
        WebElement element = driver.findElement(By.name("submit"));
        element.click();
    }
}
