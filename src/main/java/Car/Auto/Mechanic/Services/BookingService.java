package Car.Auto.Mechanic.Services;

import java.time.LocalDate;
import java.util.List;
import Car.Auto.Mechanic.DTO.BookingDTO;
import Car.Auto.Mechanic.Entity.Booking;
import Car.Auto.Mechanic.Entity.Vehicle;
import Car.Auto.Mechanic.Models.Status;

// Booking Service interface holding  requests from repository and salving requests in it.
public interface BookingService {

	Booking findbyVehicle(long vehicle_id);

	List<Vehicle> findByUser();

	List<Booking> getByPeriod(LocalDate startDate, LocalDate endDate);

	Booking save(BookingDTO bookingDTO);

	List<Booking> getByStatus(Status status);

	List<Booking> findByUser(long userId);

	Booking findById(long id);

	Booking save(Booking booking);

	List<Booking> findBySearch(String customerName, String customerPhone, long bookingId, Status status);

}
