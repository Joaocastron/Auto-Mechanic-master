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
import Car.Auto.Mechanic.Entity.Booking;
import Car.Auto.Mechanic.Entity.Vehicle;
import Car.Auto.Mechanic.Services.BookingService;
import Car.Auto.Mechanic.Services.SchedulerService;
import Car.Auto.Mechanic.Services.VehicleService;

@Controller
public class BookingController {

	@Autowired
	private BookingService bookingService;

	@Autowired
	private SchedulerService schedulerService;
	@Autowired
	private VehicleService vehicleService;

	@ModelAttribute("booking")
	public BookingDTO bookingDTO() {

		return new BookingDTO();
	}

	@ModelAttribute("allVehicle")
	public List<Vehicle> populateVehicles() {
		return bookingService.findByUser();
	}

	@ModelAttribute("availableDates")
	public ArrayList<LocalDate> getAvailableDates() {
		ArrayList<LocalDate> dates = schedulerService.getFreeSpot();
		return dates;
	}

	@GetMapping("/booking")
	public String booking(Model model) {
		return "booking";
	}

	@PostMapping("/booking")
	public String BookingRegister(@ModelAttribute("booking") @Valid BookingDTO bookingDTO, BindingResult result) {

		// Verify existing bookings
		Booking existingBooking = bookingService.findbyVehicle(bookingDTO.getVehicle());

		if (existingBooking != null) {

			result.rejectValue("Vehicle", null, "There is a booking already made");
		}
		if (result.hasErrors()) {
			return "booking";
		}

		// Save booking
		bookingService.save(bookingDTO);

		return "redirect:/booking?success";
	}
}