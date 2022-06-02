package com.gl.hibernateexampleusingjavaconfig;


import com.gl.hibernateexampleusingjavaconfig.helper.EmployeeCRUDOperations;

public class MainHibernateDemo {

	public static void main(String[] args) {
	
		
		EmployeeCRUDOperations empCRUD = new EmployeeCRUDOperations() ;
		
		empCRUD.displayEmployeeCRUDOperations();
		


	}

}
