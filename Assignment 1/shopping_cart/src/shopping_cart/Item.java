package shopping_cart;

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
		this.mItemName = itemName;
		this.mItemQuantity = itemQuantity;
		this.mItemPrice = itemPrice;
	}

	/**
	 * @return name of the item
	 */
	public String getmItemName() {
		return mItemName;
	}
	
	/**
	 * @return quantity of the item
	 */
	public int getmItemQuantity() {
		return mItemQuantity;
	}
	
	/**
	 * @return price of the item
	 */
	public double getmItemPrice() {
		return mItemPrice;
	}
	
	/**
	 * sets the quantity of the item
	 */
	public void setmItemQuantity(int mItemQuantity) {
		this.mItemQuantity = mItemQuantity;
	}
	
	
}
