package Car.Auto.Mechanic.Controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import Car.Auto.Mechanic.DTO.UserRegistrationDTO;
import Car.Auto.Mechanic.DTO.VehicleRegsDTO;
import Car.Auto.Mechanic.Entity.User;
import Car.Auto.Mechanic.Entity.Vehicle;
import Car.Auto.Mechanic.Services.VehicleService;

@Controller
public class VehicleRegisterController {

	@Autowired
	private VehicleService vehicleService;

	@ModelAttribute("vehicle")
	public VehicleRegsDTO vehicleRegsDTO() {

		return new VehicleRegsDTO();
	}

	@GetMapping("/vehicleRegister")
	public String register(Model model) {
		return "vehicleRegister";
	}

	@PostMapping("/vehicleRegister")
	public String vehicleRegister(@ModelAttribute("vehicle") @Valid VehicleRegsDTO vehicleDTO, BindingResult result) {

		Vehicle existingUser = vehicleService.findByLincence(vehicleDTO.getLicence());

		if (existingUser != null) {
			result.rejectValue("licence", null, "There is already an car registered with this licence!");
		}

		if (result.hasErrors()) {
			return "vehicleRegister";
		}

		vehicleService.save(vehicleDTO);

		return "redirect:/register?success";
	}

}
