/**
*
* Creates the individual food items
* that populate the menu
*
*/
package ordering;

public class MenuItem {
	private String itemName;
	private Double itemPrice;
	private int cookTime;
	
	/**
	* Constructor for the menu items
	* @param itemName the name of the item
	* @param itemPrice the price of the item
	* @param cookTime the amount of time to prepare the item
	*/
	public MenuItem(String itemName, Double itemPrice, int cookTime) {
		this.itemName = itemName;
		this.itemPrice = itemPrice;
		this.cookTime = cookTime;
	}
	
	/**
	* Getter for the item name
	* @return item name
	*/
	public String getName() {
		return itemName;
	}
	
	/**
	* Getter for the item price
	* @return item price
	*/
	public Double getPrice() {
		return itemPrice;
	}
	
	/**
	* Getter for the item's cook time
	* @return amount of time to cook the item
	*/
	public int getCookTime() {
		return cookTime;
	}
	
	/**
	* Converts the item's information to a string
	* @return item information
	*/
	public String toString() {
		String info = itemName + "   " + itemPrice;
		return info;
	}
}
