package collection;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class ListOfMap {

	public static void main(String[] args) {
		List<Map<String, String>> listOfMap = getListOfMap();
		printUsingForLoop(listOfMap);
		System.out.println("=======================================");
		printUsingStream(listOfMap);
	    Map<String,Integer> map = new TreeMap<>();

	}

	private static void printUsingForLoop(List<Map<String, String>> listOfMap) {
		Map<String, String> map = new HashMap<>();
		long s = System.currentTimeMillis();
		for (Map<String, String> m : listOfMap) {
			map.putAll(m);
		}
		long e = System.currentTimeMillis();
		System.out.println((e - s) + "  " + map);
	}

	private static void printUsingStream(List<Map<String, String>> listOfMap) {
		Map<String, String> map = new HashMap<>();
		long s = System.currentTimeMillis();
		listOfMap.stream().forEach(e -> map.putAll(e));
		long e = System.currentTimeMillis();
		System.out.println((e - s) + "  " + map);
	}

	public static List<Map<String, String>> getListOfMap() {
		Map<String, String> westIndiaStateCapital = new HashMap<String, String>();
		westIndiaStateCapital.put("Maharashtra", "Mumbai");
		westIndiaStateCapital.put("Gujarat", "Gandhinagar");
		westIndiaStateCapital.put("Rajasthan", "Jaipur");
		westIndiaStateCapital.put("Goa", "Panaji");

		// HashMap 2: input preparation for SOUTH India Region
		Map<String, String> southIndiaStateCapital = new HashMap<String, String>();
		southIndiaStateCapital.put("Andhra Pradesh", "Amaravati");
		southIndiaStateCapital.put("Karnataka", "Bengaluru");
		southIndiaStateCapital.put("Kerala", "Thiruvananthapuram");
		southIndiaStateCapital.put("Tamil Nadu", "Chennai");
		southIndiaStateCapital.put("Telangana", "Hyderabad");

		// HashMap 3: input preparation for EAST India Region
		Map<String, String> eastIndiaStateCapital = new HashMap<String, String>();
		eastIndiaStateCapital.put("Bihar", "Patna");
		eastIndiaStateCapital.put("Jharkhand", "Ranchi");
		eastIndiaStateCapital.put("West Bengal", "Kolkata");
		eastIndiaStateCapital.put("Odisha", "Bhubaneswar");

		// HashMap 4: input preparation for SOUTH India Region
		Map<String, String> northIndiaStateCapital = new HashMap<String, String>();
		northIndiaStateCapital.put("Delhi", "New Delhi");
		northIndiaStateCapital.put("Himachal Pradesh", "Shimla");
		northIndiaStateCapital.put("Jammu n Kashmir", "Srinagar");
		northIndiaStateCapital.put("Punjab", "Chandigarh");

		// HashMap 5: input preparation for CENTRAL India Region
		Map<String, String> centralIndiaStateCapital = new HashMap<String, String>();
		centralIndiaStateCapital.put("Madhya Pradesh", "Bhopal");
		centralIndiaStateCapital.put("Uttar Pradesh", "Lucknow");
		centralIndiaStateCapital.put("Chhattisgarh", "Raipur");

		// create ArrayList and insert all 5 HashMap into it
		List<Map<String, String>> listOfIndianRegions = new ArrayList<Map<String, String>>();

		// add all 5 regions to AL
		listOfIndianRegions.add(westIndiaStateCapital);
		listOfIndianRegions.add(southIndiaStateCapital);
		listOfIndianRegions.add(eastIndiaStateCapital);
		listOfIndianRegions.add(northIndiaStateCapital);
		listOfIndianRegions.add(centralIndiaStateCapital);
		return listOfIndianRegions;
	}
}
