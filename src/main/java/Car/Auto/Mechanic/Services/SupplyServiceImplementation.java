package Car.Auto.Mechanic.Services;

import java.util.Set;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import Car.Auto.Mechanic.DTO.SupplyDTO;
import Car.Auto.Mechanic.Entity.Supply;
import Car.Auto.Mechanic.Repository.SupplyRepository;

@Service
public class SupplyServiceImplementation implements SupplyService {

	// instantiation of supply repository
	@Autowired
	private SupplyRepository supplyRepository;

	// method returning supply by name
	@Override
	public Supply findBySupplyName(String supplyName) {

		return supplyRepository.findBySupplyName(supplyName);
	}

	// method saving new supplies 
	@Override
	public Supply save(SupplyDTO suppliesDTO) {

		Supply supply = new Supply();

		supply.setSupplyName(suppliesDTO.getSupplyName());
		supply.setPrice(suppliesDTO.getPrice());

		return supplyRepository.save(supply);
	}

	// method returning all the supplies
	@Override
	public Set<Supply> getAll() {
		return supplyRepository.getAll();
	}

}
