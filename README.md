# Banking System
## Selected lab Project

### Main featurs 
1. **Database Connectivity**
   - Implemented a robust database connection layer using JDBC with SQL Server.
   - The connection is managed centrally to ensure stability, reusability, and efficient resource handling.
   - Supports executing dynamic queries for all CRUD operations in a clean and organized way.

2. **Graphical User Interface (GUI)**
    - Built a user-friendly GUI using **Java Swing**.
    - Provides clear screens for managing customers, accounts, loans, and transactions.
    - Displays data in tables and allows direct interaction with the system operations.

3. **CRUD Operations**
    - Fully supports **Create, Read, Update, and Delete** operations.
    - Enables adding, editing, deleting, and viewing customers, accounts, loans, and transactions.
    - All operations are handled through a structured command-based architecture.

4. **Use of Design Patterns**
    - The project applies multiple design patterns together in a practical and meaningful way.
    - Each pattern has a clear responsibility, improving code readability and separation of concerns.
    - This results in a cleaner architecture and easier future enhancements.

5. **Maintainability and Scalability**
    - The system is designed to be **maintainable** by separating responsibilities across layers (GUI, Commands, Business Logic, Database).
    - New features, patterns, or database types can be added with minimal changes.
    - The architecture supports **scalability**, making it suitable for future expansion or integration with larger systems.

### Design Patterns Used in the Banking System

1. **Singleton Pattern**  
   - Used for the **Database Connection** to ensure that only one connection instance exists throughout the application.  
   - Also applied to the **TransactionManager**, guaranteeing a single manager instance handling all transactions.

2. **Builder Pattern**  
   - Implemented in the **QueryBuilder** class to construct SQL queries dynamically.  
   - This allows flexible creation of `SELECT`, `INSERT`, `UPDATE`, `DELETE` , and `JOIN` queries for the database.

3. **Prototype Pattern**  
   - Applied to the **Account** class because most accounts share some fixed data.  
   - Using cloning helps quickly create new accounts based on existing templates.

4. **Factory Pattern**  
   - Used with **Account** to create different types of accounts such as **Saving**, **Checking**, and **Loan**.  
   - Also used with **Loan**, which has different types like **Personal**, **Home**, and **Car**.  
   - This pattern centralizes the creation logic and simplifies object instantiation.

5. **Command Pattern**  
   - Applied in the **TransactionManager** to encapsulate all operations (like create account, deposit, withdraw, delete) as commands.  
   - This allows flexible execution of actions, decouples requests from the object that performs them, and makes undo/redo possible.
6. **State Pattern**
   - Used to manage account states, allowing smooth transitions between Active and Inactive accounts while keeping the behavior clean and organized.
7. **Adapter Pattern**
   - Added to the **Database Layer** to provide flexibility in database connectivity.
   - Allows the system to support different types of database connections in the future without changing business logic.
   - Decouples database access logic from the rest of the application, improving scalability and maintainability.
8. **Proxy Pattern**
   - Implemented as a protective layer between the **Command layer** and the **TransactionManager**.
   - Responsible for validating all input data before executing any operation.
   - Prevents invalid data from reaching the core logic and improves system security and data integrity.



