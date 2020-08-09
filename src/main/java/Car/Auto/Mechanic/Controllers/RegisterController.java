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

	// instantiation of repositories and services needed
	@Autowired
	private UserService userService;

	// model attribute for UserDTO creating new user 
	@ModelAttribute("user")
	public UserRegistrationDTO userRegistrationDTO() {
		return new UserRegistrationDTO();
	}

	// GET http://localhost:8080/registers
	@GetMapping("/register")
	public String register(Model model) {
		return "register";
	}

	// POST http://localhost:8080/registers
	@PostMapping("/register")
	public String register(@ModelAttribute("user") @Valid UserRegistrationDTO userDTO, BindingResult result) {

		// checking if the user already is in the database
		User existingUser = userService.findByEmail(userDTO.getEmail());

		if (existingUser != null) {
			result.rejectValue("email", null, "There is already an account registered with this e-mail!");
		}

		if (result.hasErrors()) {
			return "register";
		}

		//saving new user
		userService.save(userDTO);

		return "redirect:/login?success";
	}
}