# NovaBank - Banking Information System

## Project Overview
NovaBank is a console-based Banking Information System developed using Core Java. It demonstrates the basic flow of a banking application and includes customer registration, login, account management, deposit, withdrawal, fund transfer, account statements, password protection, error handling, and data persistence.

## Features
- Customer registration
- Customer login
- Account management
- Deposit money
- Withdraw money
- Fund transfer
- View profile
- Update profile
- Change password
- Mini statement with transaction history
- Data persistence using Java Serialization
- Console-based menu interface

## Technologies Used
- Core Java
- Object-Oriented Programming
- Java Collections Framework
- File Handling
- Java Serialization
- Exception Handling

## Project Structure
```
NovaBank
└── src
    └── com
        └── novabank
            ├── exception
            ├── model
            ├── service
            ├── storage
            └── util
```

## How to Run
1. Open the project in VS Code or any Java IDE.
2. Compile the project from the `src` folder.
3. Run the main class:
   ```bash
   java com.novabank.Main
   ```

## Notes
- The project uses file-based persistence.
- Serialized data files are created during runtime.
- The code is organized into multiple packages for readability and maintainability.

## Future Enhancements
- Admin dashboard
- Database integration using MySQL
- REST API version using Spring Boot
- GUI version using JavaFX

## Author
Krashanu
