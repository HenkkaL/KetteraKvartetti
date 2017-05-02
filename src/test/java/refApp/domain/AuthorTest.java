package refApp.domain;

import java.util.ArrayList;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class AuthorTest {

    Author author;

    public AuthorTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
        author = new Author("Kent Beck");
    }

    @After
    public void tearDown() {
    }

    @Test
    public void constructorSetsNameCorrectly() {
        // TODO review the generated test code and remove the default call to fail.
        assertEquals("Kent Beck", author.getName());
    }

    @Test
    public void testAuthorSetName() {
        String expected = "Test Name";
        author.setName(expected);
        assertEquals(expected, author.getName());
    }

    @Test
    public void testAuthorToString() {
        assertEquals("Kent Beck", author.toString());
    }

    @Test
    public void testAddReference() {
        List<Author> authors = new ArrayList<Author>();
        authors.add(author);
        Author test = new Author("Test Author");
        Reference ref = new Book("Eka Kirja", authors, "Tammi", "2001", "12", "Edition", "1", "Series", "Address", "Satunnaista", "TK01", null);
        test.addReference(ref);
        assertEquals(1, test.getReferences().size());
    }

    @Test
    public void testAddNullReference() {
        List<Author> authors = new ArrayList<Author>();
        authors.add(author);
        Author test = new Author("Test Author");
        Reference ref = new Book("Eka Kirja", authors, "Tammi", "2001", "12", "Edition", "1", "Series", "Address", "Satunnaista", "TK01", null);
        test.addReference(ref);
        test.addReference(null);
        assertEquals(1, test.getReferences().size());
    }

    @Test
    public void getNullReferenceList() {
        Author test = new Author();
        assertEquals(0, test.getReferences().size());
    }

}
