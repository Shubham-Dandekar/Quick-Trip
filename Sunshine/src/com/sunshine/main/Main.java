package com.sunshine.main;

import java.util.Scanner;

import com.sunshine.dao.AdministratorDAO;
import com.sunshine.dao.AdministratorDAOImpl;
import com.sunshine.dao.CustomerDAO;
import com.sunshine.dao.CustomerDAOImpl;
import com.sunshine.exception.AdministratorException;
import com.sunshine.exception.CustomerException;
import com.sunshine.model.Administrator;
import com.sunshine.model.Customer;

public class Main {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);

        System.out.print("Enter student's first name (max 10 characters): ");
        String firstName = scan.next();

        System.out.print("Enter student's last name (max 10 characters): ");
        String lastName = scan.next();

        System.out.print("Enter student's father name (max 10 characters): ");
        String fatherName = scan.next();

        System.out.print("Enter student's mother name (max 10 characters): ");
        String motherName = scan.next();

        System.out.print("Enter student's gender (male/female): ");
        String gender = scan.next();

        System.out.print("Enter student's date of birth (yyyy-mm-dd): ");
        String dateOfBirth = scan.next();
        
        scan.nextLine();

        System.out.print("Enter student's address (State max 15 characters): ");
        String address = scan.nextLine();

        System.out.print("Enter student's contact no (10 digits): ");
        String contactNo = scan.next();

        System.out.print("Enter student's email (max 30 characters): ");
        String email = scan.next();

        System.out.print("Enter student's password(min 8 & max 16 characters): ");
        String password = scan.next();
        
        Customer admin = new Customer(0, firstName, fatherName, lastName, motherName, dateOfBirth, gender, address, contactNo, email, password);
        
        CustomerDAO adminDAO = new CustomerDAOImpl();
        
        try {
			adminDAO.registerNewCustomer(admin);
		} catch (CustomerException e) {
			e.printStackTrace();
		}
	}

}
