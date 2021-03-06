package Car.Auto.Mechanic.Repository;

import java.time.LocalDate;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import Car.Auto.Mechanic.Entity.Booking;
import Car.Auto.Mechanic.Models.Status;

//JPA Hibernate repository for bookings. calling queries from the databases when required returning information from the database.

@Repository(value = "bookingRepository")
public interface BookingRepository extends JpaRepository<Booking, Long> {

	@Query(value = "SELECT * FROM booking where vehicle_id =:vehicle_id", nativeQuery = true)
	Booking findByVehicle(long vehicle_id);

	@Query(value = "SELECT COUNT(id) FROM booking WHERE status = 0 AND vehicle_id = (SELECT id FROM vehicle WHERE licence =:vehicleLicence)", nativeQuery = true)
	int isBooked(String vehicleLicence);

	@Query(value = "SELECT * FROM booking WHERE time_stamp >=:startDate AND time_stamp <=:endDate", nativeQuery = true)
	List<Booking> getByPeriod(LocalDate startDate, LocalDate endDate);

	@Query(value = "SELECT * FROM booking WHERE status =:status", nativeQuery = true)
	List<Booking> getByStatus(int status);

	@Query(value = "SELECT * FROM booking WHERE customer_id=:user_id", nativeQuery = true)
	List<Booking> findByUser(long user_id);

	@Query(value = "SELECT * FROM booking WHERE id =:id", nativeQuery = true)
	Booking findById(long id);

	@Query(value = "SELECT * FROM booking INNER JOIN user ON booking.customer_id=user.id WHERE booking.id =:bookingId OR user.name =:customerName OR user.phone =:customerPhone OR booking.status =:status", nativeQuery = true)
	List<Booking> findBySearch(String customerName, String customerPhone, long bookingId, Status status);
}
