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

import model.ProjectAssignment;

/**
 *
 * @author admin
 */
public class PADAO extends DBContext {

    public List<ProjectAssignment> getAllAS() {
        List<ProjectAssignment> list = new ArrayList<>();

        String sql = "SELECT [id]\n"
                + "      ,[projectid]\n"
                + "      ,[personid]\n"
                + "  FROM [dbo].[ProjectAssignment]";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                UUID id = UUID.fromString(rs.getString("id"));
                UUID personid = UUID.fromString(rs.getString("personid"));
                UUID projectid = UUID.fromString(rs.getString("projectid"));

                ProjectAssignment pa = new ProjectAssignment(id, projectid, personid);
                list.add(pa);
            }
        } catch (SQLException e) {
        }
        return list;
    }
    
    public static void main(String[] args) {
        PADAO dd = new PADAO();
        List<ProjectAssignment> list = dd.getAllAS();
        System.out.println(list.get(0).getPersonid());
  


    }
}
