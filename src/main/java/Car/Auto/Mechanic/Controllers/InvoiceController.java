package Car.Auto.Mechanic.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

import Car.Auto.Mechanic.DTO.InvoiceDTO;
import Car.Auto.Mechanic.Entity.Booking;
import Car.Auto.Mechanic.Entity.User;
import Car.Auto.Mechanic.Services.BookingService;
import Car.Auto.Mechanic.Services.UserService;

@Controller
public class InvoiceController {

	@Autowired
	private BookingService bookingService;
	@Autowired
	private UserService userService;

	@ModelAttribute("invoice")
	public InvoiceDTO invoceDTO(Long bookingId) {

		InvoiceDTO invoiceDTO = new InvoiceDTO();

		Booking booking = bookingService.findById(bookingId);

		User user = userService.findById(booking.getCustomer().getId());

		invoiceDTO.setBooking(booking);
		invoiceDTO.setUser(user);

		return invoiceDTO;

	}

	@GetMapping("/invoice")
	public String invoice(Model model) {
		return "invoice";

	}

}