package Car.Auto.Mechanic.Services;

import Car.Auto.Mechanic.DTO.editBookingDTO;
import Car.Auto.Mechanic.Entity.Invoice;

//Invoice Service interface holding requests from repository and salving requests in it.
public interface InvoiceService {
	
	Invoice save(Invoice invoice);
	
	Invoice save(editBookingDTO invoiceDTO);

}
