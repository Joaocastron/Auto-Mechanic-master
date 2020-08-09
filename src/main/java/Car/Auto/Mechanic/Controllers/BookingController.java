package Car.Auto.Mechanic.Controllers;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import Car.Auto.Mechanic.DTO.BookingDTO;
import Car.Auto.Mechanic.Entity.Vehicle;
import Car.Auto.Mechanic.Services.BookingService;
import Car.Auto.Mechanic.Services.SchedulerService;

@Controller
public class BookingController {

	// instantiation of repositories and services needed
	@Autowired
	private BookingService bookingService;

	@Autowired
	private SchedulerService schedulerService;

	// model attribute for bookingDTO creating new booking 
	@ModelAttribute("booking")
	public BookingDTO bookingDTO() {

		return new BookingDTO();
	}

	// model returning all the vehicle the logged user has.
	@ModelAttribute("allVehicle")
	public List<Vehicle> populateVehicles() {
		return bookingService.findByUser();
	}

	// model for the available dates
	@ModelAttribute("availableDates")
	public ArrayList<LocalDate> getAvailableDates() {
		ArrayList<LocalDate> dates = schedulerService.getFreeSpot();
		return dates;
	}

	// GET http://localhost:8080/booking
	@GetMapping("/booking")
	public String booking(Model model) {
		return "booking";
	}

	// Post http://localhost:8080/booking
	@PostMapping("/booking")
	public String BookingRegister(@ModelAttribute("booking") @Valid BookingDTO bookingDTO, BindingResult result) {

		// saving bookings
		bookingService.save(bookingDTO);

		return "redirect:/userPage?success";
	}
}