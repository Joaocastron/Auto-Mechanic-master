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

	@Autowired
	private SupplyService supplyService;

	@ModelAttribute("supply")
	public SupplyDTO suppliesDTO() {

		return new SupplyDTO();
	}

	@GetMapping("/newSupply")
	public String supply(Model model) {
		return "newSupply";
	}

	@PostMapping("/newSupply")
	public String SupplyRegister(@ModelAttribute("supply") @Valid SupplyDTO supplyDTO, BindingResult result) {

		Supply existingSupply = supplyService.findBySupplyName(supplyDTO.getSupplyName());

		if (existingSupply != null) {
			result.rejectValue("supplyName", null, "There is a supply with the same name already in the system");
		}

		if (result.hasErrors()) {
			return "newSupply";
		}

		supplyService.save(supplyDTO);

		return "redirect:/register?success";
	}
}
