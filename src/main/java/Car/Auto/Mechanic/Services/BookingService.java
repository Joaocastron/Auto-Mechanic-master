package Car.Auto.Mechanic.Services;



import java.util.List;

import Car.Auto.Mechanic.DTO.BookingDTO;
import Car.Auto.Mechanic.Entity.Booking;
import Car.Auto.Mechanic.Entity.Vehicle;

public interface BookingService {

	Booking  findbyVehicle (Vehicle vehicle);
	
	List<Vehicle> findByUser();
	
	Booking save(BookingDTO bookingDTO);
	
	
}
