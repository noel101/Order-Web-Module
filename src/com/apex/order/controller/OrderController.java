package com.apex.order.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.apex.order.bo.OrderBO;
import com.apex.order.bo.OrderService;
import com.apex.order.vo.Order;

@Controller
public class OrderController {

	@Autowired
	private OrderBO orderBO = null;
	// private OrderService orderService = null;
	

	@RequestMapping(value = "/orderEntry.do")
	public String displayOrder(@ModelAttribute("orderForm") Order order) {
		return "orderpage";
	}

	@RequestMapping(value = "/placeorder.do")
	public String processOrder(@ModelAttribute("orderForm") Order order) {
		System.out.println("Starting of OrderController : processOrder()");
		// Step1
		// System.out.println(order.getCard());
		// Step2
		orderBO.placeOrder(order);
		// orderBO.placeOrder(order);

		// Step3
		System.out.println("Ending of OrderController : processOrder()");
		return "orderconfirmation";
	}

	// public OrderBO getOrderBO() {
	// return orderBO;
	// }
	//
	// public void setOrderBO(OrderBO orderBO) {
	// this.orderBO = orderBO;
	// }
}
