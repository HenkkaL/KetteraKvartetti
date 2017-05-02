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
public class InproceedingsTest {

    Inproceedings inpro;
    List<Tag> tags;
    List<Author> authors;

    public InproceedingsTest() {
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

        inpro = new Inproceedings("Inpro Title", authors, "Book Title", "2017", "03",
                "Editor", "vol.1", "series", "1-5", "Organization", "Publisher", "Address", "Note", "ReferenceId", tags);
    }

    @After
    public void tearDown() {
    }

    @Test
    public void constructorSetsCorrectTitle() {
        assertEquals("Inpro Title", inpro.getTitle());
    }

    @Test
    public void constructorSetsCorrectAuthor() {
        assertEquals("Author Surname", inpro.getAuthors().get(0).getName());
    }

    @Test
    public void constructorSetsCorrecBookTitle() {
        assertEquals("Book Title", inpro.getInproceedingsBookTitle());
    }

    @Test
    public void constructorSetsCorrecYear() {
        assertEquals("2017", inpro.getYear());
    }

    @Test
    public void constructorSetsCorrectMonth() {
        assertEquals("03", inpro.getMonth());
    }

    @Test
    public void constructorSetsCorrectEditor() {
        assertEquals("Editor", inpro.getEditor());
    }

    @Test
    public void constructorSetsCorrectVolume() {
        assertEquals("vol.1", inpro.getVolume());
    }

    @Test
    public void constructorSetsCorrectSeries() {
        assertEquals("series", inpro.getSeries());
    }

    @Test
    public void constructorSetsCorrectPages() {
        assertEquals("1-5", inpro.getPages());
    }

    @Test
    public void constructorSetsCorrectOrganization() {
        assertEquals("Organization", inpro.getOrganization());
    }

    @Test
    public void constructorSetsCorrectPublisher() {
        assertEquals("Publisher", inpro.getPublisher());
    }

    @Test
    public void constructorSetsCorrectAddres() {
        assertEquals("Address", inpro.getAddress());
    }

    @Test
    public void constructorSetsCorrectNote() {
        assertEquals("Note", inpro.getNote());
    }

    @Test
    public void constructorSetsCorrectReferenceId() {
        assertEquals("ReferenceId", inpro.getReferenceId());
    }

    @Test
    public void setEditorTest() {
        inpro.setEditor("editor test");
        assertEquals("editor test", inpro.getEditor());
    }

    @Test
    public void setInproceedingsBookTitleTest() {
        inpro.setInproceedingsBookTitle("inproceedingsBookTitle test");
        assertEquals("inproceedingsBookTitle test", inpro.getInproceedingsBookTitle());
    }

    @Test
    public void setOrganizationTest() {
        inpro.setOrganization("organization test");
        assertEquals("organization test", inpro.getOrganization());
    }

    @Test
    public void setPagesTest() {
        inpro.setPages("1-2");
        assertEquals("1-2", inpro.getPages());
    }
    
    @Test
    public void testInproToString() {
        String expected = "@Inproceedings{ReferenceId,\n"
                + "author = {Author Surname},\n"
                + "title = {Inpro Title},\n"
                + "booktitle = {Book Title},\n"
                + "editor = {Editor},\n"
                + "volume = {vol.1},\n"
                + "series = {series},\n"
                + "pages = {1-5},\n"
                + "address = {Address},\n"
                + "organization = {Organization},\n"
                + "publisher = {Publisher},\n"
                + "year = {2017},\n"
                + "month = {03},\n"
                + "note = {Note},\n"
                + "}\n";
        assertEquals(expected, inpro.toString());
    }

    @Test
    public void testInproPrintMethodsWithEmptyString() {
        Inproceedings test = new Inproceedings("Title", authors, "", "2017", "", "", "", "", "", "", "", "", "", "ReferenceId", null);
        String expected = "@Inproceedings{ReferenceId,\n"
                + "author = {Author Surname},\n"
                + "title = {Title},\n"
                + "year = {2017},\n"
                + "}\n"
                + "";
        assertEquals(expected, test.toString());
    }

    @Test
    public void testInproGetPrettyString() {
        String expected = "Author Surname and Author 2 and Author 3. Inpro Title. In Book Title, pages 1-5. Publisher, 2017.";
        assertEquals(expected, inpro.getPrettyString());
    }

    @Test
    public void testInproGetPrettyStringNoPagesNoPublisher() {
        inpro = new Inproceedings("Inpro Title", authors, "Book Title", "2017", "03",
                "Editor", "vol.1", "series", "", "Organization", "", "Address", "Note", "ReferenceId", null);
        String expected = "Author Surname and Author 2 and Author 3. Inpro Title. In Book Title. 2017.";
        assertEquals(expected, inpro.getPrettyString());
    }

}
