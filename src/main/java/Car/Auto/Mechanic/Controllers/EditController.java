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

@Controller
public class EditController {
	
	@Autowired
	private BookingService bookingService;
	
	@Autowired
	private InvoiceService invoiceService;
	
	
	@ModelAttribute("booking")
	public InvoiceDTO invoiceDTO(long bookingId) {
		
		InvoiceDTO invoiceDTO = new InvoiceDTO();
			
		Booking booking = bookingService.findById(bookingId);
		
		invoiceDTO.setBooking(booking);
		
		return invoiceDTO;
	}
	
	
	@GetMapping("/editBooking")
	public String editInvoice(Model model) {
		return "editBooking";
	}
	
	@PostMapping("/editBooking")
	public String saveInvoice(@ModelAttribute("booking") @Valid InvoiceDTO invoiceDTO, BindingResult result) {
		
		Invoice invoice = new Invoice();
		
		
		Set<Supply> supplies = new HashSet<>();

		for (SupplyDTO supplyDTO : invoiceDTO.getSupplies()) {
			if (supplyDTO.isAdded()) {
				supplies.add(new Supply(supplyDTO));
			}
		}

		Booking booking = invoiceDTO.getBooking();
		// booking.setStatus(Status.Completed);
		booking.setComments(invoiceDTO.getBookingComments());
		
		invoice.setBooking(booking);
		invoice.setSupplies(supplies);

		bookingService.save(booking);
		invoiceService.save(invoice);
		return null;
	}

}
