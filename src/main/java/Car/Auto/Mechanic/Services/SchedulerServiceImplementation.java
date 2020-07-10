package Car.Auto.Mechanic.Services;

import org.springframework.stereotype.Service;
import java.time.*;
import java.util.ArrayList;

@Service
public class SchedulerServiceImplementation implements SchedulerService {

    public ArrayList<LocalDate> getFreeSpot() {
        LocalDate date = LocalDate.now();
        ArrayList<LocalDate> datesAvailable = new ArrayList<LocalDate>();

        int count = 7;
        while (count > 0) {
            if (date.getDayOfWeek() != DayOfWeek.SUNDAY) {
                datesAvailable.add(date);
            }
            date = date.plusDays(1);
            count--;
        }

        // Here we remove the dates with appointments
        

        return datesAvailable;
    }
}