package refApp.controllers;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import javax.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import refApp.domain.Article;
import refApp.domain.Author;
import refApp.domain.Book;
import refApp.domain.Inproceedings;
import refApp.domain.Reference;
import refApp.services.ReferenceService;

@Controller
public class ReferenceController {

    private List<Reference> allReferences;

    @Autowired
    private ReferenceService referenceService;


    //This costructor will be deleted as soon as the database solution is implemented
    public ReferenceController() {
        this.allReferences = new ArrayList();     
    }

    //This gives some test data. Probably will be removed sooner than later.
    @PostConstruct
    public void init() {
        Book kirja1 = new Book("Eka Kirja", new Author("Teppo Kirjailija"), "Tammi", "2001", "", "1.painos", "", "", "Kotikatu", "", "TK01");
        this.allReferences.add(kirja1);
        Book kirja2 = new Book("Toka Kirja", new Author("Jaakko Kirjailija"), "Tammi", "2001", "", "", "", "", "Merikatu", "", "JK01");
        this.allReferences.add(kirja2);

        Article article1 = new Article("eka artikkeli", new Author("Taina Tieteilijä"), "Tiedejulkaisu", "2011", "4", "1", "", "pp. 1-5", "Muistiinpanoja", "TT01");
        this.allReferences.add(article1);
        Article article2 = new Article("toka artikkeli", new Author("Antti Tohtori"), "Tiedejulkaisu", "2011", "4", "2", "", "pp. 10-15", "", "AT01");
        this.allReferences.add(article2);

        Inproceedings inproceedings1 = new Inproceedings("Kirjoitus1", new Author("Maija Maisteri"), "Kirjoitukset", "2005", "12", "Eino Editori", "1", "Kootut julkaisut", "pp. 1-5", "IBM", "Addison-Wesley", "London", "", "MM01");
        this.allReferences.add(inproceedings1);
        Inproceedings inproceedings2 = new Inproceedings("Kirjoitus2", new Author("Minna Tohtori"), "Kirjoitukset", "2005", "12", "Eino Editori", "1", "Kootut julkaisut", "pp. 10-15", "IBM", "Addison-Wesley", "London", "", "MT01");
        this.allReferences.add(inproceedings2);

    }

    @RequestMapping("/")
    public String home(Model model) {
        model.addAttribute("references", this.allReferences);
        return "references/new";
    }

    @RequestMapping(value = "/new", method = RequestMethod.POST)
    public String add(@RequestParam Map<String, String> params) {
        this.referenceService.addReference(this.allReferences, params);
        return "redirect:/list_all";
    }

    @RequestMapping(value = "/list_all")
    public String listAll(Model model) {
        model.addAttribute("references", this.allReferences);
        return "references/view_all";
    }
}
