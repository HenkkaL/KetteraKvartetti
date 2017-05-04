package refApp.controllers;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Collection;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
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
    
    @RequestMapping(value = "/references/{referenceId}", method = RequestMethod.GET)
    public String edit(@PathVariable ("referenceId") Long refId, Model model) {
        model.addAttribute("reference", this.referenceService.getReferenceRepo().findOne(refId));
        return "references/reference";
    }
    
    @RequestMapping(value = "/references/{referenceId}", method = RequestMethod.POST)
    public String update(@PathVariable ("referenceId") Long refId, @RequestParam Map<String, String> params) {
        referenceService.updateReference(refId, params);
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
    public ResponseEntity<byte[]> downloadFile(@RequestParam Map<String, String> params) throws IOException {
        String filename = "sigproc";
        if (!params.get("downloadname").trim().equals("")) {
            filename = params.get("downloadname");
        }
        new BibTeXFormatter().writeSelectedReferencesToFile(this.referenceService.getReferenceRepo().findAll(), selectIdsFromMap(params));
        final HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.parseMediaType("text/bib"));
        headers.add("Content-Disposition", "attachment; filename=" + filename + ".bib");
        return new ResponseEntity<>(convertToBytes(), headers, HttpStatus.CREATED);
    }

    private byte[] convertToBytes() throws IOException {
        return Files.readAllBytes(Paths.get("src/main/resources/downloadables/sigproc.bib"));
    }

    private Set<Long> selectIdsFromMap(Map<String, String> values) {
        Set<Long> ret = new HashSet();
        for (String value : values.keySet()) {
            if (value.startsWith("id")) {
                ret.add(Long.parseLong(values.get(value)));
            }
        }
        return ret;
    }
}