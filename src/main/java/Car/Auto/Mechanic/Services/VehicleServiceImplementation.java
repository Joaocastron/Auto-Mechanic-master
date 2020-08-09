package Car.Auto.Mechanic.Services;

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

	// repositories and services instantiations
	@Autowired
	private VehicleRepository vehicleRepository;

	@Autowired
	private UserService userService;

	// method returning vehicle by license
	@Override
	public Vehicle findByLincence(String licence) {
		return vehicleRepository.findbyLicence(licence);
	}

	// authentication method identifying logged user
	public String Owner() {

		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		if (!(authentication instanceof AnonymousAuthenticationToken)) {
			String currentUserName = authentication.getName();
			return currentUserName;
		}
		return null;
	}

	// method saving vehicles in the repository
	public Vehicle save(VehicleRegsDTO vehicleDTO) {

		Vehicle vehicle = new Vehicle();

		String name = Owner();
		User user = userService.findByEmail(name);

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
