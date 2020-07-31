package Car.Auto.Mechanic.Services;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import Car.Auto.Mechanic.DTO.SupplyDTO;
import Car.Auto.Mechanic.Entity.Supply;
import Car.Auto.Mechanic.Repository.SupplyRepository;

@Service
public class SupplyServiceImplementation implements SupplyService {

	@Autowired
	private SupplyRepository supplyRepository;
	
	@Override
	public Supply findBySupplyName(String supplyName) {
		
		return supplyRepository.findBySupplyName(supplyName);
	}


	@Override
	public Supply save(SupplyDTO suppliesDTO) {
		
		Supply supply = new Supply();
		
		supply.setSupplyName(suppliesDTO.getSupplyName());
		supply.setPrice(suppliesDTO.getPrice());

		return supplyRepository.save(supply);
	}


	@Override
	public Set<Supply> getAll() {
		return supplyRepository.getAll();
	}



}
