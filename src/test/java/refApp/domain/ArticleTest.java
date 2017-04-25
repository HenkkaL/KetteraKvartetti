/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package refApp.domain;

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
        art = new Article("Article Title", new Author("Author Surname"), "Journal", "2017", "03", "5", "3", "2-3", "Note", "ReferenceId");
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
        assertEquals("Author Surname", art.getAuthor().getName());
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
    public void testArticleToString() {
        String expected = "@article{ReferenceId,\n"
                        + "author = {Author Surname},\n"
                        + "title = {Article Title},\n"
                        + "journal = {Journal},\n"
                        + "volume = {5},\n"
                        + "number = {3},\n"
                        + "year = {2017},\n"
                        + "month = {03},\n"
                        + "pages = {2-3},\n"
                        + "note = {Note},\n"
                        + "}\n"
                        + "";
        assertEquals(expected, art.toString());
    }
    
    @Test
    public void testArticleGetPrettyString() {
        String expected = "Author Surname. Article Title. Journal, 5(3):2-3, 2017.";
        assertEquals(expected, art.getPrettyString());
    }
       
    
}
