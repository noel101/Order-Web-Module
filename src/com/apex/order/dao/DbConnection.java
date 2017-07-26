package com.apex.order.dao;

import java.sql.*;

public class DbConnection {
	public static void main(String args[]) {
		getConnection();
	}

	public static Connection getConnection() {
		Connection con = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			String url = "jdbc:mysql://localhost:3306/emp";
			con = DriverManager.getConnection(url, "root", "root");
			System.out.println("Connection Successful..");

		} catch (Exception e) {
			System.err.println("Connection not Successful..");
		}
		return con;
	}
}
