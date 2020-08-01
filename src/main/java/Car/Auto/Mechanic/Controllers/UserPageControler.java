package Car.Auto.Mechanic.Controllers;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import Car.Auto.Mechanic.DTO.UserPageDTO;
import Car.Auto.Mechanic.Entity.Booking;
import Car.Auto.Mechanic.Entity.User;
import Car.Auto.Mechanic.Entity.Vehicle;
import Car.Auto.Mechanic.Repository.BookingRepository;
import Car.Auto.Mechanic.Repository.VehicleRepository;
import Car.Auto.Mechanic.Services.UserService;

@Controller
public class UserPageControler {

	@Autowired
	private UserService userService;
	
	@Autowired
	private VehicleRepository vehicleRepository;
	
	@Autowired
	private BookingRepository bookingRepository;

	public String Owner() {

		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		if (!(authentication instanceof AnonymousAuthenticationToken)) {
			String currentUserName = authentication.getName();
			return currentUserName;
		}
		return null;
	}

	@GetMapping("/userPage")
	public String userPage(Model model) {
		return "userPage";
	}
	
	@ModelAttribute("userPage")
	public UserPageDTO userPageDTO() {
		UserPageDTO userPageDTO = new UserPageDTO();
		
		String name = Owner();
		User user = userService.findByEmail(name);
		userPageDTO.setUser(user);
		
		List<Vehicle> vehicle = vehicleRepository.findbyUser(user.getId());
		userPageDTO.setVehicles(vehicle);
		
		List <Booking> booking = bookingRepository.findByUser(user.getId());		
		userPageDTO.setBooking(booking);
		
		return userPageDTO;
	}

}
