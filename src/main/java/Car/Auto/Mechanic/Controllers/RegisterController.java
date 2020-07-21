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
import Car.Auto.Mechanic.Entity.User;
import Car.Auto.Mechanic.Services.UserService;

@Controller
public class RegisterController {

	// Let the service available
	@Autowired
	private UserService userService;

	// Create e new user to be sent on the Get request
	@ModelAttribute("user")
	public UserRegistrationDTO userRegistrationDTO() {
		return new UserRegistrationDTO();
	}

	@GetMapping("/register")
	public String register(Model model) {
		return "register";
	}

	@PostMapping("/register")
	public String register(@ModelAttribute("user") @Valid UserRegistrationDTO userDTO, BindingResult result) {

		User existingUser = userService.findByEmail(userDTO.getEmail());

		if (existingUser != null) {
			result.rejectValue("email", null, "There is already an account registered with this e-mail!");
		}

		if (result.hasErrors()) {
			return "register";
		}

		userService.save(userDTO);

		return "redirect:/login?success";
	}
}