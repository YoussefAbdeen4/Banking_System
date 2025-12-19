/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Database;

import java.util.List;
import java.util.Map;

public interface DatabaseAdapter {

    int executeUpdate(String sql);

    List<Map<String, Object>> executeSelect(String sql);
}

