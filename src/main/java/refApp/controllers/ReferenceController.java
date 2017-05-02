package refApp.controllers;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Map;
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
import refApp.services.ReferenceService;
import refApp.services.formatters.BibTeXFormatter;

@Controller
public class ReferenceController {

    @Autowired
    private ReferenceService referenceService;

    public ReferenceController() {
    }

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
    
    @RequestMapping(value = "/delete", method = RequestMethod.POST)
    public String delete(@RequestParam Map<String, String> params) {
        String refId = params.get("referenceId");
        this.referenceService.deleteReference(refId);
        return "redirect:/list_all";
    }    

    @RequestMapping(value = "/list_all")
    public String listAll(Model model) {
        model.addAttribute("references", this.referenceService.getReferenceRepo().findAll());
        return "references/view_all";
    }

    @RequestMapping(value = "/download", method = RequestMethod.GET)
    public ResponseEntity<byte[]> downloadFile(@RequestParam String downloadname) throws IOException {
        new BibTeXFormatter().writeReferencesToFile(this.referenceService.getReferenceRepo().findAll());
        final HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.parseMediaType("text/bib"));

        String filename = "sigproc";
        if (!downloadname.trim().equals("")) {
            filename = downloadname;
        }
        
        headers.add("Content-Disposition", "attachment; filename=" + filename + ".bib");
        return new ResponseEntity<>(convertToBytes(), headers, HttpStatus.CREATED);
    }

    private byte[] convertToBytes() throws IOException {
        return Files.readAllBytes(Paths.get("src/main/resources/downloadables/sigproc.bib"));
    }
}
