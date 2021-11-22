package service.files;

import entity.files.Appliance;
import entity.files.criteria.Criteria;

import java.util.ArrayList;

public interface ApplianceService {	
	
	ArrayList<Appliance> find(Criteria criteria);

	Appliance findLowestCostAppliance();

}
