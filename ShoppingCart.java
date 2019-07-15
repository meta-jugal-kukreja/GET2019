package SCF_Assignment_1;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class ShoppingCart {

	/**
	 * This method adds the item to the cart list
	 * 
	 * @param menuList
	 *            contains the list of items in menu along with price
	 * @param itemList
	 *            is the list of items in the cart
	 */
	public static void addItem(List<Item> menuList, ArrayList<Item> itemList) {
		Scanner inputScanner = new Scanner(System.in);
		String nameString = null;
		int quantity;

		System.out.println("\nItems Available : ");
		System.out.println("\nItem\t\tPrice(In Rs.)");
		System.out.println("------\t--------------");
		System.out.println("1. Mug\t|\t 25");
		System.out.println("2. Bat \t|\t 50");
		System.out.println("3. Top \t|\t 30");
		System.out.println("4. Cap \t|\t 20");
		System.out.println("5. Cup \t|\t 50");

		System.out
				.print("\nEnter the name of the item to be added to the cart : ");
		nameString = inputScanner.nextLine().toLowerCase();
		if (searchItemsInList(itemList, nameString) < 0) // Checks whether an item is already in the cart. If yes
		{
			if (searchItemsInList(itemList, nameString) < 0) {
				System.out.print("Enter the Quantity of the " + nameString
						+ " : ");
				inputScanner = new Scanner(System.in);
				quantity = inputScanner.nextInt();
				Item item = new Item(nameString, quantity, returnPriceOfItem(
						menuList, nameString));
				itemList.add(item);
				System.out.println("\nThe Item Added into the Cart...");
			} else {
				System.out.println("\nNo such Item Exit.");
			}
		} else
			System.out.println("\nItem is already in the cart.");
	}

	/**
	 * Method for manipulating items in the cart.
	 * 
	 * @param menuList
	 *            contains the list of items in menu along with price
	 * @param itemList
	 *            is the list of items in the cart
	 */
	public static void updateCart(List<Item> menuList, ArrayList<Item> itemList) {
		System.out
				.println("\nWhat do you want to do with your cart?\n(Enter number): ");
		System.out
				.println("------------------------------------------------------");
		System.out.println("1. Update an item's quantity in the cart.");
		System.out.println("2. Add a new item in the cart.");
		System.out.println("3. Delete an item from the cart.");
		System.out.println("4. Go to the menu.");
		System.out.print("\nEnter your choice : ");

		Scanner inputScanner = new Scanner(System.in);
		int choice = inputScanner.nextInt();
		switch (choice) {
		case 1:
			updateQuantityOfItem(itemList);
			break;
		case 2:
			addItem(menuList, itemList);
			break;
		case 3:
			deleteItemsFromCart(itemList);
			break;
		case 4:
			break;
		default:
		}
	}

	/**
	 * This method updates the quantity of particular item in the cart.
	 * 
	 * @param itemList
	 *            is the list of items in the cart
	 */
	public static void updateQuantityOfItem(ArrayList<Item> itemList) {
		System.out
				.print("Enter the name of the item whose quantity is to be changed : ");
		Scanner inputScanner = new Scanner(System.in);
		String nameString = inputScanner.nextLine().toLowerCase();
		int indexOfItem = searchItemsInList(itemList, nameString);
		if (indexOfItem != (-1)) {
			System.out.print("Enter the new quanity of " + nameString + " : ");
			int newQuantity = inputScanner.nextInt();
			if (newQuantity < 0)
				System.out
						.println("\nThe quantity of an item cannot be negative");
			else if (newQuantity == 0) {
				itemList.remove(indexOfItem);
				System.out.println("\nThe quantity has been removed.");
			} else {
				itemList.get(indexOfItem).setmItemQuantity(newQuantity);
				System.out.println("\nThe quantity has been updated.");
			}
		} else {
			System.out.println("\nThe Item doesn't exist in the cart.");
		}
	}

	/**
	 * This method deletes an item from the cart.
	 * 
	 * @param itemList
	 *            is the list of items in the cart
	 */
	public static void deleteItemsFromCart(ArrayList<Item> itemList) {
		Scanner inputScanner = new Scanner(System.in);
		String nameString = null;
		System.out
				.print("\nEnter the name of the item to be deleted from the cart : ");
		nameString = inputScanner.nextLine().toLowerCase();
		int indexOfItem = searchItemsInList(itemList, nameString);
		if (indexOfItem != (-1)) {
			itemList.remove(indexOfItem);
			System.out.println("The item deleted from the cart.");
		} else {
			System.out.println("\nThe Item doesn't exist in the cart.");
		}
	}

	/**
	 * This method displays the items in the cart
	 * 
	 * @param itemList
	 *            is the list of items in the cart
	 */
	public static void displayCartItems(List<Item> itemList) {
		if (itemList.size() == 0)
			System.out.println("\nThe cart is Empty");
		else {
			System.out.println("\nItems in the Cart are : ");
			System.out.println("Item\t\tQuantity\t\tPrice(In Rs.)");
			System.out.println("--------\t------------\t\t--------------");
			for (int i = 0; i < itemList.size(); i++) {
				System.out.println(itemList.get(i).getmItemName() + "\t\t\t"
						+ itemList.get(i).getmItemQuantity() + "\t\t\t"
						+ itemList.get(i).getmItemPrice());
			}
		}
	}

	/**
	 * This method generates the bill of items in the cart.
	 * 
	 * @param itemList
	 *            is the list of items in the cart.
	 */
	public static void generateBill(List<Item> itemList) {
		if (itemList.size() == 0)
			System.out.println("\nThe cart is Empty");
		else {
			double totalBill = 0;
			System.out.println("\nBill : ");
			System.out.println("------");
			System.out
					.println("Item\t\tPrice of one Item(In Rs.)\t\tQuantity\t\tTotal Price of Item(In Rs.)");
			System.out
					.println("--------\t-----------------------------\t\t--------------\t----------------------------");

			for (int i = 0; i < itemList.size(); i++) {

				double price = itemList.get(i).getmItemPrice();
				int quantity = itemList.get(i).getmItemQuantity();
				double totalPriceOfItems = price * quantity;

				totalBill = totalBill + totalPriceOfItems;

				System.out.println(itemList.get(i).getmItemName() + "\t\t\t\t"
						+ price + "\t\t\t\t\t" + quantity + "\t\t\t\t"
						+ totalPriceOfItems);
			}

			System.out.println("\nYour Total Bill is : " + totalBill);
		}
	}

	/**
	 * This method searches for an item in the list
	 * @param itemList  is the list of items in the cart
	 * @param {String}nameString is the item to be searched for
	 */
	public static int searchItemsInList(List<Item> itemList, String nameString) {
		for (int i = 0; i < itemList.size(); i++) {
			if (itemList.get(i).getmItemName().equals(nameString)) {
				return i;
			}
		}
		return -1;
	}

	/**
	 * This method returns the price of an item in the menuList
	 * @param menuList is the list of items in the cart
	 * @param nameString is the name of the item whose price is to be found
	 * @return {double} price of the item found else -1
	 */
	public static double returnPriceOfItem(List<Item> menuList,
			String nameString) {
		for (int i = 0; i < menuList.size(); i++) {
			if (menuList.get(i).getmItemName().equals(nameString)) {
				return menuList.get(i).getmItemPrice();
			}
		}
		return -1;
	}

	public static void main(String[] args) {
		
		List<Item> menuList = new ArrayList();
		ArrayList<Item> itemList = new ArrayList<>(); // this arrayList will contain the items in the cart

		// Helper variables for loop and choice
		boolean flag = true;
		int choice = 0;

		Scanner inputChoiceScanner = new Scanner(System.in);

		// Assigning items and prices
		menuList.add(new Item("mug", 0, 25));
		menuList.add(new Item("bat", 0, 50));
		menuList.add(new Item("top", 0, 30));
		menuList.add(new Item("cap", 0, 20));
		menuList.add(new Item("cup", 0, 50));

		System.out.println("The following things you can do with the cart:");
		System.out.println("1. Add a new item to the cart.");
		System.out.println("2. Update an item's quantity in the cart.");
		System.out.println("3. Display the cart.");
		System.out.println("4. Generate bill of items in the cart.");
		System.out.println("5. Exit Cart");
		do {
			System.out
					.print("\nPlease enter in number(1/2/3/4/5) what you want to do with the cart : ");
			try {
				choice = inputChoiceScanner.nextInt();
			} catch (Exception e) {
				System.out.println("\nInvalid Choice");
				System.exit(0);
			}
			switch (choice) {
			case 1:
				addItem(menuList, itemList);
				break;
			case 2:
				updateCart(menuList, itemList);
				break;
			case 3:
				displayCartItems(itemList);
				break;
			case 4:
				generateBill(itemList);
				break;
			case 5:
				System.out.println("Thank you for Shopping.");
				flag = false;
				break;
			default:
				System.out.println("Please Enter Correct Choice.");
			}
		} while (flag);

	}
}
