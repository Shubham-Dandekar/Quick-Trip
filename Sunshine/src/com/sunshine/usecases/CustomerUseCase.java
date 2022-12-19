package com.sunshine.usecases;

import java.util.List;
import java.util.Scanner;

import com.sunshine.dao.BusDAO;
import com.sunshine.dao.BusDAOImpl;
import com.sunshine.dao.CustomerDAO;
import com.sunshine.dao.CustomerDAOImpl;
import com.sunshine.dao.TicketDAO;
import com.sunshine.dao.TicketDAOImpl;
import com.sunshine.exception.BusException;
import com.sunshine.exception.CustomerException;
import com.sunshine.model.Bus;
import com.sunshine.model.Customer;
import com.sunshine.model.CustomerTicket;

public class CustomerUseCase {
	public void registerNewCustomer() {
        Scanner scan = new Scanner(System.in);

        System.out.print("Enter customer's first name (max 10 characters): ");
        String firstName = scan.next();

        System.out.print("Enter customer's last name (max 10 characters): ");
        String lastName = scan.next();

        System.out.print("Enter customer's father name (max 10 characters): ");
        String fatherName = scan.next();

        System.out.print("Enter customer's mother name (max 10 characters): ");
        String motherName = scan.next();

        System.out.print("Enter customer's gender (male/female): ");
        String gender = scan.next();

        System.out.print("Enter customer's date of birth (yyyy-mm-dd): ");
        String dateOfBirth = scan.next();

        scan.nextLine();

        System.out.print("Enter customer's address (State max 15 characters): ");
        String address = scan.nextLine();

        System.out.print("Enter customer's contact no (10 digits): ");
        String contactNo = scan.next();

        System.out.print("Enter customer's email (max 30 characters): ");
        String email = scan.next();

        System.out.print("Enter customer's password(min 8 & max 16 characters): ");
        String password = scan.next();
        
        

        Customer customer = new Customer(firstName, fatherName, lastName, motherName, 
        		dateOfBirth, gender, address, contactNo, email, password);

        CustomerDAO stdDao = new CustomerDAOImpl();

        try {
            String message = stdDao.registerNewCustomer(customer);

            System.out.println(message);
        } catch (CustomerException e) {
            System.out.println(e.getMessage());
        }
    }

	
	public int login() throws CustomerException {

        Scanner scan = new Scanner(System.in);

        System.out.print("Enter your email: ");
        String email = scan.next();
        System.out.print("Enter your password: ");
        String password = scan.next();
        
        

        CustomerDAO CustomerDAO = new CustomerDAOImpl();
        
        int primaryKey = -1;

        try {
            primaryKey = CustomerDAO.customerLogIn(email, password);

            if (primaryKey == -1) {
                System.out.println("Bad credentials...");
            } else {
                String name = CustomerDAO.getCustomerName(primaryKey);
                System.out.println("\n+--------------------------------------------------+\n");
                System.out.println("Welcome " + name + ",\n");
            }
            return primaryKey;

        } catch (CustomerException e) {
            throw new CustomerException(e.getMessage());
        }
    }
	
	public void showCustomerDetails(int primaryKey) {
    	CustomerDAO CustomerDAO = new CustomerDAOImpl();

        try {
            Customer customer;
            customer = CustomerDAO.showCustomerDetails(primaryKey);

            System.out.println("+---------------+------------+------------+-------------+-------------+"
                    + "--------+---------------+-----------------+------------+-----------------------"
                    + "---------+\n|  Customer ID  | First_Name | Last_Name  | Father_Name | Mother_Nam"
                    + "e | Gender | Date_Of_Birth | Address         | Contact_No | Email              "
                    + "            |\n+---------------+------------+------------+-------------+--------"
                    + "-----+--------+---------------+-----------------+------------+-----------------"
                    + "---------------+");

            System.out.printf("| %-13d | %-10s | %-10s | %-11s | %-11s | %-6s | %-13s | %-15s | %-10s |"
                    + " %-30s |\n", primaryKey, customer.getFirstName(), customer.getLastName(),
                    customer.getFatherName(), customer.getMotherName(), customer.getGender(),
                    customer.getDateOfBirth(), customer.getAddress(), customer.getContactNo(),
                    customer.getEmail());

            System.out.println("+---------------+------------+------------+-------------+-------------+-"
                    + "-------+---------------+-----------------+------------+-------------------------"
                    + "-------+\n");

        } catch (CustomerException e) {
            System.out.println(e.getMessage());
        }
    }

