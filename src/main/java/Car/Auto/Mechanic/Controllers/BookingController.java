package Car.Auto.Mechanic.Controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class BookingController {
    
    @GetMapping("/booking")
    public String booking(Model model){
        return "booking";
    }
}