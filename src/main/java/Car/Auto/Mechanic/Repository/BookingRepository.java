package Car.Auto.Mechanic.Repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import Car.Auto.Mechanic.Entity.Booking;

@Repository(value = "bookingRepository")
public interface BookingRepository extends JpaRepository<Booking, Long> {

	@Query(value = "SELECT * FROM booking where vehicle_id =:vehicle_id", nativeQuery = true)
	Booking findByVehicle(long vehicle_id);

	@Query(value = "SELECT COUNT(id) FROM booking WHERE status = 0 AND vehicle_id = (SELECT id FROM vehicle WHERE licence =:vehicleLicence)", nativeQuery = true)
	int isBooked(String vehicleLicence);

	@Query(value = "SELECT * FROM booking WHERE time_stamp >=:startDate AND time_stamp <=:endDate", nativeQuery = true)
	List<Booking> getByPeriod(LocalDate startDate, LocalDate endDate);

}
