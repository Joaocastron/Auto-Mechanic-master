package Car.Auto.Mechanic.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import Car.Auto.Mechanic.Entity.Role;
import Car.Auto.Mechanic.Entity.User;

//JPA Hibernate repository for User. calling queries from the databases when required returning information from the database.

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

	// some  requires are already implemented by spring boot
	
	User findByEmail(String email);

	User findByName(String name);

	User findById(long id);

	@Query(value = "SELECT * FROM role WHERE name = 'ROLE_CUSTOMER'", nativeQuery = true)
	Role getCustomerRole();

}