/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Database;

/**
 *
 * @author DELL
 */
import java.util.List;
import java.util.Map;

public class QueryBuilder {
    private String table;
    private String type;
    private String selectFields;
    private String whereCondition;
    private String updateData;
    private String insertColumns;
    private String insertData;
    private String joinTable;
    private String joinCondition;

    public QueryBuilder table(String table) {
        this.table = table;
        return this;
    }
    
    public QueryBuilder select() {
        this.type = "SELECT";
        this.selectFields = "*"; return this;
    }
    
    public QueryBuilder select(String fields) {
        this.type = "SELECT";
        this.selectFields = fields; return this;
    }
    
    public QueryBuilder join(String table, String condition) {
        this.joinTable = table;
        this.joinCondition = condition;
        return this;
    }
    
    public QueryBuilder where(String condition) {
        this.whereCondition = condition; return this;
    }

    public QueryBuilder insert(String columns, String data) {
        this.type = "INSERT"; 
        this.insertColumns = columns; 
        this.insertData = data; 
        return this;
    }
    
    public QueryBuilder update(String data) {
        this.type = "UPDATE";
        this.updateData = data; return this;
    }
    
    public QueryBuilder delete() {
        this.type = "DELETE"; return this;
    }
    
    // SELECT
    public List<Map<String, Object>> get() {
        String sql = buildSql();
        return DatabaseConnection.getInstance().executeSelect(sql);
    }

    // INSERT/UPDATE/DELETE
    public int execute() {
        String sql = buildSql();
        return DatabaseConnection.getInstance().executeUpdate(sql);
    }
    
    private String buildSql() {
        StringBuilder sql = new StringBuilder();
        
        switch (type) {
            case "SELECT" -> {
                sql.append("SELECT ").append(selectFields).append(" FROM ").append(table);
                if (joinTable != null && !joinTable.isEmpty()) {
                    sql.append(" INNER JOIN ").append(joinTable);
                    sql.append(" ON ").append(joinCondition);
                }
            }
            case "INSERT" -> sql.append("INSERT INTO ").append(table).append(" (").append(insertColumns).append(")").append(" VALUES (").append(insertData).append(")");
            case "UPDATE" -> sql.append("UPDATE ").append(table).append(" SET ").append(updateData);
            case "DELETE" -> sql.append("DELETE FROM ").append(table);
        }
        if (whereCondition != null && !whereCondition.isEmpty()) {
            sql.append(" WHERE ").append(whereCondition);
        }
        return sql.toString();
    }
}
