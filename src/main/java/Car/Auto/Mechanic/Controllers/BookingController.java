package Car.Auto.Mechanic.Controllers;

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
import Car.Auto.Mechanic.Services.BookingService;

@Controller
public class BookingController {
	
	@Autowired
	private BookingService bookingService;
	
	@ModelAttribute("booking")
	public BookingDTO bookingDTO() {
		
		return new BookingDTO();
	}
	    
    @GetMapping("/booking")
    public String booking(Model model){
        return "booking";
    }
    
    @PostMapping("/booking")
    public String BookingRegister (@ModelAttribute ("booking")@Valid BookingDTO bookingDTO, BindingResult result) {
    	
    	Booking existingBooking = bookingService.findbyVehicle(bookingDTO.getVehicle());
    	
    	if (existingBooking != null) {
    		
    		result.reject("Vehicle", null, "There is a booking already made");
    	}
    	if (result.hasErrors()) {
    		return "booking";
    	}
    	
    	bookingService.save(bookingDTO);
    	
    	return "redirect:/booking?success";
    }
}