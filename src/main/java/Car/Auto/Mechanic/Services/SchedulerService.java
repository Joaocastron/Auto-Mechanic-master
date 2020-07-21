package Car.Auto.Mechanic.Services;

import java.time.LocalDate;
import java.util.ArrayList;

public interface SchedulerService {
	
	ArrayList<LocalDate> getFreeSpot();
}
