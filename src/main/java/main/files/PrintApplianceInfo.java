package main.files;

import entity.files.Appliance;

import java.util.ArrayList;

public class PrintApplianceInfo {
	
	public static void print(ArrayList<Appliance> appliances) {
		for (Appliance appliance : appliances) {
			System.out.println(appliance.toString());
		}
	}
	
	// you may add your own code here

}
