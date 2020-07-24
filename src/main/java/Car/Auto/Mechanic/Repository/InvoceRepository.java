package Car.Auto.Mechanic.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import Car.Auto.Mechanic.Entity.Invoice;

@Repository
public interface InvoceRepository extends JpaRepository<Invoice, Long> {

}
