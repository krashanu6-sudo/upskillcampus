1. Project Title
NovaBank – Banking Information System

2. Introduction
NovaBank is a console-based Banking Information System developed using Core Java as part of a Java Development Internship. The project simulates the basic functionalities of a real-world banking application, allowing users to register, log in securely, manage their accounts, perform financial transactions, and maintain transaction records. The application follows Object-Oriented Programming principles and uses Java Serialization to persist customer, account, and transaction data across sessions.

3. Problem Statement
The objective of this project is to develop a prototype Banking Information System that demonstrates the core functionalities of a banking application. The system enables customer registration, secure authentication, account management, deposits, withdrawals, fund transfers, transaction history, and persistent data storage while maintaining a modular architecture using Core Java

4. Objectives
Develop a banking application using Core Java.
Apply Object-Oriented Programming concepts.
Implement secure customer registration and login.
Perform deposit, withdrawal, and fund transfer operations.
Maintain customer and transaction records.
Implement persistent storage using Java Serialization.
Improve software design using modular package architecture.
Gain practical experience with Git and GitHub.

5. Scope of the Project
NovaBank is designed as a prototype banking application intended for educational purposes. It provides essential banking functionalities in a console-based environment and demonstrates how customer management, account operations, and transaction processing can be implemented using Core Java. The project focuses on understanding software design principles rather than commercial banking features.

📄 Section 6 – Technologies Used
Technologies Used
Technology	Purpose
Core Java	Application Development
Object-Oriented Programming (OOP)	Modular Software Design
Java Collections Framework	In-memory Data Storage
Java Serialization	Persistent Data Storage
File Handling	Reading and Writing Data
Exception Handling	Handling Runtime Errors
LocalDateTime API	Recording Transaction Date & Time
Git	Version Control
GitHub	Source Code Management
Visual Studio Code	Development Environment
💻 Section 7 – System Requirements
Hardware Requirements
Processor: Intel Core i3 or above
RAM: Minimum 4 GB (8 GB Recommended)
Storage: 500 MB Free Disk Space
Keyboard & Mouse
Software Requirements
Windows 10/11
Java JDK 23
Visual Studio Code
Git
GitHub

🏗 Section 8 – Project Architecture

Project Architecture

NovaBank follows a layered and modular architecture.

The project is divided into separate packages, each having a specific responsibility.

                User

                 │

                 ▼

              Main.java

                 │

                 ▼

          BankService.java

        ┌────────┼────────┐

        ▼        ▼        ▼

     model    storage    util

                 │

                 ▼

      Serialization (.dat files)

Architecture Description

Main.java manages user interaction through a menu-driven interface.
BankService.java contains the complete business logic of the application.
Model package represents entities such as Customer, Account, Transaction, and Admin.
Storage package is responsible for saving and loading data using Java Serialization.
Utility package generates unique Customer IDs and Account Numbers.
Data is stored locally in serialized .dat files.

📦 Section 9 – Project Modules

1. Customer Module
Responsible for:

Customer Registration
Customer Login
View Profile
Update Profile
Change Password

2. Banking Module
Responsible for:

Deposit Money
Withdraw Money
Fund Transfer
Check Balance
Search Account

3. Transaction Module
Responsible for:

Recording Transactions
Mini Statement
Transaction History

4. Data Storage Module
Responsible for:

Saving Customer Records
Saving Account Records
Saving Transaction Records

using Java Serialization.

📂 Section 10 – Folder Structure
NovaBank
│
├── docs
│   ├── Screenshots
│   ├── UML
│   ├── Weekly Reports
│   └── Report_Content_Draft
│
├── src
│   ├── com
│   │   └── novabank
│   │       ├── model
│   │       ├── service
│   │       ├── storage
│   │       ├── util
│   │       ├── exception
│   │       └── Main.java
│   │
│   ├── accounts.dat
│   ├── customers.dat
│   └── transactions.dat
│
├── README.md
└── .gitignore

📄 Section 11 – Class Description
Class Description

1. Main.java

