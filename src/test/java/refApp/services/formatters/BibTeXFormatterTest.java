/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package refApp.services.formatters;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author pqkallio
 */
public class BibTeXFormatterTest {
    private Formatter formatter;
    
    public BibTeXFormatterTest() {
    }
    
    @Before
    public void setUp() {
        this.formatter = new BibTeXFormatter();
    }
    
    @Test
    public void nullForNull() {
        assertNull(formatter.formatString(null));
    }
    
    @Test
    public void pagesNumbersFormattedFine() {
        assertEquals(formatter.formatPageString("1", "666"), "1--666");
    }
    
    @Test
    public void stringIsFormattedCorrectly() {
        String string = "123abcXYZ _,. äÖå";
        String expected = "123abcXYZ _,. {\\\"a}{\\\"O}{\\aa}";
        String output = formatter.formatString(string);
        assertEquals(expected, output);
    }
}
