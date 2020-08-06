package Car.Auto.Mechanic.Controllers;

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
import Car.Auto.Mechanic.DTO.SearchBookingDTO;
import Car.Auto.Mechanic.Entity.Booking;
import Car.Auto.Mechanic.Entity.User;
import Car.Auto.Mechanic.Models.Status;
import Car.Auto.Mechanic.Repository.BookingRepository;
import Car.Auto.Mechanic.Services.UserService;

@Controller
public class SearchController {

	@Autowired
	private UserService userService;

	@Autowired
	private BookingRepository bookingRepository;
	
	private static SearchBookingDTO searchDTO = new SearchBookingDTO();
	
	@ModelAttribute("searchDTO")
	public SearchBookingDTO searchDTO() {
		return searchDTO;
	}

	@GetMapping("/search")
	public String search(Model model) {
		return "search";
	}

	@PostMapping("search")
	public String seachDTO(@ModelAttribute("searchDTO") @Valid SearchBookingDTO searchDTO, BindingResult result) {

		String customerName = searchDTO.getGetName();
		String customerPhone = searchDTO.getGetPhone();
		Long bookingId = searchDTO.getGetBookingId();
		
		Status status = searchDTO.getGetStatus();
		

		List<Booking> booking = bookingRepository.findBySearch(customerName, customerPhone, bookingId, status);
		
		searchDTO.setBooking(booking);

		return "redirect:/search";

	}

}
