package com.gl.hibernateexampleusingjavaconfig.helper;

import java.util.List;
import java.util.Scanner;

import com.gl.hibernateexampleusingjavaconfig.dao.EmployeeDao;
import com.gl.hibernateexampleusingjavaconfig.entity.Employee;

public class EmployeeCRUDOperations {
	EmployeeDao edao = new EmployeeDao();
	Scanner sc = new Scanner(System.in);
	Employee emp = new Employee();
	char ch = 'y';
	public void displayEmployeeCRUDOperations() {
		while(ch == 'y') {
		System.out.println("Enter the Operation ......");
		System.out.println("1. Insert");
		System.out.println("2. Update");
		System.out.println("3. Delete");
		System.out.println("4. Display All Employees");
		System.out.println("5. Search An Employee");
		int op = sc.nextInt();
		switch (op) {
		case 1:
			edao.insertEmployee(readEmployeeDetails());
			break;
		case 2:
			System.out.println("Enter the Employee Id to delete...");
			Long empid2 = sc.nextLong();
			
			System.out.println("Enter employee Salary");
			float empsal =sc.nextFloat();
			edao.updateEmployee(empid2, empsal);
			break;
		case 3:
			System.out.println("Enter the Employee Id to delete...");
			Long empid1 = sc.nextLong();
			edao.deleteEmployee(Employee.class,empid1);
			break;
		case 4:
			List<Employee> empList = edao.selectAllEmployees();
			displayEmpDetails(empList);
		
			break;
		case 5:
			System.out.println("Enter the Employee Id to search...");
			Long empid = sc.nextLong();
			edao.searchAnEmployee(empid);
			break;

		default:
			System.out.println("Not a right operation");
			break;
		}
		System.out.println("do you want to continue... y - yes or n - no");
		ch = sc.next().charAt(0);
		}
	}
	private void displayEmpDetails(List<Employee> empList) {
		System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");	
		System.out.println("employeeId" + "\t\t" + "employeeName" + "\t\t" + "empSalary");
		System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
		empList.forEach(e -> System.out.println(e.getEmpId() + "\t\t" + e.getEmpName()+ "\t\t" + e.getEmpSalary()));
		
	}
	private Employee readEmployeeDetails() {
		System.out.println("Enter the Employee Details....");
		System.out.println("Enter employee Name");
		sc.nextLine();
		emp.setEmpName(sc.nextLine());
		System.out.println("Enter employee Salary");
		emp.setEmpSalary(sc.nextFloat());
		return emp;
	}
}
