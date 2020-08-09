package Car.Auto.Mechanic.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import Car.Auto.Mechanic.DTO.UserRegistrationDTO;
import Car.Auto.Mechanic.Entity.User;
import Car.Auto.Mechanic.Repository.UserRepository;

@Service
public class UserServiceImplementation implements UserService {

	// instantiation of user repository
	@Autowired
	private UserRepository userRepository;

	// instantiation password encoder
	@Autowired
	private BCryptPasswordEncoder passwordEncoder;

	// method returning requests for user  from the repository
	public User findByEmail(String email) {
		return userRepository.findByEmail(email);
	}

	public User findByName(String name) {
		return userRepository.findByName(name);
	}

	@Override
	public User findById(long id) {

		return userRepository.findById(id);
	}

	// method saving user in the repository
	public User save(UserRegistrationDTO userDTO) {
		User user = new User();
		user.setName(userDTO.getName());
		user.setSurname(userDTO.getSurname());
		user.setPhone(userDTO.getPhone());
		user.setEmail(userDTO.getEmail());
		user.setPassword(passwordEncoder.encode(userDTO.getPassword()));

		return userRepository.save(user);
	}

	// user authentications methods 
	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		User user = userRepository.findByEmail(email);
		if (user == null) {
			throw new UsernameNotFoundException("Unable to authenticate, check yours credentials!");
		}

		return new org.springframework.security.core.userdetails.User(user.getEmail(), user.getPassword(),
				user.getAuthority());
	}

}