/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Database;

import java.util.List;
import java.util.Map;

public class SqlServerAdapter implements DatabaseAdapter {

    private final DatabaseConnection db = DatabaseConnection.getInstance();

    @Override
    public int executeUpdate(String sql) {
        return db.executeUpdate(sql);
    }

    @Override
    public List<Map<String, Object>> executeSelect(String sql) {
        return db.executeSelect(sql);
    }
}

