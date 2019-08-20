package assignment;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * This class handles the UI part of the QuryImplementation class
 * @author Jugal
 * Dated 08/20/2019
 */
public class Main {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {

		Scanner inputScanner = new Scanner(System.in);
		QueryImplementation implementation = new QueryImplementation();
		
		//Code for executing Assignment 1
		System.out.print("Enter the email id of the user whose order is to be determined : ");
		String email_id = inputScanner.next();
		List<Orders> orders = new ArrayList<>();
		orders = implementation.getOrderDetailsOfShippedOrders(email_id);
		for(int i = 0, j = 0; i < orders.size(); i++)
		{
			System.out.println("Order : " + (++j));
			System.out.println("\tOrder id : " + orders.get(i).getOrder_id());
			System.out.println("\tOrder date : " + orders.get(i).getOrder_date());
			System.out.println("\tOrder amount : " + orders.get(i).getOrder_amount());
			System.out.println();
		}
		
		//Code for executing Assignment 2
		System.out.println("Enter 5 images of 2 products : ");
		int[] productIds = new int[10];
		String[] imageURLS = new String[10];
		System.out.println("Enter the image URLS for product \"Redmi 3s Prime\" : ");
		for(int i = 0; i < 5; i++)
		{
			productIds[i] = 1;
			imageURLS[i] = inputScanner.next();
		}
		System.out.println("\nEnter the image URLS for product \"Redmi Note 4\" : ");
		for(int i = 5; i < 10; i++)
		{
			productIds[i] = 2;
			imageURLS[i] = inputScanner.next();
		}
		if(implementation.insertImagesOfProduct(productIds, imageURLS) > 0)
			System.out.println("Images inserted");
		else
			System.out.println("There was a error while inserting the images");
		
		System.out.println("\nThe images table is : ");
		implementation.printTable("images");
		
		//Code for executing Assignment 3
		implementation.deleteProductsNotOrdered();
		System.out.println("\nThe products table afer operation is : ");
		implementation.printTable("products");
		
		//Code for executing Assignment 4
		List<CategoryDetail> categoryList = new ArrayList<>();
		categoryList = implementation.getCategoryDetail();
		System.out.println("\nThe categories are : ");
		for(int i = 0, j = 0; i < categoryList.size(); i++)
		{
			System.out.println("Category : " + (++j));
			System.out.println("Category Name : " + categoryList.get(i).getCategoryName());
			System.out.println("Number of Childs : " + categoryList.get(i).getNoOfChilds());
			System.out.println();
		}
		
		inputScanner.close();
	}

}
