package Car.Auto.Mechanic.Services;

import Car.Auto.Mechanic.DTO.SupplyDTO;
import Car.Auto.Mechanic.Entity.Supply;

public interface SupplyService {
	
	Supply findBySupplyName (String supplyName);
	
	Supply save(SupplyDTO suppliesDTO);

}
