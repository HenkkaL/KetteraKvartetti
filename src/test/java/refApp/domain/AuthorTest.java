package refApp.domain;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Raine Rantanen
 */
public class AuthorTest {

    Author author;

    public AuthorTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
        author = new Author("Kent Beck");
    }

    @After
    public void tearDown() {
    }

    @Test
    public void constructorSetsNameCorrectly() {
        // TODO review the generated test code and remove the default call to fail.
        assertEquals("Kent Beck", author.getName());
    }

}
