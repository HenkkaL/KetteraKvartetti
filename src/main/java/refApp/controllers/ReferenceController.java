package refApp.controllers;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import javax.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import refApp.domain.Article;
import refApp.domain.Author;
import refApp.domain.Book;
import refApp.domain.Inproceedings;
import refApp.domain.Tag;
import refApp.services.ReferenceService;
import refApp.services.formatter.BibTeXFormatter;

@Controller
public class ReferenceController {

    @Autowired
    private ReferenceService referenceService;
    
    @Autowired
    private BibTeXFormatter formatter;

//    @Autowired
//    private ReferenceRepository referenceRepository;
    public ReferenceController() {
    }

    //This gives some test data. Probably will be removed sooner than later.
//    @PostConstruct
//    public void init() {
//        List<Tag> tags = new ArrayList<>();
//        tags.add(new Tag("Eka tagi"));
//        tags.add(new Tag("Toka tagi"));
//        tags.add(new Tag("Kolmas tagi"));
//        
//        this.referenceService.saveReference(new Book("Eka Kirja", new Author("Teppo Kirjailija"), "Tammi", "2001", "", "1.painos", "", "", "Kotikatu", "", "SWEBOK",tags));
//        this.referenceService.saveReference(new Book("Toka Kirja", new Author("Jaakko Kirjailija"), "Tammi", "2001", "", "", "", "", "Merikatu", "", "BA04",tags));
//        this.referenceService.saveReference(new Book("3. Kirja", new Author("Martin Fowler"), "Tammi", "1999", "", "1.painos", "", "", "Kotikatu", "", "Martin09",tags));
//        this.referenceService.saveReference(new Book("4. Kirja", new Author("Scrum Master"), "Tammi", "2001", "", "", "", "", "Merikatu", "", "scrum",tags));
//        this.referenceService.saveReference(new Article("eka artikkeli", new Author("Taina Tieteilijä"), "Tiedejulkaisu", "2011", "4", "1", "", "1-5", "Muistiinpanoja", "TT01",tags));
//        this.referenceService.saveReference(new Article("toka artikkeli", new Author("Antti Tohtori"), "Tiedejulkaisu", "2011", "4", "2", "", "pp. 10-15", "", "fox", tags));
//        this.referenceService.saveReference(new Inproceedings("Kirjoitus1", new Author("Maija Maisteri"), "Kirjoitukset", "2005", "12", "Eino Editori", "1", "Kootut julkaisut", "pp. 1-5", "IBM", "Addison-Wesley", "London", "", "royce70", tags));
//        this.referenceService.saveReference(new Inproceedings("Kirjoitus2", new Author("Minna Tohtori"), "Kirjoitukset", "2005", "12", "Eino Editori", "1", "Kootut julkaisut", "pp. 10-15", "IBM", "Addison-Wesley", "London", "", "Begel_2008", tags));
//        
//    }
    @RequestMapping("/")
    public String home(Model model) {
        model.addAttribute("references", this.referenceService.getReferenceRepo().findAll());
        return "references/new";
    }

    @RequestMapping(value = "/new", method = RequestMethod.POST)
    public String add(@RequestParam Map<String, String> params) {
        this.referenceService.addReference(params);
        return "redirect:/list_all";
    }

    @RequestMapping(value = "/list_all")
    public String listAll(Model model) {
        model.addAttribute("references", this.referenceService.getReferenceRepo().findAll());
        return "references/view_all";
    }

    @RequestMapping(value = "/download", method = RequestMethod.GET)
    public ResponseEntity<byte[]> downloadFile() throws IOException {
        formatter.writeReferencesToFile(this.referenceService.getReferenceRepo().findAll());
        final HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.parseMediaType("text/bib"));
        headers.add("Content-Disposition", "attachment; filename= sigproc.bib");

        return new ResponseEntity<>(convertToBytes(), headers, HttpStatus.CREATED);
    }

    private byte[] convertToBytes() throws IOException {
        return Files.readAllBytes(Paths.get("src/main/resources/downloadables/sigproc.bib"));

    }
}
