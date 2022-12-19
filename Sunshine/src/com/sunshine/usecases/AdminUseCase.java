package com.sunshine.usecases;

import java.util.List;
import java.util.Scanner;

import com.sunshine.dao.AdministratorDAO;
import com.sunshine.dao.AdministratorDAOImpl;
import com.sunshine.dao.BusDAO;
import com.sunshine.dao.BusDAOImpl;
import com.sunshine.dao.TicketDAO;
import com.sunshine.dao.TicketDAOImpl;
import com.sunshine.exception.AdministratorException;
import com.sunshine.exception.BusException;
import com.sunshine.model.Administrator;
import com.sunshine.model.Bus;
import com.sunshine.model.CustomerTicket;

public class AdminUseCase {
	public void registerNewAdmin() {
        Scanner scan = new Scanner(System.in);

        System.out.print("Enter admin's first name (max 10 characters): ");
        String firstName = scan.next();

        System.out.print("Enter admin's last name (max 10 characters): ");
        String lastName = scan.next();

        System.out.print("Enter admin's father name (max 10 characters): ");
        String fatherName = scan.next();

        System.out.print("Enter admin's mother name (max 10 characters): ");
        String motherName = scan.next();

        System.out.print("Enter admin's gender (male/female): ");
        String gender = scan.next();

        System.out.print("Enter admin's date of birth (yyyy-mm-dd): ");
        String dateOfBirth = scan.next();

        scan.nextLine();

        System.out.print("Enter admin's address (State max 15 characters): ");
        String address = scan.nextLine();

        System.out.print("Enter admin's contact no (10 digits): ");
        String contactNo = scan.next();

        System.out.print("Enter admin's email (max 30 characters): ");
        String email = scan.next();

        System.out.print("Enter admin's password(min 8 & max 16 characters): ");
        String password = scan.next();
        
        

        Administrator Administrator = new Administrator(firstName, fatherName, lastName, motherName, 
        		dateOfBirth, gender, address, contactNo, email, password);

        AdministratorDAO stdDao = new AdministratorDAOImpl();

        try {
            String message = stdDao.registerNewAdmin(Administrator);

            System.out.println(message);
        } catch (AdministratorException e) {
            System.out.println(e.getMessage());
        }
    }
	
	public int login() throws AdministratorException {

        Scanner scan = new Scanner(System.in);

        System.out.print("Enter your email: ");
        String email = scan.next();
        System.out.print("Enter your password: ");
        String password = scan.next();
        
        

        AdministratorDAO AdministratorDAO = new AdministratorDAOImpl();
        
        int primaryKey = -1;

        try {
            primaryKey = AdministratorDAO.adminLogIn(email, password);

            if (primaryKey == -1) {
                System.out.println("Bad credentials...");
            } else {
                String name = AdministratorDAO.getAdminName(primaryKey);
                System.out.println("\n+--------------------------------------------------+\n");
                System.out.println("Welcome " + name + ",\n");
            }
            return primaryKey;

        } catch (AdministratorException e) {
            throw new AdministratorException(e.getMessage());
        }
    }
	
	public void showAdminDetails(int primaryKey) {
    	AdministratorDAO adminDao = new AdministratorDAOImpl();

        try {
            Administrator admin;
            admin = adminDao.showAdminDetails(primaryKey);

            System.out.println("+--------------+------------+------------+-------------+-------------+"
                    + "--------+---------------+-----------------+------------+-----------------------"
                    + "---------+\n|  Admin ID    | First_Name | Last_Name  | Father_Name | Mother_Nam"
                    + "e | Gender | Date_Of_Birth | Address         | Contact_No | Email              "
                    + "            |\n+--------------+------------+------------+-------------+--------"
                    + "-----+--------+---------------+-----------------+------------+-----------------"
                    + "---------------+");

            System.out.printf("| %-12d | %-10s | %-10s | %-11s | %-11s | %-6s | %-13s | %-15s | %-10s |"
                    + " %-30s |\n", primaryKey, admin.getFirstName(), admin.getLastName(),
                    admin.getFatherName(), admin.getMotherName(), admin.getGender(),
                    admin.getDateOfBirth(), admin.getAddress(), admin.getContactNo(),
                    admin.getEmail());

            System.out.println("+--------------+------------+------------+-------------+-------------+-"
                    + "-------+---------------+-----------------+------------+-------------------------"
                    + "-------+\n");

        } catch (AdministratorException e) {
            System.out.println(e.getMessage());
        }
    }

    public void changeAdminFirstName(int primaryKey) {
        Scanner scan = new Scanner(System.in);

        System.out.print("Enter admin's new first name: ");
        String fname = scan.next();

        AdministratorDAO adminDao = new AdministratorDAOImpl();

        try {
            String message = adminDao.changeAdminFirstName(fname, primaryKey);

            System.out.println(message);
        } catch (AdministratorException e) {
            System.out.println(e.getMessage());
        }
    }
    
    public void changeAdminLastName(int primaryKey) {
        Scanner scan = new Scanner(System.in);

        System.out.print("Enter admin's new last name: ");
        String lname = scan.next();

        AdministratorDAO adminDao = new AdministratorDAOImpl();

        try {
            String message = adminDao.changeAdminLastName(lname, primaryKey);

            System.out.println(message);
        } catch (AdministratorException e) {
            System.out.println(e.getMessage());
        }
    }

    public void changeAdminFatherName(int primaryKey) {
        Scanner scan = new Scanner(System.in);

        System.out.print("Enter admin's new father name: ");
        String fathername = scan.next();

        AdministratorDAO adminDao = new AdministratorDAOImpl();

        try {
            String message = adminDao.changeAdminFatherName(fathername, primaryKey);

            System.out.println(message);
        } catch (AdministratorException e) {
            System.out.println(e.getMessage());
        }
    }

