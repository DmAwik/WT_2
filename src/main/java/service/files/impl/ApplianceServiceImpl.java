package service.files.impl;

import dao.files.ApplianceDAO;
import dao.files.DAOFactory;
import entity.files.Appliance;
import entity.files.ApplianceFactory;
import entity.files.AppliancePriceComparator;
import entity.files.criteria.Criteria;
import entity.files.criteria.SearchCriteria;
import service.files.ApplianceService;
import service.files.validation.Validator;

import java.util.ArrayList;
import java.util.Map;

public class ApplianceServiceImpl implements ApplianceService {

	public ArrayList<Appliance> find(Criteria criteria) {
		if (!Validator.criteriaValidator(criteria)) {
			return null;
		}
		
		DAOFactory factory = DAOFactory.getInstance();
		ApplianceDAO applianceDAO = factory.getApplianceDAO();

		ArrayList<ArrayList<String>> applianceInfos = applianceDAO.find(criteria.getGroupSearchName());
		ApplianceFactory applianceFactory = new ApplianceFactory();
		ArrayList<Appliance> appliances = new ArrayList<>();

		for (ArrayList<String> applianceInfo : applianceInfos) {
			Appliance appliance = applianceFactory.createInstance(criteria.getGroupSearchName(), applianceInfo);
			if (isMeetsCriteria(appliance, criteria)) {
				appliances.add(appliance);
			}
		}
		return appliances;
	}

	private boolean isMeetsCriteria(Appliance appliance, Criteria criteria){
		for (Map.Entry<String, Object> entry : criteria.getCriteria().entrySet()) {
			if (!appliance.getFieldByName(entry.getKey()).equals(entry.getValue())) {
				return false;
			}
		}
		return true;
	}

	public Appliance findLowestCostAppliance() {
		ArrayList<Appliance> appliances = new ArrayList<Appliance>();
		appliances.addAll(find(new Criteria(SearchCriteria.Laptop.class.getSimpleName())));
		appliances.addAll(find(new Criteria(SearchCriteria.Oven.class.getSimpleName())));
		appliances.addAll(find(new Criteria(SearchCriteria.Refrigerator.class.getSimpleName())));
		appliances.addAll(find(new Criteria(SearchCriteria.Speakers.class.getSimpleName())));
		appliances.addAll(find(new Criteria(SearchCriteria.TabletPC.class.getSimpleName())));
		appliances.addAll(find(new Criteria(SearchCriteria.VacuumCleaner.class.getSimpleName())));

		appliances.sort(new AppliancePriceComparator());

		return appliances.get(0);
	}

}

//you may add your own new classes
