package Car.Auto.Mechanic.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import Car.Auto.Mechanic.DTO.BookingDTO;
import Car.Auto.Mechanic.Entity.Booking;
import Car.Auto.Mechanic.Entity.Vehicle;
import Car.Auto.Mechanic.Repository.BookingRepository;

@Service
public class BookingServiceImplementation implements BookingService {

	@Autowired
	private BookingRepository bookingRepository;
	
	
	@Override
	public Booking findbyVehicle(Vehicle vehicle) {
		// TODO Auto-generated method stub
		return bookingRepository.findByVehicle(vehicle);
	}

	@Override
	public Booking save(BookingDTO bookingDTO) {
		// TODO Auto-generated method stub
		
		Booking booking = new Booking();
		
		booking.setVehicle(bookingDTO.getVehicle());
		booking.setType(bookingDTO.getType());
		booking.setDescription(bookingDTO.getDescription());
		booking.setTimeStamp(bookingDTO.getDate());
		return bookingRepository.save(booking);
	}

}
