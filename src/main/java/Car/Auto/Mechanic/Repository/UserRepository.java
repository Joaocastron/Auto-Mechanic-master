package Car.Auto.Mechanic.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import Car.Auto.Mechanic.Entity.Role;
import Car.Auto.Mechanic.Entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

	User findByEmail(String email);

	User findByName(String name);
	
	User findById (long id);

	@Query(value = "SELECT * FROM role WHERE name = 'ROLE_CUSTOMER'", nativeQuery = true)
	Role getCustomerRole();

}