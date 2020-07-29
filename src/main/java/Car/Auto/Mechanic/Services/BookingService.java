package Car.Auto.Mechanic.Services;

import java.time.LocalDate;
import java.util.List;

import Car.Auto.Mechanic.DTO.BookingDTO;
import Car.Auto.Mechanic.Entity.Booking;
import Car.Auto.Mechanic.Entity.Vehicle;
import Car.Auto.Mechanic.Models.Status;

public interface BookingService {

	Booking findbyVehicle(long vehicle_id);

	List<Vehicle> findByUser();

	boolean isBooked(String vehicleLicence);
	
	List<Booking> getByPeriod(LocalDate startDate, LocalDate endDate);

	Booking save(BookingDTO bookingDTO);
	
	List<Booking> getByStatus(Status status);
	
	List<Booking> findByUser(long userId);
	
	

}
