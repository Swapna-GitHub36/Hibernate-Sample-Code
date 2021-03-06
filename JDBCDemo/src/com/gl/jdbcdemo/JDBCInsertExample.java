package com.gl.jdbcdemo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class JDBCInsertExample {

	public static void main(String[] args) {
		Connection con = null;
		Statement stmt = null;
		try {
			// step1 : register the driver
			Class.forName("oracle.jdbc.driver.OracleDriver");
			// step2 : establish the connection
			con = DriverManager.
					getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","root");
			//step3 : create statement
			 stmt = con.createStatement();
			//execute the query
			int rowsInserted = stmt.executeUpdate("insert into student values(1259,'Jiva',65,'EEE','21-JAN-1998')"); 
			if(rowsInserted!=0) {
				System.out.println("Student data inserted....");
			}else {
				System.out.println("Student data not inserted....");
			}
		
		}catch (Exception e) {
			e.printStackTrace();
		}

	}

}
