package refApp.domain;

import java.util.ArrayList;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author mlyra
 */
public class ArticleTest {

    Article art;
    List<Tag> tags;
    List<Author> authors;

    public ArticleTest() {
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
        authors.add(new Author("Author Surname"));
        authors.add(new Author("Author 2"));
        authors.add(new Author("Author 3"));
        art = new Article("Article Title", authors, "Journal", "2017", "03", "5", "3", "2-3", "Note", "ReferenceId", tags);
    }

    @After
    public void tearDown() {
    }

    @Test
    public void constructorSetsCorrectTitle() {
        assertEquals("Article Title", art.getTitle());
    }

    @Test
    public void constructorSetsCorrectAuthor() {
        assertEquals("Author Surname", art.getAuthors().get(0).getName());
    }

    @Test
    public void constructorSetsCorrecJournal() {
        assertEquals("Journal", art.getJournal());
    }

    @Test
    public void constructorSetsCorrecYear() {
        assertEquals("2017", art.getYear());
    }

    @Test
    public void constructorSetsCorrectMonth() {
        assertEquals("03", art.getMonth());
    }

    @Test
    public void constructorSetsCorrectVolume() {
        assertEquals("5", art.getVolume());
    }

    @Test
    public void constructorSetsCorrectNumber() {
        assertEquals("3", art.getNumber());
    }

    @Test
    public void constructorSetsCorrectPages() {
        assertEquals("2-3", art.getPages());
    }

    @Test
    public void constructorSetsCorrectNote() {
        assertEquals("Note", art.getNote());
    }

    @Test
    public void constructorSetsCorrectReferenceId() {
        assertEquals("ReferenceId", art.getReferenceId());
    }

    @Test
    public void setJournalTest() {
        art.setJournal("journal test");
        assertEquals("journal test", art.getJournal());
    }

    @Test
    public void setNumberTest() {
        art.setNumber("2");
        assertEquals("2", art.getNumber());
    }

    @Test
    public void testArticleToString() {
        String expected = "@article{ReferenceId,\n"
                + "author = {Author Surname and Author 2 and Author 3},\n"
                + "title = {Article Title},\n"
                + "journal = {Journal},\n"
                + "volume = {5},\n"
                + "number = {3},\n"
                + "year = {2017},\n"
                + "month = {03},\n"
                + "pages = {2-3},\n"
                + "note = {Note},\n"
                + "}\n";
        assertEquals(expected, art.toString());
    }

    @Test
    public void testArticleWithNothing() {
        List<Author> authors2 = new ArrayList<Author>();
        authors2.add(new Author(""));
        Article test = new Article("", authors2, "", "", "", "", "", "", "", "", null);
        String expected = "@article{\n}\n";
        assertEquals(expected, test.toString());
    }

    @Test
    public void testArticleGetPrettyString() {
        String expected = "Author Surname and Author 2 and Author 3. Article Title. Journal, 5(3):2-3, 2017.";
        assertEquals(expected, art.getPrettyString());
    }

    @Test
    public void testArticleGetPrettyStringWithNoNumber() {
        Article test = new Article("Article Title", art.getAuthors(), "Journal", "2017", "03", "5", "", "2-3", "Note", "ReferenceId", null);
        String expected = "Author Surname and Author 2 and Author 3. Article Title. Journal, 5:2-3, 2017.";
        assertEquals(expected, test.getPrettyString());
    }

    @Test
    public void testArticleGetPrettyStringWithNoNumberNoPages() {
        Article test = new Article("Article Title", art.getAuthors(), "Journal", "2017", "03", "5", "", "", "Note", "ReferenceId", null);
        String expected = "Author Surname and Author 2 and Author 3. Article Title. Journal, 5, 2017.";
        assertEquals(expected, test.getPrettyString());
    }

    @Test
    public void testArticleGetPrettyStringWithNoVolumeNoPages() {
        Article test = new Article("Article Title", art.getAuthors(), "Journal", "2017", "03", "", "", "", "Note", "ReferenceId", null);
        String expected = "Author Surname and Author 2 and Author 3. Article Title. Journal, 2017.";
        assertEquals(expected, test.getPrettyString());
    }

}
