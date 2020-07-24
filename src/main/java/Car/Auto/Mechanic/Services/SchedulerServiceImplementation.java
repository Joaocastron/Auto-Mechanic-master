package Car.Auto.Mechanic.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import Car.Auto.Mechanic.Entity.Booking;
import Car.Auto.Mechanic.Models.BookingType;
import java.time.*;
import java.util.ArrayList;
import java.util.List;

@Service
public class SchedulerServiceImplementation implements SchedulerService {
	
	@Autowired
	public BookingService bookingService;

    public ArrayList<LocalDate> getFreeSpot() {
      
    	LocalDate date = LocalDate.now();
        
        ArrayList<LocalDate> datesAvailable = new ArrayList<LocalDate>();

        int count = 15;
        
        while (count > 0) {
        	
            if (date.getDayOfWeek() != DayOfWeek.SUNDAY) {
                datesAvailable.add(date);
            }
            
            date = date.plusDays(1);
            count--;
        }

        // Here remove the dates with appointments
        List<Booking> bookings = bookingService.getByPeriod(LocalDate.now(), date);
        
        ArrayList<LocalDate> datesToRemove = new ArrayList<LocalDate>();
        for(LocalDate dateAvailable : datesAvailable) {
        	int count1 = 0;
        	
        	for(Booking booking : bookings) {
        		if(booking.getTimeStamp().isEqual(dateAvailable)) {
        			if(booking.getType().equals(BookingType.Major)) {
        				count1+=4;
        			}
        			else {
        				count1+=2;
        			}
        		}
        	}
        	
        	if(count1 >= 8) {
        		datesToRemove.add(dateAvailable);
        	}
        }
        datesAvailable.removeAll(datesToRemove);

        return datesAvailable;
    }
}