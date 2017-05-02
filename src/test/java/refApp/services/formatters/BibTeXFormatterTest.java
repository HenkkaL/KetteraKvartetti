package refApp.services.formatters;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import refApp.domain.Tag;

/**
 *
 * @author pqkallio
 */

@RunWith(SpringRunner.class)
@SpringBootTest
public class BibTeXFormatterTest {
    
    @Autowired
    private BibTeXFormatter formatter;
    
    
    public BibTeXFormatterTest() {
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
    
    @Test
    public void addTagsReturnsCorrectly(){
    Map<String, String> params= new HashMap();
    params.put("tag1", "eka tagi");
    List<Tag> tags =formatter.addTags(params);
    assertEquals(tags.get(0).toString(),"eka tagi");
    }
}
