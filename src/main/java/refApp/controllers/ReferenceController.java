
package refApp.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

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
}
