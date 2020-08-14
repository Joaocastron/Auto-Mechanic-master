package Car.Auto.Mechanic.Controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import Car.Auto.Mechanic.DTO.SupplyDTO;
import Car.Auto.Mechanic.Entity.Supply;
import Car.Auto.Mechanic.Services.SupplyService;

@Controller
public class SupplyController {

	// instantiation of repositories and services needed
	@Autowired
	private SupplyService supplyService;

	// model attribute for SupplyDTO creating new supply
	@ModelAttribute("supply")
	public SupplyDTO suppliesDTO() {

		return new SupplyDTO();
	}

	// GET http://localhost:8080/newSupply
	@GetMapping("/newSupply")
	public String supply(Model model) {
		return "newSupply";
	}

	// POST http://localhost:8080/newSupply
	@PostMapping("/newSupply")
	public String SupplyRegister(@ModelAttribute("supply") @Valid SupplyDTO supplyDTO, BindingResult result) {

		// checking if the supply already exists in the databases by supply name
		Supply existingSupply = supplyService.findBySupplyName(supplyDTO.getSupplyName());

		if (existingSupply != null) {
			result.rejectValue("supplyName", null, "There is a supply with the same name already in the system");
		}

		if (result.hasErrors()) {
			return "newSupply";
		}

		supplyService.save(supplyDTO);

		return "redirect:/homeApp?success";
	}
}
