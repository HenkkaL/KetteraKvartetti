package refApp.domain;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class BookTest {
    Book book;

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
        book = new Book("Eka Kirja", new Author("Teppo Kirjailija"), "Tammi", "2001", "12", "1.painos", "1", "Kirjasarja", "Kotikatu", "Satunnaista", "TK01");      
    }

    @After
    public void tearDown() {
    }

    @Test
    public void constructorSetsTitleCorrectly() {
        // TODO review the generated test code and remove the default call to fail.
        assertEquals("Eka Kirja", book.getTitle());
    }
    
    @Test
    public void constructorSetsAuthorCorrectly() {
        // TODO review the generated test code and remove the default call to fail.
        assertEquals("Teppo Kirjailija", book.getAuthor().getName());
    }
    
    @Test
    public void constructorSetsPublisherCorrectly() {
        // TODO review the generated test code and remove the default call to fail.
        assertEquals("Tammi", book.getPublisher());
    }
    
    @Test
    public void constructorSetsYearCorrectly() {
        // TODO review the generated test code and remove the default call to fail.
        assertEquals("2001", book.getYear());
    }
    
    @Test
    public void constructorSetsMonthCorrectly() {
        // TODO review the generated test code and remove the default call to fail.
        assertEquals("12", book.getMonth());
    }
    
    @Test
    public void constructorSetsEditionCorrectly() {
        // TODO review the generated test code and remove the default call to fail.
        assertEquals("1.painos", book.getEdition());
    }
    
    @Test
    public void constructorSetsVolumeCorrectly() {
        // TODO review the generated test code and remove the default call to fail.
        assertEquals("1", book.getVolume());
    }
    
    @Test
    public void constructorSetsSeriesCorrectly() {
        // TODO review the generated test code and remove the default call to fail.
        assertEquals("Kirjasarja", book.getSeries());
    }

    @Test
    public void constructorSetsAddressCorrectly() {
        // TODO review the generated test code and remove the default call to fail.
        assertEquals("Kotikatu", book.getAddress());
    }
    
     @Test
    public void constructorSetsNoteCorrectly() {
        // TODO review the generated test code and remove the default call to fail.
        assertEquals("Satunnaista", book.getNote());
    }
    
    @Test
    public void constructorSetsReferenceIdCorrectly() {
        // TODO review the generated test code and remove the default call to fail.
        assertEquals("TK01", book.getReferenceId());
    }
    
    @Test
    public void testBookToString() {
        String expected = "@book{TK01,\n"
                + "author = {Teppo Kirjailija},\n"
                + "title = {Eka Kirja},\n"
                + "year = {2001},\n"
                + "publisher = {Tammi},\n"
                + "}\n"
                + "";
        assertEquals(expected, book.toString());
    }
    
    @Test
    public void testBookGetPrettyString() {
        String expected = "Teppo Kirjailija. Eka Kirja. Tammi, Kotikatu, 2001. ";
        assertEquals(expected, book.getPrettyString());
    }
}
