package Database;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.swing.JOptionPane;

public class DatabaseConnection {
    private static DatabaseConnection instance;
    private Connection connection;
    Statement statement;
    ResultSet rs ;

    private DatabaseConnection() {
        this.rs=null;
        this.connection=null;
        this.statement=null;
    }

    private void openConnection() throws SQLException {
       try{
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            connection = (Connection) DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databaseName=Bank;user=team;password=team1234;encrypt=true;trustServerCertificate=true;");
            //JOptionPane.showMessageDialog(null, "connected"); 
        }
        catch(ClassNotFoundException  e){
            JOptionPane.showMessageDialog(null, "cannot load jdbc"); 

        }
        catch(SQLException  e){
            JOptionPane.showMessageDialog(null, "no connected "+ e.getMessage()); 

        }
    }

    private void closeConnection() {
        try {
            if (this.connection != null) {
            this.connection.close();
            this.connection = null;
            }
            if (rs != null) rs.close();
            if (statement != null) statement.close();
            System.out.println("[Connection closed]");
        } catch (SQLException e) {
            System.err.println("Error closing connection: " + e.getMessage());
        }
       
    }

    public static DatabaseConnection getInstance() {
        if (instance == null) {
            synchronized (DatabaseConnection.class) {
                if (instance == null) {
                    instance = new DatabaseConnection();
                }
            }
        }
        return instance;
    }

    public int executeUpdate(String sql) {
        int rowsAffected = 0;
        try {
            openConnection();
            statement = this.connection.createStatement();
            System.out.println("Executing UPDATE/DELETE: " + sql);
            rowsAffected = statement.executeUpdate(sql);
        } catch (SQLException e) {
            System.err.println("SQL Execution Error: " + e.getMessage());
        } finally {
            closeConnection();
        }
        return rowsAffected;
    }

    public List<Map<String, Object>> executeSelect(String sql) {
        List<Map<String, Object>> results = new ArrayList<>();
        
        try {
            openConnection();
            statement = this.connection.createStatement();
            System.out.println("Executing SELECT: " + sql);
            rs = statement.executeQuery(sql);
            ResultSetMetaData metaData = rs.getMetaData();
            int columnCount = metaData.getColumnCount();
            while (rs.next()) {
                Map<String, Object> row = new HashMap<>();
                for (int i = 1; i <= columnCount; i++) {
                    String columnName = metaData.getColumnLabel(i);
                    Object columnValue = rs.getObject(i);
                    row.put(columnName, columnValue);
                }
                results.add(row);
            }
        } catch (SQLException e) {
            System.err.println("SQL Execution Error: " + e.getMessage());
        } finally {
            closeConnection();
        }
        return results;
    }
  
}