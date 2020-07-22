package Car.Auto.Mechanic.Services;

import Car.Auto.Mechanic.DTO.VehicleRegsDTO;
import Car.Auto.Mechanic.Entity.Vehicle;

public interface VehicleService {

	Vehicle findByLincence(String licence);

	Vehicle save(VehicleRegsDTO vehicleRegsDTO);

}
