package refApp.domain;

import java.util.ArrayList;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class TagTest {

    Tag tag;

    public TagTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
        tag = new Tag("Java");
    }

    @After
    public void tearDown() {
    }

    @Test
    public void constructorSetsNameCorrectly() {
        assertEquals("java", tag.getName());
    }

    @Test
    public void testTagSetName() {
        String s = "Python";
        tag.setName(s);
        assertEquals("python", tag.getName());
    }

    @Test
    public void testTagToString() {
        assertEquals("java", tag.toString());
    }

    @Test
    public void testAddReference() {
        Book test = new Book("Test Title", new ArrayList<Author>(), "Tammi", "2001", "12", "", "1", "Series", "", "Satunnaista", "TK01", new ArrayList<Tag>());
        tag.addReference(test);
        assertEquals(1, tag.getReferences().size());
    }

    @Test
    public void testAddNullReference() {
        Book test = new Book("Test Title", new ArrayList<Author>(), "Tammi", "2001", "12", "", "1", "Series", "", "Satunnaista", "TK01", new ArrayList<Tag>());
        tag.addReference(test);
        tag.addReference(null);
        assertEquals(1, tag.getReferences().size());
    }

    @Test
    public void testGetNullReferenceList() {
        Tag test = new Tag();
        assertEquals(0, test.getReferences().size());
    }

}
