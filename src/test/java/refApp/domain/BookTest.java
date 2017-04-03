package refApp.domain;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Raine Rantanen
 */
public class BookTest {

    Book book;
    Book book2;
    Author author;

    public BookTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
        author = new Author("Beck");
        book = new Book("BookTitle", author, "Addison-Wesley", 1999, "pp.25-75", "Oregon");
        book2= new Book("BookTitle2", author, "AW", 2000);
    }

    @After
    public void tearDown() {
    }

    @Test
    public void constructorSetsTitleCorrectly() {
        // TODO review the generated test code and remove the default call to fail.
        assertEquals("BookTitle", book.getTitle());
    }
    
     @Test
    public void secondConstructorSetsTitleCorrectly() {
        // TODO review the generated test code and remove the default call to fail.
        assertEquals("BookTitle2", book2.getTitle());
    }

    @Test
    public void constructorSetsAuthorCorrectly() {
        // TODO review the generated test code and remove the default call to fail.
        assertEquals("Beck", book.getAuthor().getName());
    }

    @Test
    public void secondConstructorSetsAuthorCorrectly() {
        // TODO review the generated test code and remove the default call to fail.
        assertEquals("Beck", book2.getAuthor().getName());
    }
    
    @Test
    public void constructorSetsPublisherCorrectly() {
        // TODO review the generated test code and remove the default call to fail.
        assertEquals("Addison-Wesley", book.getPublisher());
    }
    
    @Test
    public void secondConstructorSetsPublisherCorrectly() {
        // TODO review the generated test code and remove the default call to fail.
        assertEquals("AW", book2.getPublisher());
    }

    @Test
    public void constructorSetsYearCorrectly() {
        // TODO review the generated test code and remove the default call to fail.
        assertEquals(1999, book.getYear());
    }
    
     @Test
    public void secondConstructorSetsYearCorrectly() {
        // TODO review the generated test code and remove the default call to fail.
        assertEquals(2000, book2.getYear());
    }

    @Test
    public void constructorSetsAddressCorrectly() {
        // TODO review the generated test code and remove the default call to fail.
        assertEquals("Oregon", book.getAddress());
    }
    
    @Test
    public void secondConstructorSetsAddressToNull() {
        // TODO review the generated test code and remove the default call to fail.
        assertEquals(null, book2.getAddress());
    }

    @Test
    public void constructorSetsPagesCorrectly() {
        // TODO review the generated test code and remove the default call to fail.
        assertEquals("pp.25-75", book.getPages());
    }
    
     @Test
    public void secondConstructorSetsPagestoNull() {
        // TODO review the generated test code and remove the default call to fail.
        assertEquals(null, book2.getPages());
    }
}
