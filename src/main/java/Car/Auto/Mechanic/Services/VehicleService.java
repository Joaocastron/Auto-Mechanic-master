package Car.Auto.Mechanic.Services;

import java.util.List;

import Car.Auto.Mechanic.DTO.VehicleRegsDTO;
import Car.Auto.Mechanic.Entity.Vehicle;

public interface VehicleService {

	Vehicle findByLincence(String licence);

	List<Vehicle> findByUser();

	Vehicle save(VehicleRegsDTO vehicleRegsDTO);

}
