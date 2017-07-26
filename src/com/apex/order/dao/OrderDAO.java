package com.apex.order.dao;

import com.apex.order.vo.Order;

public interface OrderDAO {

	public void placeOrder(Order order);

	public Order getOrder(int orderId);

	public void updateOrder(Order order);

	public Order deleteOrder(int orderId);
}
