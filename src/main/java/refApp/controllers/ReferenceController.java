
package refApp.controllers;

import java.util.Map;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * A controller to handle requests based on references
 * 
 * @author pqkallio
 */
@Controller
public class ReferenceController {
    @RequestMapping("/")
    public String home() {
        return "references/new";
    }
    
    @RequestMapping(value = "/", method = RequestMethod.POST)
    public String add(@RequestParam Map<String, String> params) {
        System.out.println(params.get("author") + ": " + params.get("name") 
                + "; " + params.get("year"));
        return "redirect:/";
    }
}