    public void changeCustomerFirstName(int primaryKey) {
        Scanner scan = new Scanner(System.in);

        System.out.print("Enter customer's new first name: ");
        String fname = scan.next();

        CustomerDAO CustomerDAO = new CustomerDAOImpl();

        try {
            String message = CustomerDAO.changeCustomerFirstName(fname, primaryKey);

            System.out.println(message);
        } catch (CustomerException e) {
            System.out.println(e.getMessage());
        } 
    }
    
    public void changeCustomerLastName(int primaryKey) {
        Scanner scan = new Scanner(System.in);

        System.out.print("Enter customer's new last name: ");
        String lname = scan.next();

        CustomerDAO CustomerDAO = new CustomerDAOImpl();

        try {
            String message = CustomerDAO.changeCustomerLastName(lname, primaryKey);

            System.out.println(message);
        } catch (CustomerException e) {
            System.out.println(e.getMessage());
        } 
    }

    public void changeCustomerFatherName(int primaryKey) {
        Scanner scan = new Scanner(System.in);

        System.out.print("Enter customer's new father name: ");
        String fathername = scan.next();

        CustomerDAO CustomerDAO = new CustomerDAOImpl();

        try {
            String message = CustomerDAO.changeCustomerFatherName(fathername, primaryKey);

            System.out.println(message);
        } catch (CustomerException e) {
            System.out.println(e.getMessage());
        } 
    }

    public void changeCustomerMotherName(int primaryKey) {
        Scanner scan = new Scanner(System.in);

        System.out.print("Enter customer's new mother name: ");
        String mothername = scan.next();

        CustomerDAO CustomerDAO = new CustomerDAOImpl();

        try {
            String message = CustomerDAO.changeCustomerMotherName(mothername, primaryKey);

            System.out.println(message);
        } catch (CustomerException e) {
            System.out.println(e.getMessage());
        } 
    }

    public void changeCustomerGender(int primaryKey) {
        Scanner scan = new Scanner(System.in);

        System.out.print("Enter customer's new gender: ");
        String gender = scan.next();

        CustomerDAO CustomerDAO = new CustomerDAOImpl();

        try {
            String message = CustomerDAO.changeCustomerGender(gender, primaryKey);

            System.out.println(message);
        } catch (CustomerException e) {
            System.out.println(e.getMessage());
        } 
    }

    public void changeCustomerDateOfBirth(int primaryKey) {
        Scanner scan = new Scanner(System.in);

        System.out.print("Enter customer's new date of birth: ");
        String dob = scan.next();

        CustomerDAO CustomerDAO = new CustomerDAOImpl();

        try {
            String message = CustomerDAO.changeCustomerDateOfBirth(dob, primaryKey);

            System.out.println(message);
        } catch (CustomerException e) {
            System.out.println(e.getMessage());
        } 
    }

    public void getCustomerPassword(int primaryKey) {
        CustomerDAO CustomerDAO = new CustomerDAOImpl();

        try {
            String message = CustomerDAO.getCustomerPassword(primaryKey);

            System.out.println(message);
        } catch (CustomerException e) {
            System.out.println(e.getMessage());
        }
    }

