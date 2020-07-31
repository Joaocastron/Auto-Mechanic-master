package Car.Auto.Mechanic.Repository;

import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import Car.Auto.Mechanic.Entity.Supply;

@Repository(value = "supplyRepository")
public interface SupplyRepository extends JpaRepository<Supply, Long> {
	
	@Query(value = "SELECT * FROM supply", nativeQuery = true)
	Set<Supply> getAll();

	@Query(value = "SELECT * FROM supply where supply_name=:supplyName", nativeQuery = true)
	Supply findBySupplyName(String supplyName);

}
