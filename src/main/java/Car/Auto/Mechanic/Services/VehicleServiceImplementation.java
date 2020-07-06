package Car.Auto.Mechanic.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import Car.Auto.Mechanic.DTO.VehicleRegsDTO;
import Car.Auto.Mechanic.Entity.Vehicle;
import Car.Auto.Mechanic.Repository.VehicleRepository;

@Service
public class VehicleServiceImplementation implements VehicleService {

	@Autowired
	private VehicleRepository vehicleRepository;
	
	@Override
	public Vehicle findByLincence(String licence) {
		// TODO Auto-generated method stub
		return vehicleRepository.findbyLicence(licence);
	}
	public Vehicle save (VehicleRegsDTO vehicleDTO) {
		
		Vehicle vehicle = new Vehicle();
		
		vehicle.setMake(vehicleDTO.getMake());
		vehicle.setModel(vehicleDTO.getModel());
		vehicle.setLicence(vehicleDTO.getLicence());
		vehicle.setEngine(vehicleDTO.getEngine());
		vehicle.setYear(vehicleDTO.getYear());
		vehicle.setComments(vehicleDTO.getComments());
		
		return vehicleRepository.save(vehicle);
		
	}




	

}