    public void changeCustomerPassword(int primaryKey) {
        Scanner scan = new Scanner(System.in);

        System.out.print("Enter customer's new password: ");
        String password = scan.next();

        CustomerDAO CustomerDAO = new CustomerDAOImpl();

        try {
            String message = CustomerDAO.changeCustomerPassword(password, primaryKey);

            System.out.println(message);
        } catch (CustomerException e) {
            System.out.println(e.getMessage());
        } 
    }

    public void changeCustomerAddress(int primaryKey) {
        Scanner scan = new Scanner(System.in);

        System.out.print("Enter customer's new address: ");
        String address = scan.next();

        CustomerDAO CustomerDAO = new CustomerDAOImpl();

        try {
            String message = CustomerDAO.changeCustomerAddress(address, primaryKey);

            System.out.println(message);
        } catch (CustomerException e) {
            System.out.println(e.getMessage());
        } 
    }

    public void changeCustomerContactNo(int primaryKey) {
        Scanner scan = new Scanner(System.in);

        System.out.print("Enter customer's new contact no: ");
        String contact = scan.next();

        CustomerDAO CustomerDAO = new CustomerDAOImpl();

        try {
            String message = CustomerDAO.changeCustomerContactNo(contact, primaryKey);

            System.out.println(message);
        } catch (CustomerException e) {
            System.out.println(e.getMessage());
        } 
    }
    
    public void bookTicket(int primaryKey) {
    	BusDAO busDao = new BusDAOImpl();
    	
    	try {
			List<Bus> buses = busDao.showAllBus();
			
			buses.forEach(b -> {
				System.out.println("+----------------------------------------+");
    			System.out.printf("| Bus ID: %-30d |\n", b.getBusID());
    			System.out.printf("| Bus Name: %-28s |\n", b.getBusName());
    			System.out.printf("| Start Point: %-26s|\n", b.getStartPoint());
    			System.out.printf("| End Point: %-28s|\n", b.getEndPoint());
    			System.out.printf("| Start Time: %-27s|\n", b.getStartTime());
    			System.out.printf("| End Time: %-29s|\n", b.getEndTime());
    			System.out.printf("| Capacity: %-29s|\n", b.getCapacity());
    			System.out.printf("| Seats Available: %-22s|\n", b.getSeatsAvailable());
    			System.out.println("+----------------------------------------+\n");
			});
		} catch (BusException e1) {
			System.out.println(e1.getMessage());
		}
    	
    	
    	Scanner scan = new Scanner(System.in);

        System.out.print("Enter bus ID to book ticket: ");
        int busID = scan.nextInt();
        
        System.out.print("Enter no of seats to book ticket: ");
        int seats = scan.nextInt();
        
        TicketDAO ticketDao = new TicketDAOImpl();
        
        try {
        	System.out.println(ticketDao.bookTicket(primaryKey, busID, seats));
		} catch (BusException e) {
			System.out.println(e.getMessage());
		}
    }
    
    public void showAllTickets(int primaryKey) {
    	TicketDAO ticketDao = new TicketDAOImpl();
    	
    	try {
    		List<CustomerTicket> tickets = ticketDao.checkAllTickets(primaryKey);
    		tickets.forEach(t -> {
    			System.out.println("+----------------------------------------+");
    			System.out.printf("| Ticket ID: %-27d |\n", t.getTicketID());
    			System.out.printf("| Bus Name: %-28s |\n", t.getBusName());
    			System.out.printf("| Start Point: %-26s|\n", t.getStartPoint());
    			System.out.printf("| End Point: %-28s|\n", t.getEndPoint());
    			System.out.printf("| Start Time: %-27s|\n", t.getStartTime());
    			System.out.printf("| End Time: %-29s|\n", t.getEndTime());
    			System.out.printf("| Seats Booked: %-25s|\n", t.getSeatsBooked());
    			System.out.printf("| Status: %-31s|\n", t.getBookingStatus());
    			System.out.println("+----------------------------------------+\n");
    		});
		} catch (BusException e) {
			System.out.println(e.getMessage());
		}
    }
}
