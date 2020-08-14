package Car.Auto.Mechanic.Controllers;

import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import Car.Auto.Mechanic.DTO.RosterDTO;
import Car.Auto.Mechanic.Services.BookingService;

@Controller
public class RosterController {

	@Autowired
	public BookingService bookingService;

	private RosterDTO rosterDTO = new RosterDTO();

	@ModelAttribute("rosterDTO")
	public RosterDTO rosterDTO() {

		return rosterDTO;
	}

	@GetMapping("/roster")
	public String roster(Model model) {
		return "roster";

	}

	@PostMapping("roster")
	public String rosterDTO(@ModelAttribute("roster") @Valid RosterDTO rosterDTO, BindingResult result) {

		

		return "redirect:/roster";
	}
}
