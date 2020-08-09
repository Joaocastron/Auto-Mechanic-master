package Car.Auto.Mechanic.Services;

import java.time.LocalDate;
import java.util.ArrayList;

//Schedule Service interface holding requests database for booking data.
public interface SchedulerService {
	
	ArrayList<LocalDate> getFreeSpot();
}
