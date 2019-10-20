package assignment;

import static org.junit.Assert.*;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

/**
 * This class tests the methods of QueryImplementation class
 * @author Jugal
 * Dated 08/20/2019
 */
public class QueryImplementationTest {

	QueryImplementation implementation;
	
	@Before
	public void initialize() throws ClassNotFoundException, SQLException
	{
		implementation = new QueryImplementation();
	}

	//Test for order details
	@Test
	public void testGetOrderDetailsOfShippedOrders() throws SQLException
	{
		List<Orders> orders = new ArrayList<>();
		orders = implementation.getOrderDetailsOfShippedOrders("pqr@gmail.com");
		assertEquals(4, orders.get(0).getOrder_id());
		assertEquals(1, orders.get(1).getOrder_id());
	}
	
	//Test for inserting images
	@Test
	public void testInsertImagesOfProduct() throws SQLException
	{
		int[] productIds = {1,1,1,1,1};
		String[] imageURLS = {"a", "b", "c", "d", "e"};
		assertEquals(5, implementation.insertImagesOfProduct(productIds, imageURLS));
	}
	
	//Test for deleting products
	@Test
	public void testDeleteProductsNotOrdered() throws SQLException
	{
		assertEquals(7, implementation.deleteProductsNotOrdered());
	}
	//Test for category details
	@Test
	public void testGetCategoryDetail() throws SQLException
	{
		List<CategoryDetail> categoryList = new ArrayList<>();
		categoryList = implementation.getCategoryDetail();
		assertEquals(2, categoryList.get(0).getNoOfChilds());
		assertEquals(2, categoryList.get(1).getNoOfChilds());
	}

}
