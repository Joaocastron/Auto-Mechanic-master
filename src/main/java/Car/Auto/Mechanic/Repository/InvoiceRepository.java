package Car.Auto.Mechanic.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import Car.Auto.Mechanic.Entity.Invoice;

//JPA Hibernate repository for invoice. calling queries from the databases when required returning information from the database.
@Repository
public interface InvoiceRepository extends JpaRepository<Invoice, Long> {

}
