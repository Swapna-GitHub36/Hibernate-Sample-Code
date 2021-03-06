package com.gl.jdbcprepareddemo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Scanner;

public class JDBCDeleteUsingPreparedStatement {

	public static void main(String[] args) {
		Connection con = null;
		PreparedStatement pstmt = null;
		Scanner sc = new Scanner(System.in);
		try {
			// step1 : register the driver
			Class.forName("oracle.jdbc.driver.OracleDriver");
			// step2 : establish the connection
			con = DriverManager.
					getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","root");
			//step3 : create statement
			 pstmt = con.prepareStatement("delete from student where studid = ?");
			 
			 System.out.println("Enter the details of the student.....");
			 System.out.println("Enter student id ");
			 int sid = sc.nextInt();
	
			 pstmt.setInt(1, sid);
			
			 
			 int rowsInserted = pstmt.executeUpdate();
			
			if(rowsInserted!=0) {
				System.out.println("Student data deleted....");
			}else {
				System.out.println("Student data not deleted....");
			}
		
		}catch (Exception e) {
			e.printStackTrace();
		}


	}

}
