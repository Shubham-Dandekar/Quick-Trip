package com.sunshine.main;

import java.util.Scanner;

import com.sunshine.exception.AdministratorException;
import com.sunshine.exception.CustomerException;
import com.sunshine.usecases.AdminUseCase;
import com.sunshine.usecases.CustomerUseCase;

public class Main {

	static int primaryKey;
	static boolean flag = false;

    public static void main(String[] args) {

        System.out.println("+--------------------------------------------------+");
        System.out.println("|    🚗 Welcome to Sunshine Tours & Travels 🚗     |");

        welcomeScreen();
    }

    private static void welcomeScreen() {
        Scanner scan = new Scanner(System.in);

        System.out.println("+--------------------------------------------------+");
        System.out.println("\nEnter numbers to perform actions.\n");

        System.out.println("1. Adminstrator");
        System.out.println("2. Customer");
        System.out.println("0. Exit");

        System.out.print("\nEnter your choice: ");

        int choice = scan.nextInt();

        switch (choice) {
            case 0:
                System.out.println("\nThank you for visiting Coding Camp,\nHave a great day...❤❤");
                break;

            case 1:

                System.out.println("\n+--------------------------------------------------+");
                System.out.println("\nWelcome to Administrstor Page\n");
                adminChoice();
                break;

            case 2:
                System.out.println("\n+--------------------------------------------------+");
                System.out.println("\nWelcome to customer Page\n");
                customerChoice();
                break;

            default:
                System.out.println("\nYou have entered wrong choice, exiting...");
                break;
        }
    }

    private static void adminChoice() {
    	AdminUseCase adminUseCase = new AdminUseCase();
    	
        Scanner scan = new Scanner(System.in);

        System.out.println("\nEnter numbers to perform actions.\n");
        System.out.println("1. Admistrator LogIn");
        System.out.println("2. Register new administrator");
        System.out.println("0. Go to main page");

        System.out.print("\nEnter your choice: ");

        int choice = scan.nextInt();
        System.out.println();

        switch (choice) {
            case 0:
                welcomeScreen();
                break;

            case 1:
                System.out.println("Enter Administrstor's credentials to LogIn\n");
                try {
					primaryKey = adminUseCase.login();

					if (primaryKey == -1) {
						adminChoice();
					} else {
						flag = true;
						
						while(flag) adminMenu();
					}
				} catch (AdministratorException e) {
					System.out.println(e.getMessage());
				}
                break;
                
            case 2:
            	adminUseCase.registerNewAdmin();
            	adminChoice();
                break;

            default:
                System.out.println("You have entered wrong choice");
                adminChoice();
                break;
        }
    }

    private static void customerChoice() {
    	CustomerUseCase custUseCase = new CustomerUseCase();
    	
        Scanner scan = new Scanner(System.in);

        System.out.println("\nEnter numbers to perform actions.\n");
        System.out.println("1. Register a new customer");
        System.out.println("2. Customer LogIn");
        System.out.println("0. Go to main page");

        System.out.print("\nEnter your choice: ");

        int choice = scan.nextInt();
        System.out.println();

        switch (choice) {
            case 0:
                welcomeScreen();
                break;

            case 1:
                custUseCase.registerNewCustomer();
                customerChoice();
                break;

            case 2:
                System.out.println("Enter customer's credentials to LogIn\n");
				try {
					primaryKey = custUseCase.login();

					if (primaryKey == -1) {
						customerChoice();
					} else {
						flag = true;
						
						while(flag) customerMenu();
					}
				} catch (CustomerException e) {
					System.out.println(e.getMessage());
				}
                break;

            default:
                System.out.println("You have entered wrong choice");
                customerChoice();
                break;
        }
    }
    
    
    private static void adminMenu() {
    	AdminUseCase adminUseCase = new AdminUseCase();
    	
        Scanner scan = new Scanner(System.in);

        System.out.println("\nEnter numbers to perform actions.\n");
        System.out.println("1. Show admin details");
        System.out.println("2. Edit admin details");
        System.out.println("3. Show password");
        System.out.println("4. Change password");
        System.out.println("5. Add new bus");
        System.out.println("6. Show all buses");
        System.out.println("7. Confirm tickets");
        System.out.println("0. SignOut");

        System.out.print("\nEnter your choice: ");

        int choice = scan.nextInt();
        System.out.println();

        switch (choice) {
            case 0:
                flag = false;
                System.out.println("\nThank you for visiting Coding Camp,\nHave a great day...❤️❤️");
                System.exit(0);
                break;

            case 1:
            	adminUseCase.showAdminDetails(primaryKey);
                break;

            case 2:
                updateAdminMenu();
                break;

            case 3:
            	adminUseCase.getAdminPassword(primaryKey);
                break;

            case 4:
            	adminUseCase.changeAdminPassword(primaryKey);
                break;

            case 5:
                adminUseCase.addNewBus();
                break;
                
            case 6:
                adminUseCase.showAllBuses();
                break;

            case 7:
                adminUseCase.confirmTicket();
                break;

            default:
                System.out.println("You have entered wrong choice, try again...");
                break;
        }
    }
    
