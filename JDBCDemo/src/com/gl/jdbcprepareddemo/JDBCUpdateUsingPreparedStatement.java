package com.gl.jdbcprepareddemo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Scanner;

public class JDBCUpdateUsingPreparedStatement {


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
			 pstmt = con.prepareStatement("update student set studmarks = ?,studbranch=? where studid = ?");
			 
			 System.out.println("Enter the details of the student.....");
			 System.out.println("Enter student id ");
			 int sid = sc.nextInt();
			 System.out.println("Enter student marks to update ");
			 float smarks = sc.nextFloat();
			 System.out.println("Enter student branch to update ");
			 String sbranch = sc.next();
	
			 pstmt.setInt(3, sid);
			 pstmt.setString(2, sbranch);
			 pstmt.setFloat(1, smarks);
			 
			 int rowsUpdated = pstmt.executeUpdate();
			
			if(rowsUpdated!=0) {
				System.out.println("Student data updated....");
			}else {
				System.out.println("Student data not updated....");
			}
		
		}catch (Exception e) {
			e.printStackTrace();
		}


	}


}
