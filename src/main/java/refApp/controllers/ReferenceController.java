package refApp.controllers;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import refApp.domain.Author;
import refApp.domain.Book;
import refApp.domain.Reference;

@Controller
public class ReferenceController {

    private List<Reference> allReferences;

    //This costructor will be deleted as soon as the database solution is implemented
    public ReferenceController() {
        this.allReferences = new ArrayList();
    }

    @RequestMapping("/")
    public String home(Model model) {
        model.addAttribute("references", this.allReferences);
        return "references/new";
    }

    @RequestMapping(value = "/new", method = RequestMethod.POST)
    public String add(@RequestParam Map<String, String> params) {
        Book ref = new Book(params.get("name"), new Author(params.get("author")), params.get("publisher"), Integer.parseInt(params.get("year")), params.get("address"), formPageNo(params.get("pages_start"), params.get("pages_end")));
        this.allReferences.add(ref);
        return "redirect:/list_all";
    }

    @RequestMapping(value = "/list_all")
    public String listAll(Model model) {
        model.addAttribute("references", this.allReferences);
        return "references/view_all";
    }

    private String formPageNo(String start, String end) {
        return "pp. " + start + "-" + end;
    }
}
