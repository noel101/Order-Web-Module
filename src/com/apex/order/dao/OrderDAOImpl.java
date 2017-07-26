package com.apex.order.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import org.springframework.stereotype.Repository;

import com.apex.order.vo.Order;



@Repository
public class OrderDAOImpl implements OrderDAO {
	// Getting Connection
	public static Connection getConnection() throws Exception {
		Connection dbConn = null;
		try {
			// step1:
			Class.forName("com.mysql.jdbc.Driver");
			// step2
			String url = "jdbc:mysql://localhost:3306/test";
			// step3
			dbConn = DriverManager.getConnection(url, "root", "root");
			System.out.println("Database Connection Successful...");
		} catch (SQLException sqle) {
			sqle.printStackTrace();
			throw sqle;
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
		return dbConn;
	}

	@Override
	public void placeOrder(Order order) {

		System.out.println("Starting of OrderDAOImpl : placeOrder(Order order)");

		Connection dbConn = null;
		PreparedStatement pStmt = null;
		int rowsInserted = 0;
		try {
			dbConn = getConnection();
			pStmt = dbConn.prepareStatement(
					"INSERT INTO `order`(itemcount,order_total,card,person_name,shipping_address) VALUES(?,?,?,?,?);");
			pStmt.setInt(1, order.getItemCount());
			pStmt.setDouble(2, order.getOrderTotal());
			pStmt.setString(3, order.getCard());
			pStmt.setString(4, order.getPersonName());
			pStmt.setString(5, order.getShippingAddress());

			rowsInserted = pStmt.executeUpdate();

			if (rowsInserted != 1) {
				throw new Exception("Error in Inserting the Data");
			}

		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e.getMessage());
		} finally {
			try {
				pStmt.close();
				dbConn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				throw new RuntimeException(e.getMessage());
			}
		}
		/*
		 * Connection con = DbConnection.getConnection(); try { Statement st =
		 * con.createStatement(); System.out.println("item :"+order.getCard());
		 * String query = "INSERT INTO `order` VALUES(10,"+
		 * order.getItemCount()+","+order.getOrderTotal()+",'"+order.getCard()+
		 * "','"+order.getPersonName() + "','" +
		 * order.getShippingAddress()+"')"; st.executeUpdate(query);
		 * System.out.println("Database Updated...!"); con.close(); } catch
		 * (SQLException e) { e.printStackTrace(); }
		 */
		System.out.println("Ending of OrderDAOImpl : placeOrder(Order order)");
		return;
	}

	@Override
	public Order getOrder(int orderId) {
		Order order = new Order();
		order.setOrderId(orderId);
		order.setItemCount(10);
		order.setOrderTotal(1000.00);
		order.setCard("9922 2288 3388 228");
		order.setPersonName("Harry");
		order.setShippingAddress("Avalon Apartment");
		return order;
		
		
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

}
