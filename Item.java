package SCF_Assignment_1;

public class Item {
	
	private String mItemName;
	private int mItemQuantity;
	private double mItemPrice;
	
	/**
	 * 
	 * @param itemName is the item name
	 * @param itemQuantity is the quantity of item
	 * @param itemPrice is the price of item
	 */
	Item(String itemName, int itemQuantity, double itemPrice){
		mItemName = itemName;
		mItemQuantity = itemQuantity;
		mItemPrice = itemPrice;
	}

	/**
	 * @return name of the item in String
	 */
	public String getmItemName() {
		return mItemName;
	}
	
	/**
	 * @return quantity of the item in int
	 */
	public int getmItemQuantity() {
		return mItemQuantity;
	}
	
	/**
	 * @return price of the item in double
	 */
	public double getmItemPrice() {
		return mItemPrice;
	}
	
	/**
	 * sets the quantity of the item
	 * @param mItemQuantity is the quantity of item in int given by user 
	 */
	public void setmItemQuantity(int mItemQuantity) {
		this.mItemQuantity = mItemQuantity;
	}
	
	
}

