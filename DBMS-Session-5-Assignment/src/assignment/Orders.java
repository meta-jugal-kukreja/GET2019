package assignment;

import java.util.Date;

/**
 * This class represents an order with its data members representing the order details
 * @author Jugal
 * Dated 08/19/2019
 */
public class Orders {
	
	private int order_id;
	private Date order_date;
	private double order_amount;
	
	/**
	 * Constructor to initialize the data members
	 * @param order_id is the order id
	 * @param order_date is the order date
	 * @param order_amount is the order amount
	 */
	Orders(int order_id, Date order_date, double order_amount)
	{
		this.order_id = order_id;
		this.order_date = order_date;
		this.order_amount = order_amount;
	}

	//Getter methods
	public int getOrder_id() {
		return order_id;
	}

	public Date getOrder_date() {
		return order_date;
	}

	public double getOrder_amount() {
		return order_amount;
	}
	
}
