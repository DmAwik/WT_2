package service.files.validation;

import entity.files.criteria.Criteria;
import entity.files.criteria.SearchCriteria;

public class Validator {

    public static boolean criteriaValidator(Criteria criteria) {
        // you may add your own code here
        try {
            for (String criteriaName : criteria.getCriteria().keySet()) {
                switch (criteria.getGroupSearchName()) {
                    case "laptop":
                        SearchCriteria.Laptop.valueOf(criteriaName);
                        break;
                    case "oven":
                        SearchCriteria.Oven.valueOf(criteriaName);
                        break;
                    case "refrigerator":
                        SearchCriteria.Refrigerator.valueOf(criteriaName);
                        break;
                    case "speakers":
                        SearchCriteria.Speakers.valueOf(criteriaName);
                        break;
                    case "tabletpc":
                        SearchCriteria.TabletPC.valueOf(criteriaName);
                        break;
                    case "vacuumcleaner":
                        SearchCriteria.VacuumCleaner.valueOf(criteriaName);
                        break;
                    default:
                        return false;
                }
            }
        } catch (IllegalArgumentException e) {
            return false;
        }

        return true;
    }


}

//you may add your own new classes