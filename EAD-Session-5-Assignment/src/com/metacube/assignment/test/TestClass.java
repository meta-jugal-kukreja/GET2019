package com.metacube.assignment.test;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import com.metacube.assignment.controller.ProductController;
import com.metacube.assignment.enums.Status;
import com.metacube.assignment.factory.Factory;
import com.metacube.assignment.model.ShoppingCart;

/**
 * Class for testing the methods
 * @author Jugal
 * Dated 09/05/2019
 */
public class TestClass {
	
	ProductController productController = Factory.createProductController();
	
	/**
	 * Method to test insertion
	 */
	@Test
	public void testInsertion()
	{
		String productName = "Oppo A83", productQuantity = "2";
		int productId = productController.findProductIdByName(productName);
		Status status = productController.addProductToCart(1, productId, Integer.parseInt(productQuantity));
		assertEquals(Status.ADDED, status);
	}

	/**
	 * Method to test get cart
	 */
	@Test
	public void testgetCart()
	{
		List<ShoppingCart> cartItems = new ArrayList<>();
		cartItems = productController.getCartItems(1);
		assertEquals(5, cartItems.get(0).getProductId());
		assertEquals(6, cartItems.get(1).getProductId());
	}
	
	/**
	 * Method to test update
	 */
	@Test
	public void testUpdateCart()
	{
		String productName = "Oppo A83", productQuantity = "2";
		int productId = productController.findProductIdByName(productName);
		Status status = productController.updateCartItems(1, productId, Integer.parseInt(productQuantity));
		assertEquals(Status.UPDATED, status);
	}
	
	/**
	 * Method to test delete
	 */
	@Test
	public void testDeleteItemFromCart()
	{
		String productName = "Oppo A83";
		int productId = productController.findProductIdByName(productName);
		Status status = productController.deleteProductFromCart(1, productId);
		assertEquals(Status.UPDATED, status);
	}
}
