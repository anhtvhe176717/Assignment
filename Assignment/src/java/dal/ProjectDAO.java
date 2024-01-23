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
import model.Project;

/**
 *
 * @author admin
 */
public class ProjectDAO extends DBContext {

    public List<Project> getAllProject() {
        List<Project> list = new ArrayList<>();

        String sql = "SELECT [id]\n"
                + "      ,[projectname]\n"
                + "      ,[endDate]\n"
                + "      ,[startDate]\n"
                + "      ,[describe]\n"
                + "      ,[status]\n"
                + "  FROM [dbo].[Project]";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                UUID id = UUID.fromString(rs.getString("id"));
                Project d = new Project(id, rs.getString("projectname"), rs.getString("startdate"), rs.getString("enddate"), rs.getString("describe"), rs.getBoolean("status"));
                list.add(d);
            }
        } catch (SQLException e) {
        }
        return list;
    }

    public Project getProjectByID(UUID checkID) {
        String sql = "SELECT [id]\n"
                + "      ,[projectname]\n"
                + "      ,[endDate]\n"
                + "      ,[startDate]\n"
                + "      ,[describe]\n"
                + "      ,[status]\n"
                + "  FROM [dbo].[Project]"
                + "where id = ?";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setObject(1, checkID);
            ResultSet rs = st.executeQuery();
            if (rs.next()) {
                UUID id = UUID.fromString(rs.getString("id"));
                Project p = new Project(id, rs.getString("projectname"), rs.getString("startdate"), rs.getString("enddate"), rs.getString("describe"), rs.getBoolean("status"));
                return p;
            }
        } catch (SQLException e) {
        }

        return null;
    }

    public static void main(String[] args) {
        ProjectDAO pd = new ProjectDAO();
        List<Project> list = pd.getAllProject();
        System.out.println(list.get(0).getProjectname());
        UUID id = UUID.randomUUID();

    }
}