    public void changeAdminMotherName(int primaryKey) {
        Scanner scan = new Scanner(System.in);

        System.out.print("Enter admin's new mother name: ");
        String mothername = scan.next();

        AdministratorDAO adminDao = new AdministratorDAOImpl();

        try {
            String message = adminDao.changeAdminMotherName(mothername, primaryKey);

            System.out.println(message);
        } catch (AdministratorException e) {
            System.out.println(e.getMessage());
        }
    }

    public void changeAdminGender(int primaryKey) {
        Scanner scan = new Scanner(System.in);

        System.out.print("Enter admin's new gender: ");
        String gender = scan.next();

        AdministratorDAO adminDao = new AdministratorDAOImpl();

        try {
            String message = adminDao.changeAdminGender(gender, primaryKey);

            System.out.println(message);
        } catch (AdministratorException e) {
            System.out.println(e.getMessage());
        }
    }

    public void changeAdminDateOfBirth(int primaryKey) {
        Scanner scan = new Scanner(System.in);

        System.out.print("Enter admin's new date of birth: ");
        String dob = scan.next();

        AdministratorDAO adminDao = new AdministratorDAOImpl();

        try {
            String message = adminDao.changeAdminDateOfBirth(dob, primaryKey);

            System.out.println(message);
        } catch (AdministratorException e) {
            System.out.println(e.getMessage());
        }
    }

    public void getAdminPassword(int primaryKey) {
        AdministratorDAO adminDao = new AdministratorDAOImpl();

        try {
            String message = adminDao.getAdminPassword(primaryKey);

            System.out.println(message);
        } catch (AdministratorException e) {
            System.out.println(e.getMessage());
        }
    }

    public void changeAdminPassword(int primaryKey) {
        Scanner scan = new Scanner(System.in);

        System.out.print("Enter admin's new password: ");
        String password = scan.next();

        AdministratorDAO adminDao = new AdministratorDAOImpl();

        try {
            String message = adminDao.changeAdminPassword(password, primaryKey);

            System.out.println(message);
        } catch (AdministratorException e) {
            System.out.println(e.getMessage());
        }
    }

    public void changeAdminAddress(int primaryKey) {
        Scanner scan = new Scanner(System.in);

        System.out.print("Enter admin's new address: ");
        String address = scan.next();

        AdministratorDAO adminDao = new AdministratorDAOImpl();

        try {
            String message = adminDao.changeAdminAddress(address, primaryKey);

            System.out.println(message);
        } catch (AdministratorException e) {
            System.out.println(e.getMessage());
        }
    }

    public void changeAdminContactNo(int primaryKey) {
        Scanner scan = new Scanner(System.in);

        System.out.print("Enter admin's new contact no: ");
        String contact = scan.next();

        AdministratorDAO adminDao = new AdministratorDAOImpl();

        try {
            String message = adminDao.changeAdminContactNo(contact, primaryKey);

            System.out.println(message);
        } catch (AdministratorException e) {
            System.out.println(e.getMessage());
        }
    }
    
    public void addNewBus() {
    	Scanner scan = new Scanner(System.in);
    	
    	System.out.print("Enter bus name (max 10 characters): ");
        String busName = scan.next();

        System.out.print("Enter stating point (max 10 characters): ");
        String startPoint = scan.next();

        System.out.print("Enter end point (max 10 characters): ");
        String endPoint = scan.next();

        System.out.print("Enter start time (max 10 characters): ");
        String startTime = scan.next();

        System.out.print("Enter end time (max 10 characters): ");
        String endTime = scan.next();

        System.out.print("Enter capacity:  ");
        int capacity = scan.nextInt();

        System.out.print("Enter seats available: ");
        int seatsAvailable = scan.nextInt();  

        Bus bus = new Bus(busName, startPoint, endPoint, startTime, endTime, capacity, seatsAvailable);
        
        BusDAO busDao = new BusDAOImpl();

        try {
            String message = busDao.addNewBus(bus);
            System.out.println(message);
        } catch (BusException e) {
            System.out.println(e.getMessage());
        }
    }
    
    public void showAllBuses() {
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
    }
    
    public void confirmTicket() {
    	TicketDAO ticketDao = new TicketDAOImpl();
    	
    	try {
    		List<CustomerTicket> tickets = ticketDao.unconfirmedTickets();
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
    	
    	Scanner scan = new Scanner(System.in);
    	
    	System.out.print("Enter ticket ID to confirm ticket: ");
    	
    	int ticketID = scan.nextInt();
    	
    	try {
			CustomerTicket ticket = ticketDao.confirmTicket(ticketID);
			
			System.out.println("+----------------------------------------+");
			System.out.printf("| Ticket ID: %-27d |\n", ticket.getTicketID());
			System.out.printf("| Bus Name: %-28s |\n", ticket.getBusName());
			System.out.printf("| Start Point: %-26s|\n", ticket.getStartPoint());
			System.out.printf("| End Point: %-28s|\n", ticket.getEndPoint());
			System.out.printf("| Start Time: %-27s|\n", ticket.getStartTime());
			System.out.printf("| End Time: %-29s|\n", ticket.getEndTime());
			System.out.printf("| Seats Booked: %-25s|\n", ticket.getSeatsBooked());
			System.out.printf("| Status: %-31s|\n", ticket.getBookingStatus());
			System.out.println("+----------------------------------------+\n");
		} catch (BusException e) {
			System.out.println(e.getMessage());
		}
    }
}
