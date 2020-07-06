package Car.Auto.Mechanic.Controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AllocateController {
    
    @GetMapping("/allocate")
    public String allocate(){
        return "allocate";
    }
}