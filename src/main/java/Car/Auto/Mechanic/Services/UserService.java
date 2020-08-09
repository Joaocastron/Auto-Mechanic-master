package Car.Auto.Mechanic.Services;

import org.springframework.security.core.userdetails.UserDetailsService;
import Car.Auto.Mechanic.DTO.UserRegistrationDTO;
import Car.Auto.Mechanic.Entity.User;

//User Service interface holding  requests from repository the salving requests in it.
public interface UserService extends UserDetailsService {

	User findByEmail(String email);

	User findByName(String name);

	User findById(long id);

	User save(UserRegistrationDTO userDTO);
}