/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dal;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import model.Department;
import model.Role;

/**
 *
 * @author admin
 */
public class RoleDAO extends DBContext {

    public List<Role> getAllRole() {
        List<Role> list = new ArrayList<>();

        String sql = "SELECT [id]\n"
                + "      ,[rolename]\n"
                + "  FROM [dbo].[Role]    ";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                UUID id = UUID.fromString(rs.getString("id"));
                Role d = new Role(id, rs.getString("rolename"));
                list.add(d);
            }
        } catch (SQLException e) {
        }
        return list;
    }
    
    public static void main(String[] args) {
        RoleDAO dd = new RoleDAO();
        List<Role> list = dd.getAllRole();
        System.out.println(list.get(0).getRolename());
//        UUID id = UUID.randomUUID();
//
//        Department d = new Department(id, "Nhân Sự", "HR");
//        dd.insert(d);

    }
}
