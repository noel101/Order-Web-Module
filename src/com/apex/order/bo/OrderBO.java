package com.apex.order.bo;

import com.apex.order.vo.Order;

public interface OrderBO {
	
	public void placeOrder(Order order);

	public Order getOrder(int orderId);

	public void updateOrder(Order order);

	public Order deleteOrder(int orderId);  
}
