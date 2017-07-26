package com.apex.order.bo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.apex.order.dao.OrderDAO;
import com.apex.order.vo.Order;


@Service
public class OrderBOImpl implements OrderBO {

	@Autowired
	private OrderService orderService = null;
//	/private OrderDAO orderDAO = null;
	//private OrderDAO orderDAO = null;

	@Override
	public void placeOrder(Order order) {
		System.out.println("Starting of OrderBOImpl : placeOrder(Order order)");
		//2a..???
		//2b..
		orderService.placeOrder(order);
		
		System.out.println("Ending of OrderBOImpl : placeOrder(Order order)");
	}

	@Override
	public Order getOrder(int orderId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void updateOrder(Order order) {
		// TODO Auto-generated method stub

	}

	@Override
	public Order deleteOrder(int orderId) {
		// TODO Auto-generated method stub
		return null;
	}

	/*public OrderDAO getOrderDAO() {
		return orderDAO;
	}

	public void setOrderDAO(OrderDAO orderDAO) {
		this.orderDAO = orderDAO;
	}*/

}
