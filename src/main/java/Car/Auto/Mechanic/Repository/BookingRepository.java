package Car.Auto.Mechanic.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import Car.Auto.Mechanic.Entity.Booking;
import Car.Auto.Mechanic.Entity.Vehicle;

@Repository(value ="bookingRepository")
public interface BookingRepository extends JpaRepository<Booking, Long> {
	
	@Query (value="SELECT * FROM booking where vehicle_id =:vehicle_id", nativeQuery = true)
	Booking findByVehicle (long vehicle_id);	
	
	@Query(value="SELECT * FROM vehicle where owner_id =:owner_id", nativeQuery = true)
	Vehicle findByUser (long owner_id);
	
	@Query(value="SELECT COUNT(id) FROM booking WHERE status = 0 AND vehicle_id = (SELECT id FROM vehicle WHERE licence =:vehicleLicence)", nativeQuery = true)
	int isBooked (String vehicleLicence);


}
