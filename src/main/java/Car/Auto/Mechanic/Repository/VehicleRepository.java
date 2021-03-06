package Car.Auto.Mechanic.Repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import Car.Auto.Mechanic.Entity.Vehicle;

//JPA Hibernate repository for Vehicles. calling queries from the databases when required returning information from the database.

@Repository(value = "VehicleRepository")
public interface VehicleRepository extends JpaRepository<Vehicle, Long> {

	@Query(value = "SELECT * FROM vehicle where licence =:licence", nativeQuery = true)
	Vehicle findbyLicence(String licence);

	@Query(value = "SELECT * FROM vehicle where owner_id =:owner_id", nativeQuery = true)
	List<Vehicle> findbyUser(long owner_id);

}
