package Car.Auto.Mechanic.Services;

import Car.Auto.Mechanic.DTO.VehicleRegistrationDTO;
import Car.Auto.Mechanic.Entity.Vehicle;
import Car.Auto.Mechanic.Repository.VehicleRepository;


public interface VehicleService    {
	
    Vehicle findByLicence(String licence);

    Vehicle save(VehicleRegistrationDTO vehicleDTO);


	
	

}
