package Car.Auto.Mechanic.Services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import Car.Auto.Mechanic.DTO.VehicleRegsDTO;
import Car.Auto.Mechanic.Entity.User;
import Car.Auto.Mechanic.Entity.Vehicle;
import Car.Auto.Mechanic.Repository.VehicleRepository;

@Service
public class VehicleServiceImplementation implements VehicleService {

	@Autowired
	private VehicleRepository vehicleRepository;

	@Autowired
	private UserService UserService;

	@Override
	public Vehicle findByLincence(String licence) {
		return vehicleRepository.findbyLicence(licence);
	}

	@Override
	public List<Vehicle> findByUser() {
		String name = Owner();
		if (name != null) {
			User user = UserService.findByEmail(name);
			return vehicleRepository.findbyUser(user.getId());
		}
		return null;
	}

	public String Owner() {

		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		if (!(authentication instanceof AnonymousAuthenticationToken)) {
			String currentUserName = authentication.getName();
			return currentUserName;
		}
		return null;
	}

	public Vehicle save(VehicleRegsDTO vehicleDTO) {

		Vehicle vehicle = new Vehicle();

		String name = Owner();
		User user = UserService.findByEmail(name);

		vehicle.setUser(user);
		vehicle.setMake(vehicleDTO.getMake());
		vehicle.setModel(vehicleDTO.getModel());
		vehicle.setYear(vehicleDTO.getYear());
		vehicle.setEngine(vehicleDTO.getEngine());
		vehicle.setLicence(vehicleDTO.getLicence());
		vehicle.setComments(vehicleDTO.getComments());

		return vehicleRepository.save(vehicle);

	}

}
