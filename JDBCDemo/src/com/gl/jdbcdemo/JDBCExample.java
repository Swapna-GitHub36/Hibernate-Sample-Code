package com.gl.jdbcdemo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBCExample {

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
			ResultSet rs = stmt.executeQuery("select * from student");
			//print the result
			System.out.println("Student data........");
			System.out.println("+++++++++++++++++++++++++++++++++++");
			System.out.println("StudentId" + "\t\t" + "StudentName");
			System.out.println("+++++++++++++++++++++++++++++++++++");
			while(rs.next()) {
				System.out.println(rs.getInt("studid")+ "\t" +rs.getString("studname"));
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				con.close();
				stmt.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally {
				
			}
			
		}

	}

}
