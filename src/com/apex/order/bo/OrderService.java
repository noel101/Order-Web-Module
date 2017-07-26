package com.apex.order.bo;

import com.apex.order.vo.Order;

public interface OrderService {
	
	public void placeOrder(Order order);

	public Order getOrder(String orderId);

	public void updateOrder(Order order);

	public void  deleteOrder(int orderId);
	
}
