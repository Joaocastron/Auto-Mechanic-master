package Car.Auto.Mechanic.Services;

import Car.Auto.Mechanic.DTO.VehicleRegsDTO;
import Car.Auto.Mechanic.Entity.Vehicle;

//Vehicle Service interface holding  requests from repository the salving requests in it.
public interface VehicleService {

	Vehicle findByLincence(String licence);

	Vehicle save(VehicleRegsDTO vehicleRegsDTO);

}
