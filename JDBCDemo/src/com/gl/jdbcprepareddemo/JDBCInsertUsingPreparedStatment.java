package com.gl.jdbcprepareddemo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.util.Scanner;

public class JDBCInsertUsingPreparedStatment {

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
			 pstmt = con.prepareStatement("insert into student values(?,?,?,?)");
			 
			 System.out.println("Enter the details of the student.....");
			 System.out.println("Enter student id ");
			 int sid = sc.nextInt();
			 System.out.println("Enter student name");
			 sc.nextLine();
			 String sname = sc.nextLine();
			 System.out.println("Enter student marks");
			 float smarks = sc.nextFloat();
			 System.out.println("Enter student branch");
			 String sbranch = sc.next();
			 
			 pstmt.setInt(1, sid);
			 pstmt.setString(2, sname);
			 pstmt.setFloat(3, smarks);
			 pstmt.setString(4, sbranch);
			 
			 int rowsInserted = pstmt.executeUpdate();
			
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
