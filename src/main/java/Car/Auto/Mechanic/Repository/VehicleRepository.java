package Car.Auto.Mechanic.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import Car.Auto.Mechanic.Entity.Vehicle;
@Repository(value = "VehicleRepository")
public interface VehicleRepository extends JpaRepository<Vehicle, Long>{

	@Query(value="SELECT * FROM vehicle where licence =:licence ", nativeQuery = true)
	Vehicle findbyLicence (String licence);
}
