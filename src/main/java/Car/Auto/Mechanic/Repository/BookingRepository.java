package Car.Auto.Mechanic.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import Car.Auto.Mechanic.Entity.Booking;
import Car.Auto.Mechanic.Entity.Vehicle;

@Repository(value ="bookingRepository")
public interface BookingRepository extends JpaRepository<Booking, Long> {
	
	@Query (value = "SELECT * FROM vehicle",  nativeQuery = true)
	Booking findByVehicle (Vehicle vehicle);	
	


}