Purpose:
Acts as the entry point of the application. It displays the menu-driven interface, accepts user input, and calls the appropriate methods from the BankService class.

2. Customer.java

Purpose:
Represents a bank customer and stores customer-related information such as:

Customer ID
Name
Phone Number
Email
Address
Password

3. Account.java

Purpose:
Represents a bank account and maintains:

Account Number
Customer ID
Account Type
Current Balance

4. Transaction.java

Purpose:
Stores details of every banking transaction, including:

Account Number
Transaction Type
Transaction Amount
Remaining Balance
Transaction Date & Time

5. Admin.java

Purpose:
Represents administrator credentials. This class is included for future administrative features.

6. BankService.java

Purpose:
This is the core business logic class of the project. It performs all banking operations such as customer registration, login, deposits, withdrawals, fund transfers, profile management, and transaction handling.

7. DataStorage.java

Purpose:
Handles saving and loading of customer, account, and transaction records using Java Serialization.

8. IdGenerator.java

Purpose:
Generates unique Customer IDs and Account Numbers automatically during registration.

📄 Section 12 – Features Implemented
Features Implemented

The following features were successfully implemented:

Customer Registration
Secure Customer Login
Customer Profile Management
Password Change
Deposit Money
Withdraw Money
Fund Transfer
Check Account Balance
Search Account
Mini Statement
Customer Records Management
Account Records Management
Transaction Records Management
Data Persistence using Java Serialization
Exception Handling
Modular Package Structure
Git Version Control

📄 Section 13 – Challenges Faced
Challenges Faced

During the development of NovaBank, several technical challenges were encountered:

Java Compilation Errors

Initially, package reference and compilation issues occurred due to incorrect project structure and missing methods.

Solution:
The package structure was reorganized, source files were verified, and missing methods were implemented.

Java Version Compatibility

A Java runtime compatibility issue occurred because the project was compiled with a newer JDK version than the runtime environment.

Solution:
The project was recompiled using the correct JDK version and environment variables were configured properly.

Git Merge Conflicts

While updating the GitHub repository, merge conflicts occurred in the README.md file.

Solution:
The conflicts were resolved manually using Git rebase and the updated documentation was committed successfully.

Data Persistence

Managing customer, account, and transaction data across application restarts required persistent storage.

Solution:
Java Serialization was implemented to store application data in .dat files.

📄 Section 14 – Learning Outcomes
Learning Outcomes

This project helped in gaining practical knowledge of:

Core Java Programming
Object-Oriented Programming
Java Collections Framework
Java Serialization
File Handling
Exception Handling
Git & GitHub
Software Debugging
Project Documentation
Modular Application Development

📄 Section 15 – Future Enhancements
Future Enhancements

The following improvements can be implemented in future versions:

Spring Boot Integration
MySQL Database
RESTful APIs
JWT Authentication
Role-Based Access Control (Admin & Customer)
JavaFX/Desktop GUI
Email Notifications
Loan Management Module
Interest Calculation
Transaction Analytics Dashboard

📄 Section 16 – Conclusion
Conclusion

NovaBank was developed successfully as a console-based Banking Information System using Core Java. The project demonstrates the practical implementation of Object-Oriented Programming principles, Java Collections, File Handling, Serialization, and Exception Handling in a real-world scenario.

The project fulfilled its primary objectives by providing customer registration, secure authentication, account management, transaction processing, and persistent data storage through a modular architecture. In addition to strengthening Core Java concepts, the project also provided valuable experience in version control using Git, documentation, debugging, and software development practices.

Overall, NovaBank served as an excellent learning experience and established a strong foundation for developing more advanced Java applications using technologies such as Spring Boot, MySQL, and REST APIs.

🎉 REPORT CONTENT DRAFT STATUS
Section	Status
Project Title	✅
Introduction	✅
Problem Statement	✅
Objectives	✅
Scope	✅
Technologies	✅
System Requirements	✅
Architecture	✅
Modules	✅
Folder Structure	✅
Class Description	✅
Features	✅
Challenges	✅
Learning Outcomes	✅
Future Enhancements	✅
Conclusion	✅