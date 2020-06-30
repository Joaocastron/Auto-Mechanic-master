package Car.Auto.Mechanic.Services;

import org.springframework.security.core.userdetails.UserDetailsService;

import Car.Auto.Mechanic.DTO.UserRegistrationDTO;
import Car.Auto.Mechanic.Entity.User;

public interface UserService extends UserDetailsService {
    User findByEmail(String email);

    User save(UserRegistrationDTO userDTO);
}