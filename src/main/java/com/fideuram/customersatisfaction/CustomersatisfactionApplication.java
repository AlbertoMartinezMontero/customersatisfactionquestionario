package com.fideuram.customersatisfaction;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CustomersatisfactionApplication {

	public static void main(String[] args) {
		SpringApplication.run(CustomersatisfactionApplication.class, args);
		Connection con = null;
		Statement stmt = null;
		String url = "jdbc:jtds:sqlserver://10.2.0.3:1433;databaseName=fideuramvita";
		String userName = "sa";
		String password = "SuperPa55W0rd";

		try {
			// Connessione col db
			con = DriverManager.getConnection(url,userName, password);
					

			// Dichiarazione String sql
			String sql;
			// inizializziamo lo statement
			stmt = con.createStatement();

			// Prendere record tabella domanda
			sql = "SELECT * from puc001.domanda";
			ResultSet res = stmt.executeQuery(sql);
			while (res.next()) {
				System.out.println("ID domanda = " + res.getLong("id"));
				System.out.println("descrizione domanda = " + res.getString("domanda"));
			}
		}

		catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (stmt != null) {
				try {
					stmt.close();
				} catch (Exception e) {
				}
			}
			if (con != null) {
				try {
					con.close();
				} catch (Exception e) {
				}
			}

		}
	}
}