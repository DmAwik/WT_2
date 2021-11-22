package main.files;

import entity.files.Appliance;
import entity.files.criteria.Criteria;
import entity.files.criteria.SearchCriteria;
import service.files.ApplianceService;
import service.files.ServiceFactory;

import java.util.ArrayList;

public class Main {

	public static void main(String[] args) {
		ArrayList<Appliance> appliances;

		ServiceFactory factory = ServiceFactory.getInstance();
		ApplianceService service = factory.getApplianceService();

		//////////////////////////////////////////////////////////////////

		Criteria criteriaOven = new Criteria(SearchCriteria.Oven.class.getSimpleName());
		criteriaOven.add(SearchCriteria.Oven.WEIGHT.toString(), 5);

		appliances = service.find(criteriaOven);

		PrintApplianceInfo.print(appliances);

		System.out.println("Lowest cost appliance: " + service.findLowestCostAppliance());

	}

}
