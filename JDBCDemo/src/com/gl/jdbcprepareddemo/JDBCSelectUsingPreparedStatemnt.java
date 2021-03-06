package com.gl.jdbcprepareddemo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

public class JDBCSelectUsingPreparedStatemnt {

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
			 pstmt = con.prepareStatement("select * from student where studid = ?");
			 
			 System.out.println("Enter the details of the student.....");
			 System.out.println("Enter student id ");
			 int sid = sc.nextInt();
			
			 
			 pstmt.setInt(1, sid);
			
			 ResultSet rs = pstmt.executeQuery();
			//print the result
				System.out.println("Student data........");
				System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
				System.out.println("StudentId" + "\t" + "StudentName" + "\t" + "StudentMarks" + "\t" + "StudentBranch");
				System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
			while(rs.next()) {
				System.out.println(rs.getInt("studid")+ "\t" +rs.getString("studname")
				+ "\t" + rs.getFloat("studmarks")+ "\t" +rs.getString("studbranch"));
			}
		
		}catch (Exception e) {
			e.printStackTrace();
		}


	}

}
