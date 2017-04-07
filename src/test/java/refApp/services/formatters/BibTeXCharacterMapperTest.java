
package refApp.services.formatters;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;


public class BibTeXCharacterMapperTest {
    private CharacterMapper mapper;
    
    public BibTeXCharacterMapperTest() {
    }
    
    @Before
    public void setUp() {
        this.mapper = new BibTeXCharacterMapper();
    }
    
    @Test
    public void nullIsReturnedIfCantBeMapped() {
        assertNull(mapper.getStringMappedFor('.'));
    }
    
    @Test
    public void aToZMappedCorrectly() {
        for (int i = 65; i <= 90; i++) {
            char c = (char)i;
            String mapped = mapper.getStringMappedFor(c);
            assertEquals(mapped, Character.toString(c));
        }
        
        for (int i = 97; i <= 122; i++) {
            char c = (char)i;
            String mapped = mapper.getStringMappedFor(c);
            assertEquals(mapped, Character.toString(c));
        }
    }
    
    @Test
    public void nordicAMappedCorrectly() {
        assertEquals(mapper.getStringMappedFor('ä'), "{\\\"a}");
        assertEquals(mapper.getStringMappedFor('Ä'), "{\\\"A}");
    }
    
    @Test
    public void nordicOMappedCorrectly() {
        assertEquals(mapper.getStringMappedFor('ö'), "{\\\"o}");
        assertEquals(mapper.getStringMappedFor('Ö'), "{\\\"O}");
    }
    
    @Test
    public void uUmlautMappedCorrectly() {
        assertEquals(mapper.getStringMappedFor('ü'), "{\\\"u}");
        assertEquals(mapper.getStringMappedFor('Ü'), "{\\\"U}");
    }
    
    @Test
    public void swedishOMappedCorrectly() {
        assertEquals(mapper.getStringMappedFor('å'), "{\\aa}");
        assertEquals(mapper.getStringMappedFor('Å'), "{\\AA}");
    }
}
