# Banking System
## Selected lab Project
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


