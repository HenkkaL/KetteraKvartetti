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
public class InproceedingsTest {
    Inproceedings inpro;
    
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
        inpro = new Inproceedings("Innpro Title", new Author ("Author Surname"), "Book Title", "2017", "03", 
                "Editor et. al", "vol.1", "series", "1-5", "Organization", "Publisher", "Address", "Note", "ReferenceId");
    }
    
    @After
    public void tearDown() {
    }

    @Test
    public void constructorSetsCorrectTitle() {
        assertEquals("Innpro Title", inpro.getTitle());
    }

    @Test
    public void constructorSetsCorrectAuthor() {
        assertEquals("Author Surname", inpro.getAuthor().getName());
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
        assertEquals("Editor et. al", inpro.getEditor());
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
       
}
