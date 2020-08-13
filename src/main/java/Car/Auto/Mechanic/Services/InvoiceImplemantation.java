package Car.Auto.Mechanic.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import Car.Auto.Mechanic.DTO.editBookingDTO;
import Car.Auto.Mechanic.Entity.Invoice;
import Car.Auto.Mechanic.Repository.InvoiceRepository;

@Service
public class InvoiceImplemantation implements InvoiceService {

	@Autowired
	private InvoiceRepository invoiceRepository;

	@Override
	public Invoice save(Invoice invoice) {

		return invoiceRepository.save(invoice);
	}

	@Override
	public Invoice save(editBookingDTO invoiceDTO) {
		
		Invoice invoice = new Invoice();
		return invoiceRepository.save(invoice);
	}

}
