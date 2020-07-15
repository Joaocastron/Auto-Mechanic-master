package Car.Auto.Mechanic.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import Car.Auto.Mechanic.Entity.Booking;
import Car.Auto.Mechanic.Entity.Vehicle;

@Repository(value ="bookingRepository")
public interface BookingRepository extends JpaRepository<Booking, Long> {
	
	@Query (value = "SELECT * FROM booking where vehicle =: vehicle",  nativeQuery = true)
	Booking findByVehicle (Vehicle vehicle);	
	
	@Query(value="SELECT * FROM vehicle where owner_id =:owner_id", nativeQuery = true)
	List<Vehicle> findbyUser (long owner_id);


}
