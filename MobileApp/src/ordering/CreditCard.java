/**
* Credit card class
*/
package ordering;

public class CreditCard {
	private final String cardNum;
	private final String cardHolder;
	
	public CreditCard(String cardNum, String cardHolder) throws IllegalArgumentException {
		if(isValid(cardNum, cardHolder)) {
			this.cardNum = cardNum;
			this.cardHolder = cardHolder;
		} else {
			throw new IllegalArgumentException();
		}
	}
	
	/**
	* Getter for the credit card number
	* @return the credit card number
	*/
	public String getCardNum() {
		return cardNum;
	}
	
	/**
	* Getter for the card holder
	* @return the card holder
	*/
	public String getCardHolder() {
		return cardHolder;
	}
	
	/**
	* Checks if the length of the card number is valid
	* @param cardNum 
	* @param cardHolder
	* @return Whether the card number length is valid or not
	*/
	private boolean isValid(String cardNum, String cardHolder) {
		if(cardNum.length() < 13 || cardNum.length() > 16 || cardHolder.length() == 0)
			return false;
		else
			return true;
	}
	
	/**
	* Converts given object to a string
	* @return String
	*/
	public String toString() {
		String tmp = cardHolder + " " + cardNum;
		return tmp;
	}
}
