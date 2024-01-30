package com.database.edu;

import java.sql.*;

public class EduApplication {

	static final String DB_URL = "jdbc:postgresql://localhost:5432/farmville";
	static final String USER = "spring";
	static final String PASS = "1234";

	public static void main(String[] args) {
		// SpringApplication.run(EduApplication.class, args);
		try {
			//Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
			Connection conn = DataSource.getConnection();
			PreparedStatementExecution(conn);
			StatementExecution(conn);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public static void StatementExecution(Connection con) {
		long startTime = System.currentTimeMillis();
		try (
				Statement stmt = con.createStatement();) {
			con.setAutoCommit(false);
			for (int i = 0; i < 10000; i++) {
				stmt.executeUpdate(
						"INSERT INTO farmville.granjeros(nombre,descripcion,dinero,puntos,nivel) VALUES('pepe','paco',100,2,2);");
			}
			con.commit();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		long endTime = System.currentTimeMillis() - startTime;
		System.out.println("Statement");
		System.out.println(endTime);
	}

	public static void PreparedStatementExecution(Connection con) {
		long startTime = System.currentTimeMillis();
		try (
				PreparedStatement insertPeople = con.prepareStatement(
						"INSERT INTO farmville.granjeros(nombre,descripcion,dinero,puntos,nivel) VALUES(?,?,?,?,?);");) {
			con.setAutoCommit(false);
			for (int i = 0; i < 10000; i++) {
				insertPeople.setString(1, "pepe");
				insertPeople.setString(2, "paco");
				insertPeople.setInt(3, 100);
				insertPeople.setInt(4, 2);
				insertPeople.setInt(5, 2);
				insertPeople.executeUpdate();
			}
			con.commit();
		} catch (SQLException e) {
			e.printStackTrace();
			if (con != null) {
				try {
					System.err.print("Transaction is being rolled back");
					con.rollback();
				} catch (SQLException excep) {
					excep.printStackTrace();
				}
			}
		}
		long endTime = System.currentTimeMillis() - startTime;
		System.out.println("PreparedStatement");
		System.out.println(endTime);
	}

}
