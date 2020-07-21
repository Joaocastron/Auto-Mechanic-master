package Car.Auto.Mechanic.Services;

import java.util.List;

import Car.Auto.Mechanic.DTO.BookingDTO;
import Car.Auto.Mechanic.Entity.Booking;
import Car.Auto.Mechanic.Entity.Vehicle;

public interface BookingService {

	Booking findbyVehicle(long vehicle_id);

	List<Vehicle> findByUser();

	boolean isBooked(String vehicleLicence);

	Booking save(BookingDTO bookingDTO);

}
