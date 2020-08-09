package Car.Auto.Mechanic.Controllers;

import java.util.HashSet;
import java.util.Set;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import Car.Auto.Mechanic.DTO.InvoiceDTO;
import Car.Auto.Mechanic.DTO.SupplyDTO;
import Car.Auto.Mechanic.Entity.Booking;
import Car.Auto.Mechanic.Entity.Invoice;
import Car.Auto.Mechanic.Entity.Supply;
import Car.Auto.Mechanic.Services.BookingService;
import Car.Auto.Mechanic.Services.InvoiceService;
import Car.Auto.Mechanic.Services.SupplyService;

@Controller
public class EditController {

	// instantiation of repositories and services needed
	@Autowired
	private BookingService bookingService;

	@Autowired
	private InvoiceService invoiceService;

	@Autowired
	private SupplyService supplyService;

	// GET http://localhost:8080/editBooking
	@GetMapping("/editBooking")
	public String editInvoice(Model model) {
		return "editBooking";
	}

	@ModelAttribute("invoice")
	public InvoiceDTO invoiceDTO(Long bookingId) {

		InvoiceDTO invoiceDTO = new InvoiceDTO();

		Booking booking = bookingService.findById(bookingId);

		invoiceDTO.setBooking(booking);

		Set<Supply> supplies = supplyService.getAll();

		Set<SupplyDTO> suppliesDTO = new HashSet<>();

		for (Supply supply : supplies) {
			suppliesDTO.add(new SupplyDTO(supply));
		}

		invoiceDTO.setSupplies(suppliesDTO);

		return invoiceDTO;
	}

	
	@PostMapping("/editBooking")
	public String saveInvoice(@ModelAttribute("invoice") @Valid InvoiceDTO invoiceDTO, BindingResult result) {

		Invoice invoice = new Invoice();

		Set<Supply> supplies = new HashSet<>();

		for (SupplyDTO supplyDTO : invoiceDTO.getSupplies()) {
			if (supplyDTO.isAdded()) {
				supplies.add(new Supply(supplyDTO));
			}
		}

		Booking booking = invoiceDTO.getBooking();
		booking.setStatus(invoiceDTO.getStatus());
		booking.setPrice(invoiceDTO.getPrice());
		booking.setComments(invoiceDTO.getBookingComments());

		invoice.setBooking(booking);
		invoice.setSupplies(supplies);

		bookingService.save(booking);
		invoiceService.save(invoice);

		return "redirect:/search";
	}

}
