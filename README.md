# half-flock-4018
Bus Reservation System helps you schedule bus routes and tours with ease. The system allows you to plan, schedule and manage unlimited routes with start, end and stop destinations, create a route timetable, print bus schedules, seat and passenger lists.

# MySQL Commands to Create Database Tables:

create database sunshine;

use sunshine;

create table administrator(</br>
AdminID int primary key auto_increment,
First_Name varchar(10) NOT NULL,
Father_Name varchar(10),
Last_Name varchar(10) NOT NULL,
Mother_Name varchar(10),
Date_Of_Birth date NOT NULL,
Gender varchar(6) NOT NULL,
Address varchar(20),
Contact_No varchar(14) NOT NULL,
Email varchar(30) NOT NULL,
Password varchar(30) NOT NULL
);

create table customer(
CustomerID int primary key auto_increment,
First_Name varchar(10) NOT NULL,
Father_Name varchar(10),
Last_Name varchar(10) NOT NULL,
Mother_Name varchar(10),
Date_Of_Birth date NOT NULL,
Gender varchar(6) NOT NULL,
Address varchar(20) UNIQUE,
Contact_No varchar(14) NOT NULL,
Email varchar(30) NOT NULL,
Password varchar(30) NOT NULL
);

create table bus(
BusID int primary key auto_increment,
Bus_Name varchar(10),
Starting_Point varchar(10) NOT NULL,
Ending_Point varchar(10) NOT NULL,
Start_Time varchar(10) NOT NULL,
End_Time varchar(10) NOT NULL,
Capacity int NOT NULL,
Seats_Available int NOT NULL
);

create table ticket(
TicketID int primary key auto_increment,
CustomerID int NOT NULL,
BusID int NOT NULL,
Seats_Booked int NOT NULL,
UNIQUE(CustomerID, BusID),
Booking_Status varchar(11),
FOREIGN KEY (CustomerID) REFERENCES customer(CustomerID) ON DELETE CASCADE ON UPDATE CASCADE,
FOREIGN KEY (BusID) REFERENCES bus(BusID) ON DELETE CASCADE ON UPDATE CASCADE
);

# MySQL Database Tables:

![Sunshine Mysql Table](https://user-images.githubusercontent.com/107460330/208612792-e45fdeb3-edda-4f48-a821-c58cb39db3e0.png)
