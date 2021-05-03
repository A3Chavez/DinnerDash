package ordering;
import java.io.File;
//import java.io.BufferedReader;
import java.util.Scanner;
import java.util.StringTokenizer;
import java.util.Random;
import java.util.ArrayList;
import java.io.FileNotFoundException ;

public class Delivery {
	
	private ArrayList <String> deliveryDrivers ;
	private ArrayList<Integer> deliveryDriversTimes ; 
	private int totalTime;
	private Random rand;
	private int cookTime;
	private int selectedDriver;
	private StringTokenizer tokens;
	private File deliveryDriversFile;
	private Scanner fileScanner;
	
/*
 * Initialized the random object, the deliveryDrivers, and the deliveryDriversTimes
 * 
 */
	public Delivery(int cookTime) throws FileNotFoundException {
		deliveryDrivers = new ArrayList<String>();
		deliveryDriversTimes = new ArrayList<Integer>();
		fileScanner = new Scanner( new File("deliveryDrivers.txt"));
		fileReader(fileScanner);

		rand = new Random();
		
		selectedDriver = rand.nextInt(deliveryDrivers.size());
		
		this.cookTime = cookTime;
		totalTime = 0;
	}
	
	/*
	 * Populates the given minutes / drivers from the given text file
	 * into the deliveryDrivers and the deliveryDriversTimes arrayLists.
	 * 
	 */
	public void fileReader(Scanner fileScanner) {
		while(fileScanner.hasNextLine()) {
			String driver = fileScanner.nextLine();
			tokens = new StringTokenizer(driver, ";");
			while(tokens.hasMoreTokens()) {
				String driverName = tokens.nextToken();
				int driverTime = Integer.parseInt(tokens.nextToken());
				deliveryDrivers.add(driverName);
				deliveryDriversTimes.add(driverTime);
			}
		}
		fileScanner.close();
		
	}
	
	/*
	 * This method is intended to add up the delivery drivers times with the respective
	 * time to prepare each meal.
	 */
	public int addUpTo() {
		totalTime = cookTime + deliveryDriversTimes.get(selectedDriver);
		return totalTime;
	}
}