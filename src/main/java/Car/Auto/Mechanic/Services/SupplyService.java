package Car.Auto.Mechanic.Services;

import java.util.Set;

import Car.Auto.Mechanic.DTO.SupplyDTO;
import Car.Auto.Mechanic.Entity.Supply;

public interface SupplyService {
	
	Set<Supply> getAll();
	
	Supply findBySupplyName (String supplyName);
	
	Supply save(SupplyDTO suppliesDTO);

}
