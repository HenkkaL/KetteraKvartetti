
package refApp.domain;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class TagTest {
    Tag tag;
    
    public TagTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
        tag = new Tag("Java");
    }

    @After
    public void tearDown() {
    }

    @Test
    public void constructorSetsNameCorrectly() {
        assertEquals("Java", tag.getName());
    }
    
    @Test
    public void testAuthorSetName() {
        String expected = "Python"; 
        tag.setName(expected);
        assertEquals(expected, tag.getName());
    }
    
    @Test
    public void testAuthorToString() {
        assertEquals("Java", tag.toString());
    }
    
}
