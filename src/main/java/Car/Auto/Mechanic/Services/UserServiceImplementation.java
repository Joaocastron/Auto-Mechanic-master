package Car.Auto.Mechanic.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import Car.Auto.Mechanic.DTO.UserRegistrationDTO;
import Car.Auto.Mechanic.Entity.User;
import Car.Auto.Mechanic.Repository.UserRepository;

@Service
public class UserServiceImplementation implements UserService {

	@Autowired
	private UserRepository userRepository;

	public User findByEmail(String email) {
		return userRepository.findByEmail(email);
	}

	public User save(UserRegistrationDTO userDTO) {
		User user = new User();

		user.setName(userDTO.getName());
		user.setSurname(userDTO.getSurname());
		user.setPhone(userDTO.getPhone());
		user.setEmail(userDTO.getEmail());
		user.setPassword(userDTO.getPassword());
		
		return userRepository.save(user);
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		return null;
	}
}