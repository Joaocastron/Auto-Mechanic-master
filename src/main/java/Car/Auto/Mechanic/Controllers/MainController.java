package Car.Auto.Mechanic.Controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {

	@GetMapping("/home")
	public String index() {
		return "home";
	}

	@GetMapping("/login")
	public String Login() {
		return "login";

	}

	@GetMapping("/homeApp")
	public String homeApp() {
		return "homeApp";

	}

	@GetMapping("/contacts")
	public String contacts() {
		return "contacts";

	}

	@GetMapping("/services")
	public String services() {
		return "services";

	}

}
