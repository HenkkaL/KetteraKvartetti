package refApp.controllers;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;
import refApp.services.ReferenceService;

/**
 *
 * @author Raine Rantanen
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class ReferenceControllerTest {

    @Autowired
    private WebApplicationContext webAppContext;

    @Autowired
    ReferenceService refServ;
    
    private MockMvc mockMvc;

    public ReferenceControllerTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
        this.mockMvc = MockMvcBuilders.webAppContextSetup(webAppContext).build();
    }

    @After
    public void tearDown() {
    }

    @Test
    public void homeStatusOk() throws Exception {
        mockMvc.perform(get("/"))
                .andExpect(status().isOk());
    }

    @Test
    public void homeModelHasAttributeReferences() throws Exception {
        mockMvc.perform(get("/"))
                .andExpect(model().attributeExists("references"));
    }

    @Test
    public void addStatusOk() throws Exception {
        mockMvc.perform(post("/new")
                .param("type", "book")
                .param("name", "Random book")
                .param("author", "Beck")
                .param("year", "1999")
                .param("publisher", "AW")
                .param("pages_start", "1")
                .param("pages_end", "10")
                .param("address", "Oregon")
        )              
                .andExpect(redirectedUrl("/list_all"));
    }

    @Test
    public void listAllStatusOk() throws Exception {
        mockMvc.perform(get("/list_all"))
                .andExpect(status().isOk());
    }

    @Test
    public void listModelHasAttributeReferences() throws Exception {
        mockMvc.perform(get("/"))
                .andExpect(model().attributeExists("references"));
    }
}
