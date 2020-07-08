package Car.Auto.Mechanic.Services;



import Car.Auto.Mechanic.DTO.BookingDTO;
import Car.Auto.Mechanic.Entity.Booking;
import Car.Auto.Mechanic.Entity.Vehicle;

public interface BookingService {

	Booking  findbyVehicle (Vehicle vehicle);
	
	Booking save (BookingDTO bookingDTO);
}
