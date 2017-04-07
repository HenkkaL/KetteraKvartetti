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
    public void onlyDelimitersForEmptyString() {
        assertEquals(formatter.formatString(""), "{}");
    }
    
    @Test
    public void delimitedString() {
        assertEquals(formatter.formatString("aZ1 .+"), "{aZ1 .+}");
    }
    
    @Test
    public void pagesNumbersFormattedFine() {
        assertEquals(formatter.formatPageString(1, 666), "{1--666}");
    }
}
