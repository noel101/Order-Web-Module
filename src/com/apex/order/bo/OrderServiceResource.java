package com.apex.order.bo;

import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RestController;

import com.apex.order.dao.OrderDAOImpl;
import com.apex.order.vo.Order;

//This is controller class
//which will get the request and call the BO and get it
//and u will be returning insted of HTML  -- will return XML or JSON

@RestController
@Path("/order")
public class OrderServiceResource implements OrderService {

	// private OrderDAO orderDAO=null;
	@GET
	@Path("/{orderId}")
	@Produces({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })
	public Order getOrder(@PathParam("orderId") String id) {
		System.out.println("This is my get Method..");
		// System.out.println(orderDAO);
		// return orderDAO.getOrder(Integer.parseInt(id));
		OrderDAOImpl orderD = new OrderDAOImpl();
		return orderD.getOrder(Integer.parseInt(id));

	}

	@POST
	public void placeOrder(Order order) {
		OrderDAOImpl orderD = new OrderDAOImpl();
		orderD.placeOrder(order);
		
		// This method will call DAO/ hibernate and then database

		/*System.out.println(orderBO.getCard());
		OrderBO orderBO = new OrderBO();
		orderBO.placeOrder(orderBO);*/

	}

	@PUT
	public void updateOrder(Order order) {
	}

	@DELETE
	public void deleteOrder(int orderId) {

	}

}
