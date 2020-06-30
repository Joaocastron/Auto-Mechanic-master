package Car.Auto.Mechanic.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import Car.Auto.Mechanic.Entity.Vehicle;

@Repository
public interface VehicleRepository extends JpaRepository<Vehicle, String> {

	Vehicle findByLicence(String licence);
}
