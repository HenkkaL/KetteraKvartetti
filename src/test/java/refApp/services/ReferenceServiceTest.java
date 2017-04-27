/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package refApp.services;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import refApp.domain.Article;
import refApp.domain.Book;
import refApp.domain.Inproceedings;
import refApp.domain.Tag;

/**
 *
 * @author mlyra
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class ReferenceServiceTest {

    @Autowired
    ReferenceService refServ;
    Map<String, String> params;

    public ReferenceServiceTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
//        refServ = new ReferenceService();
        params = new HashMap<String, String>();
    }

    @After
    public void tearDown() {
    }

    /**
     * Test of addReference method, of class ReferenceService.
     */
    @Test
    public void testAddReferenceArticle() {
        params.put("type", "article");
        params.put("title", "Article Title");
        params.put("author", "Author Name");
        params.put("journal", "Journal");
        params.put("year", "2017");
        params.put("month", "03");
        params.put("volume", "Vol");
        params.put("number", "1");
        params.put("pages_start", "1");
        params.put("pages_end", "2");
        params.put("note", "Some note");
        params.put("reference_id", "RefId");
        params.put("tag1", "eka tagi");
        refServ.addReference(params);
        Article art = (Article) refServ.getReferenceRepo().findByTitle("Article Title").get(0);
        assertEquals("Article Title", art.getTitle());
        assertEquals(art.getTags().get(0).toString(), "eka tagi");
    }

    @Test
    public void testAddReferenceBook() {
        params.put("type", "book");
        params.put("title", "Book Title");
        params.put("author", "Author Name");
        params.put("publisher", "Publisher");
        params.put("year", "2017");
        params.put("month", "03");
        params.put("edition", "Edt");
        params.put("volume", "Vol");
        params.put("series", "Series");
        params.put("address", "Book Address");
        params.put("reference_id", "RefId");
        params.put("tag55", "turha tagi");
        refServ.addReference(params);
        Book book = (Book) refServ.getReferenceRepo().findByTitle("Book Title").get(0);
        assertEquals("Book Title", book.getTitle());
        assertEquals(book.getTags().get(0).toString(), "turha tagi");
    }

    @Test
    public void testAddReferenceInproceedings() {
        params.put("type", "inproceedings");
        params.put("title", "Inproceedings Title");
        params.put("author", "Author Name");
        params.put("book_title", "Book Title");
        params.put("year", "2017");
        params.put("month", "03");
        params.put("editor", "Edtr");
        params.put("volume", "Vol");
        params.put("series", "Series");
        params.put("number", "1");
        params.put("pages_start", "1");
        params.put("pages_end", "2");
        params.put("organization", "Org");
        params.put("publisher", "Pub");
        params.put("address", "Addr");
        params.put("note", "Some note");
        params.put("reference_id", "RefId");
        params.put("tag1", "eka tagi");
        params.put("tag2", "toka tagi");
        params.put("tag3", "kolmas tagi");
        refServ.addReference(params);
        Inproceedings inpro = (Inproceedings) refServ.getReferenceRepo().findByTitle("Inproceedings Title").get(0);
        assertEquals("Inproceedings Title", inpro.getTitle());
//        assertEquals(inpro.getTags().get(0).toString(), "eka tagi");
//        assertEquals(inpro.getTags().get(1).toString(), "toka tagi");
//        assertEquals(inpro.getTags().get(2).toString(), "kolmas tagi");
    }

    @Test
    public void testSaveTags() {
        List<Tag> tags = new ArrayList<>();
        tags.add(new Tag("eka tagi"));
        tags.add(new Tag("toka tagi"));
        refServ.saveTags(tags);
        Tag tag = refServ.getTagRepository().findByName("eka tagi").get(0);
        assertEquals(tag.getName(), "eka tagi");
    }
}
