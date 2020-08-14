package Car.Auto.Mechanic.Controllers;

import java.util.HashSet;
import java.util.Set;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import Car.Auto.Mechanic.DTO.editBookingDTO;
import Car.Auto.Mechanic.DTO.SupplyDTO;
import Car.Auto.Mechanic.Entity.Booking;
import Car.Auto.Mechanic.Entity.Supply;
import Car.Auto.Mechanic.Services.BookingService;
import Car.Auto.Mechanic.Services.SupplyService;

@Controller
public class EditController {

	// instantiation of repositories and services needed
	@Autowired
	private BookingService bookingService;

	@Autowired
	private SupplyService supplyService;

	/*
	 * @ModelAttribute("bookingEdit") public editBookingDTO editDTO(Long bookingId)
	 * {
	 * 
	 * if(bookingId == null) { return new editBookingDTO(); }
	 * 
	 * editBookingDTO editDTO = new editBookingDTO();
	 * 
	 * Booking booking = bookingService.findById(bookingId);
	 * 
	 * editDTO.setBooking(booking);
	 * 
	 * Set<Supply> supplies = supplyService.getAll();
	 * 
	 * Set<SupplyDTO> suppliesDTO = new HashSet<>();
	 * 
	 * for (Supply supply : supplies) { suppliesDTO.add(new SupplyDTO(supply)); }
	 * 
	 * editDTO.setSupplies(suppliesDTO);
	 * 
	 * return editDTO; }
	 */

	// GET http://localhost:8080/editBooking
	@GetMapping("/editBooking")
	public String editInvoice(Model model, Long bookingId) {

		editBookingDTO editDTO = new editBookingDTO();

		Booking booking = bookingService.findById(bookingId);

		editDTO.setBooking(booking);

		Set<Supply> supplies = supplyService.getAll();

		Set<SupplyDTO> suppliesDTO = new HashSet<>();

		for (Supply supply : supplies) {
			suppliesDTO.add(new SupplyDTO(supply));
		}

		editDTO.setSupplies(suppliesDTO);
		model.addAttribute("bookingEdit", editDTO);
		return "editBooking";
	}

	@PostMapping("/editBooking")
	public String saveInvoice(editBookingDTO editDTO, BindingResult result) {

		// Invoice invoice = new Invoice();

		Set<Supply> supplies = new HashSet<>();

		for (SupplyDTO supplyDTO : editDTO.getSupplies()) {
			if (supplyDTO.isAdded()) {
				supplies.add(new Supply(supplyDTO));
			}
		}

		Booking booking = editDTO.getBooking();
		booking.setStatus(editDTO.getStatus());
		booking.setPrice(editDTO.getPrice());
		booking.setComments(editDTO.getBookingComments());
		booking.setSupplies(supplies);

		bookingService.save(booking);

		return "redirect:/search";
	}

}
