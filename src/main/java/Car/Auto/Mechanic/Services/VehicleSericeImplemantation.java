package Car.Auto.Mechanic.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import Car.Auto.Mechanic.DTO.VehicleRegistrationDTO;
import Car.Auto.Mechanic.Entity.Vehicle;
import Car.Auto.Mechanic.Repository.VehicleRepository;

@Service
public class VehicleSericeImplemantation implements VehicleService {

	@Autowired
	private VehicleRepository vehicleRepository;

	@Override
	public Vehicle findByLicence(String licence) {
		// TODO Auto-generated method stub
		return vehicleRepository.findByLicence(licence);
	}

	@Override
	public Vehicle save(VehicleRegistrationDTO vehicleDTO) {

		Vehicle vehicle = new Vehicle();

		vehicle.setMake(vehicleDTO.getMake());
		vehicle.setModel(vehicleDTO.getModel());
		vehicle.setYear(vehicleDTO.getYear());
		vehicle.setLicence(vehicleDTO.getLicence());
		vehicle.setComments(vehicle.getComments());
		return vehicleRepository.save(vehicle);

		
	}

}
