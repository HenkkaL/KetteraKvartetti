package refApp.domain;

import java.util.ArrayList;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class BookTest {

    Book book;
    List<Tag> tags;
    List<Author> authors;

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

        tags = new ArrayList<>();
        tags.add(new Tag("Eka tagi"));
        tags.add(new Tag("Toka tagi"));
        tags.add(new Tag("Kolmas tagi"));

        authors = new ArrayList<>();
        authors.add(new Author("Teppo Kirjailija"));
        authors.add(new Author("Author 2"));
        authors.add(new Author("Author 3"));

        book = new Book("Eka Kirja", authors, "Tammi", "2001", "12", "Edition", "1", "Series", "Address", "Satunnaista", "TK01", tags);

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
        assertEquals("Teppo Kirjailija", book.getAuthors().get(0).getName());
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
        assertEquals("Edition", book.getEdition());
    }

    @Test
    public void constructorSetsVolumeCorrectly() {
        // TODO review the generated test code and remove the default call to fail.
        assertEquals("1", book.getVolume());
    }

    @Test
    public void constructorSetsSeriesCorrectly() {
        // TODO review the generated test code and remove the default call to fail.
        assertEquals("Series", book.getSeries());
    }

    @Test
    public void constructorSetsAddressCorrectly() {
        // TODO review the generated test code and remove the default call to fail.
        assertEquals("Address", book.getAddress());
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
    public void setTitleTest() {
        book.setTitle("title test");
        assertEquals("title test", book.getTitle());
    }

    @Test
    public void setPublisherTest() {
        book.setPublisher("publisher test");
        assertEquals("publisher test", book.getPublisher());
    }

    @Test
    public void setYearTest() {
        book.setYear("2017");
        assertEquals("2017", book.getYear());
    }

    @Test
    public void setMonthTest() {
        book.setMonth("12");
        assertEquals("12", book.getMonth());
    }

    @Test
    public void setVolumeTest() {
        book.setVolume("1");
        assertEquals("1", book.getVolume());
    }

    @Test
    public void setSeriesTest() {
        book.setSeries("series test");
        assertEquals("series test", book.getSeries());
    }

    @Test
    public void setEditionTest() {
        book.setEdition("edition test");
        assertEquals("edition test", book.getEdition());
    }

    @Test
    public void setAddressTest() {
        book.setAddress("address test");
        assertEquals("address test", book.getAddress());
    }

    @Test
    public void setNoteTest() {
        book.setNote("note test");
        assertEquals("note test", book.getNote());
    }

    @Test
    public void testBookToString() {
        String expected = "@book{TK01,\n"
                + "author = {Teppo Kirjailija},\n"
                + "title = {Eka Kirja},\n"
                + "year = {2001},\n"
                + "month = {12},\n"
                + "publisher = {Tammi},\n"
                + "volume = {1},\n"
                + "series = {Series},\n"
                + "address = {Address},\n"
                + "edition = {Edition},\n"
                + "}\n";
        assertEquals(expected, book.toString());
    }

    @Test
    public void testToPrintWithNothing() {
        List<Author> authors2 = new ArrayList<Author>();
        authors2.add(new Author(""));
        Book test = new Book("", authors2, "", "", "", "", "", "", "", "", "", null);
        String expected = "@book{\n}\n";
        assertEquals(expected, test.toString());
    }

    @Test
    public void testBookGetPrettyString() {
        String expected = "Teppo Kirjailija and Author 2 and Author 3. Eka Kirja. Tammi, Address, 2001.";
        assertEquals(expected, book.getPrettyString());
    }

    @Test
    public void testBookGetPrettyStringWithNoAddress() {
        Book test = new Book("Eka Kirja", authors, "Tammi", "2001", "12", "", "1", "Series", "", "Satunnaista", "TK01", null);
        String expected = "Teppo Kirjailija and Author 2 and Author 3. Eka Kirja. Tammi, 2001.";
        assertEquals(expected, test.getPrettyString());
    }

    @Test
    public void testIssetWithEmptyString() {
        Book test = new Book(null, authors, "Tammi", "2001", "12", "", "1", "Series", "", "Satunnaista", "TK01", null);
        String noText = "";
        assertEquals(false, test.isSet(noText));
    }

    @Test
    public void testGetTagsForHtmlWithExtraSpace() {
        List<Tag> tags = new ArrayList<>();
        String tag1 = "tag1 ";
        String tag2 = " tag2";
        String tag3 = "tag3";
        String space = " ";
        tags.add(new Tag(tag1));
        tags.add(new Tag(tag2));
        tags.add(new Tag(tag3));
        Book test = new Book("", authors, "Tammi", "2001", "12", "", "1", "Series", "", "Satunnaista", "TK01", tags);
        String expected = tag1.trim() + space + tag2.trim() + space + tag3.trim();
        assertEquals(expected, test.getTagsForHtml());
    }

    @Test
    public void testGetTagsWithNull() {
        Book test = new Book("", authors, "Tammi", "2001", "12", "", "1", "Series", "", "Satunnaista", "TK01", null);
        assertNotNull(test.getTags());
    }
    
    @Test
    public void testGetTagsHTMLWithEmptyList() {
        Book test = new Book("Test Title", new ArrayList<Author>(), "Tammi", "2001", "12", "", "1", "Series", "", "Satunnaista", "TK01", new ArrayList<Tag>());
        assertEquals("", test.getTagsForHtml());
    }
    
    @Test
    public void testGetAuthorsHTMLWithEmptyList() {
        Book test = new Book("Test Title", new ArrayList<Author>(), "Tammi", "2001", "12", "", "1", "Series", "", "Satunnaista", "TK01", new ArrayList<Tag>());
        assertEquals("", test.getAuthorsForHtml());
    }   
    
    @Test
    public void testNullAuthorList() {
        Book test = new Book("Test Title", null, "Tammi", "2001", "12", "", "1", "Series", "", "Satunnaista", "TK01", new ArrayList<Tag>());
        assertEquals(0, test.getAuthors().size());
    }
    
   
}
