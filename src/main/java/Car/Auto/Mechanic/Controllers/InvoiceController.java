package Car.Auto.Mechanic.Controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import Car.Auto.Mechanic.DTO.InvoiceDTO;
import Car.Auto.Mechanic.DTO.VehicleRegsDTO;
import Car.Auto.Mechanic.Entity.Booking;
import Car.Auto.Mechanic.Models.Status;
import Car.Auto.Mechanic.Repository.BookingRepository;
import Car.Auto.Mechanic.Services.BookingService;

@Controller
public class InvoiceController {

	@Autowired
	private BookingService bookingService;

	@GetMapping("/createInvoice")
	public String createInvoice(Model model) {
		return "createInvoice";
	}

	@ModelAttribute("allBookings")
	public List<Booking> populateBooking() {
		return bookingService.getByStatus(Status.InService);
	}

	@ModelAttribute("invoice")
	public InvoiceDTO invoiceDTO() {

		return new InvoiceDTO();
	}

	@PostMapping("/createInvoice")
	public String saveInvoice(@ModelAttribute("invoice") @Valid InvoiceDTO invoiceDTO, BindingResult result) {

		return null;

	}
}