    private static void updateAdminMenu() {
    	AdminUseCase adminUseCase = new AdminUseCase();
    	
        Scanner scan = new Scanner(System.in);

        System.out.println("\nEnter numbers to perform actions.\n");
        System.out.println("1. Change admin's first name");
        System.out.println("2. Change admin's last name");
        System.out.println("3. Change admin's father name");
        System.out.println("4. Change admin's mother name");
        System.out.println("5. Change admin's gender");
        System.out.println("6. Change admin's date of birth");
        System.out.println("7. Change admin's address");
        System.out.println("8. Change admin's contact no");
        System.out.println("0. Go back");

        System.out.print("\nEnter your choice: ");

        int choice = scan.nextInt();
        System.out.println();

        switch (choice) {
            case 0:
                adminMenu();
                break;

            case 1:
            	adminUseCase.changeAdminFirstName(primaryKey);
                break;

            case 2:
            	adminUseCase.changeAdminLastName(primaryKey);
                break;

            case 3:
            	adminUseCase.changeAdminFatherName(primaryKey);
                break;

            case 4:
            	adminUseCase.changeAdminMotherName(primaryKey);
                break;

            case 5:
            	adminUseCase.changeAdminGender(primaryKey);
                break;

            case 6:
            	adminUseCase.changeAdminDateOfBirth(primaryKey);
                break;

            case 7:
            	adminUseCase.changeAdminAddress(primaryKey);
                break;

            case 8:
            	adminUseCase.changeAdminContactNo(primaryKey);
                break;

            default:
                System.out.println("You have entered wrong choice, try again...");
                break;
        }
    }

    private static void customerMenu() {
    	CustomerUseCase custUseCase = new CustomerUseCase();
    	
        Scanner scan = new Scanner(System.in);

        System.out.println("\nEnter numbers to perform actions.\n");
        System.out.println("1. Show customer details");
        System.out.println("2. Update customer details");
        System.out.println("3. Show password");
        System.out.println("4. Change password");
        System.out.println("5. Book ticket");
        System.out.println("6. Show all booked tickets");
        System.out.println("0. SignOut");

        System.out.print("\nEnter your choice: ");

        int choice = scan.nextInt();
        System.out.println();

        switch (choice) {
            case 0:
                System.out.println("\nThank you for visiting Coding Camp,\nHave a great day...❤️❤️");
                System.exit(0);
                break;

            case 1:
            	custUseCase.showCustomerDetails(primaryKey);
                break;

            case 2:
            	updateCustomerMenu();
                break;

            case 3:
            	custUseCase.getCustomerPassword(primaryKey);
                break;

            case 4:
            	custUseCase.changeCustomerPassword(primaryKey);
                break;

            case 5:
            	custUseCase.bookTicket(primaryKey);
                break;
                
            case 6:
            	custUseCase.showAllTickets(primaryKey);
                break;

            default:
                System.out.println("You have entered wrong choice, try again...");
                break;
        }
    }
    
    private static void updateCustomerMenu() {
    	CustomerUseCase custUseCase = new CustomerUseCase();
    	
        Scanner scan = new Scanner(System.in);

        System.out.println("\nEnter numbers to perform actions.\n");
        System.out.println("1. Change customer's first name");
        System.out.println("2. Change customer's last name");
        System.out.println("3. Change customer's father name");
        System.out.println("4. Change customer's mother name");
        System.out.println("5. Change customer's gender");
        System.out.println("6. Change customer's date of birth");
        System.out.println("7. Change customer's address");
        System.out.println("8. Change customer's contact no");
        System.out.println("0. Go back");

        System.out.print("\nEnter your choice: ");

        int choice = scan.nextInt();
        System.out.println();

        switch (choice) {
            case 0:
                customerMenu();
                break;

            case 1:
            	custUseCase.changeCustomerFirstName(primaryKey);
                break;

            case 2:
            	custUseCase.changeCustomerLastName(primaryKey);
                break;

            case 3:
            	custUseCase.changeCustomerFatherName(primaryKey);
                break;

            case 4:
            	custUseCase.changeCustomerMotherName(primaryKey);
                break;

            case 5:
            	custUseCase.changeCustomerGender(primaryKey);
                break;

            case 6:
            	custUseCase.changeCustomerDateOfBirth(primaryKey);
                break;

            case 7:
            	custUseCase.changeCustomerAddress(primaryKey);
                break;

            case 8:
            	custUseCase.changeCustomerContactNo(primaryKey);
                break;

            default:
                System.out.println("You have entered wrong choice, try again...");
                break;
        }
    }
}
