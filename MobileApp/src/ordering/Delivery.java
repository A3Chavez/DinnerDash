package ordering;
import java.io.File;
//import java.io.BufferedReader;
import java.util.Scanner;
import java.util.Random;
import java.util.ArrayList;
import java.io.FileNotFoundException ;

public class Delivery {
	
	private ArrayList <String> deliveryDrivers ;
	private ArrayList<Integer> deliveryDriversTimes ; 
	private int totalTime;
	private Random rand;
	private int totalTime;
	private int selectedDriver;
	private File deliveryDriversFile;
	private Scanner fileScanner;
	
/*
 * Initialized the random object, the deliveryDrivers, and the deliveryDriversTimes
 * 
 */
	public Delivery(int totalTime) throws FileNotFoundException {
		deliveryDrivers = new ArrayList<String>();
		deliveryDriversTimes = new ArrayList<Integer>();
		fileScanner = new Scanner( new File("deliveryDrivers.txt"));
		fileReader(fileScanner);

		rand = new Random(deliveryDrivers.size());
		
		selectedDriver = rand.nextInt();
		
		
		this.totalTime = totalTime;
		totalTime = 0;
	}
	
	public int getTotalTime() {
		return totalTime;
	}
	
	/*
	 * Populates the given minutes / drivers from the given text file
	 * into the deliveryDrivers and the deliveryDriversTimes arrayLists.
	 * 
	 */
	public void fileReader(Scanner fileScanner) {
		int i = 0;   //COUNTER
		
		while(fileScanner.hasNext()) {   ////////////////////////////WHILE LOOP
			if( !fileScanner.hasNext(";")) {
				deliveryDrivers.add(fileScanner.next());
				if(!fileScanner.hasNext(";")) { //if there's a last name
					deliveryDrivers.set(i, deliveryDrivers.get(i) + "_" + fileScanner.next());
				}	
			} else {
				fileScanner.next(); //Intended to clear out the ';'
				if (fileScanner.hasNextInt()) {
					deliveryDriversTimes.add(fileScanner.nextInt());
				}
			}
			
			i++;
		}
		
		
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