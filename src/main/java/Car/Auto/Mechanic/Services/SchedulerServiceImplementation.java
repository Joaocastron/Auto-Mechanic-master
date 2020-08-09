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

	// booking service instantiation
	@Autowired
	public BookingService bookingService;

	// method for schedule spot
	public ArrayList<LocalDate> getFreeSpot() {

		// declaring present date
		LocalDate date = LocalDate.now();

		// array of dates open for booking
		ArrayList<LocalDate> datesAvailable = new ArrayList<LocalDate>();

		// variable defining the quantity of days available
		int count = 15;

		// looping for Sundays exclusion
		while (count > 0) {

			if (date.getDayOfWeek() != DayOfWeek.SUNDAY) {
				datesAvailable.add(date);
			}

			date = date.plusDays(1);
			count--;
		}

		// list of booking already booked from repository
		List<Booking> bookings = bookingService.getByPeriod(LocalDate.now(), date);

		// list of dates to be removed from availability for being already full f
		// booking
		ArrayList<LocalDate> datesToRemove = new ArrayList<LocalDate>();

		// looping dates available
		for (LocalDate dateAvailable : datesAvailable) {

			// variable holding booking type weight
			int count1 = 0;

			// checking each booking
			for (Booking booking : bookings) {

				// getting booking for the present date
				if (booking.getTimeStamp().isEqual(dateAvailable)) {

					// if booking type is equals Major the weight is 4 double than others
					if (booking.getType().equals(BookingType.Major)) {
						count1 += 4;
					} else {
						count1 += 2;
					}
				}
			}

			// add dates in the list for removing
			if (count1 >= 8) {
				datesToRemove.add(dateAvailable);
			}
		}
		// removing date where the weight is more than 8 considering 4 staff who are
		// able to do 2 repairs a day.
		datesAvailable.removeAll(datesToRemove);

		return datesAvailable;
	}
}