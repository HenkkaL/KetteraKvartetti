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
import refApp.domain.Article;
import refApp.domain.Author;
import refApp.domain.Book;
import refApp.domain.Inproceedings;
import refApp.domain.Reference;

/**
 *
 * @author mlyra
 */
public class ReferenceServiceTest {
    ReferenceService refServ;
    ArrayList<Reference> allRef;
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
        refServ = new ReferenceService();
        allRef = new ArrayList();
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
        refServ.addReference(allRef, params);
        Article art = (Article) allRef.get(0);
        assertEquals("Article Title", art.getTitle());
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
        refServ.addReference(allRef, params);
        Book book = (Book) allRef.get(0);
        assertEquals("Book Title", book.getTitle());
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
        refServ.addReference(allRef, params);
        Inproceedings inpro = (Inproceedings) allRef.get(0);
        assertEquals("Inproceedings Title", inpro.getTitle());
    } 
    
}