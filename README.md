# half-flock-4018
A bus reservation system is a piece of software that bus companies use to handle their reservations, timetables, and operations. The technology is intended to minimise administrative chores connected with managing bus operations and to simplify the booking process for clients.<br />
It helps you schedule bus routes and tours with ease. The system allows you to plan, schedule and manage unlimited routes with start, end and stop destinations, create a route timetable, print bus schedules, seat and passenger lists.

# MySQL Commands to Create Database Tables:

create database sunshine;

use sunshine;

create table administrator(</br>
AdminID int primary key auto_increment,</br>
First_Name varchar(10) NOT NULL,</br>
Father_Name varchar(10),</br>
Last_Name varchar(10) NOT NULL,</br>
Mother_Name varchar(10),</br>
Date_Of_Birth date NOT NULL,</br>
Gender varchar(6) NOT NULL,</br>
Address varchar(20),</br>
Contact_No varchar(14) NOT NULL,</br>
Email varchar(30) NOT NULL,</br>
Password varchar(30) NOT NULL</br>
);

create table customer(</br>
CustomerID int primary key auto_increment,</br>
First_Name varchar(10) NOT NULL,</br>
Father_Name varchar(10),</br>
Last_Name varchar(10) NOT NULL,</br>
Mother_Name varchar(10),</br>
Date_Of_Birth date NOT NULL,</br>
Gender varchar(6) NOT NULL,</br>
Address varchar(20) UNIQUE,</br>
Contact_No varchar(14) NOT NULL,</br>
Email varchar(30) NOT NULL,</br>
Password varchar(30) NOT NULL</br>
);

create table bus(</br>
BusID int primary key auto_increment,</br>
Bus_Name varchar(10),</br>
Starting_Point varchar(10) NOT NULL,</br>
Ending_Point varchar(10) NOT NULL,</br>
Start_Time varchar(10) NOT NULL,</br>
End_Time varchar(10) NOT NULL,</br>
Capacity int NOT NULL,</br>
Seats_Available int NOT NULL</br>
);

create table ticket(</br>
TicketID int primary key auto_increment,</br>
CustomerID int NOT NULL,</br>
BusID int NOT NULL,</br>
Seats_Booked int NOT NULL,</br>
UNIQUE(CustomerID, BusID),</br>
Booking_Status varchar(11),</br>
FOREIGN KEY (CustomerID) REFERENCES customer(CustomerID) ON DELETE CASCADE ON UPDATE CASCADE,</br>
FOREIGN KEY (BusID) REFERENCES bus(BusID) ON DELETE CASCADE ON UPDATE CASCADE</br>
);

# MySQL Database Tables:

![Sunshine Mysql Table](https://user-images.githubusercontent.com/107460330/208612792-e45fdeb3-edda-4f48-a821-c58cb39db3e0.png)
