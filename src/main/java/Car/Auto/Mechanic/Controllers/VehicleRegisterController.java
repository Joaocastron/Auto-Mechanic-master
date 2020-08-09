
package Car.Auto.Mechanic.Controllers;

import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import Car.Auto.Mechanic.DTO.VehicleRegsDTO;
import Car.Auto.Mechanic.Entity.Vehicle;
import Car.Auto.Mechanic.Services.VehicleService;

@Controller
public class VehicleRegisterController {

	// instantiation of repositories and services needed
	@Autowired
	private VehicleService vehicleService;

	// model attribute for vehicleDTO creating new vehicle
	@ModelAttribute("vehicle")
	public VehicleRegsDTO vehicleRegsDTO() {

		return new VehicleRegsDTO();
	}

	// GET http://localhost:8080/vehicleRegister
	@GetMapping("/vehicleRegister")
	public String register(Model model) {
		return "vehicleRegister";
	}
	// POST http://localhost:8080/vehicleRegister
	@PostMapping("/vehicleRegister")
	public String vehicleRegister(@ModelAttribute("vehicle") @Valid VehicleRegsDTO vehicleDTO, BindingResult result) {

		// checking if there is  vehicle with the same license in the data bases
		Vehicle existingVehicle = vehicleService.findByLincence(vehicleDTO.getLicence());

		if (existingVehicle != null) {
			result.rejectValue("licence", null, "There is already an car registered with this licence!");
		}

		if (result.hasErrors()) {
			return "vehicleRegister";
		}

		vehicleService.save(vehicleDTO);

		return "redirect:/userPage?success";
	}

}
