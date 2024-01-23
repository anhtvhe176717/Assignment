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
import model.Personnel;

/**
 *
 * @author admin
 */
public class DepartDAO extends DBContext {

    public List<Department> getAllDepart() {
        List<Department> list = new ArrayList<>();

        String sql = "SELECT [id]\n"
                + "      ,[departname]\n"
                + "      ,[codedepart]\n"
                + "  FROM [dbo].[Department]";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                UUID id = UUID.fromString(rs.getString("id"));
                Department d = new Department(id, rs.getString("departname"), rs.getString("codedepart"));
                list.add(d);
            }
        } catch (SQLException e) {
        }
        return list;
    }

    public void insert(Department d) {
        String sql = "INSERT INTO [dbo].[Department]\n"
                + "           ([id]\n"
                + "           ,[departname]\n"
                + "           ,[codedepart])\n"
                + "     VALUES\n"
                + "           (?, ?, ?)";

        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setObject(1, d.getId());
            st.setString(2, d.getDepartname());
            st.setString(3, d.getCodedepart());
            st.executeUpdate();
        } catch (SQLException e) {
        }
    }

    public void update(Department d) {
        String sql = "UPDATE [dbo].[Department]\n"
                + "   SET [departname] = ?\n"
                + "      ,[codedepart] = ?\n"
                + " WHERE id = ?";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setObject(1, d.getId());
            st.setString(2, d.getDepartname());
            st.setString(3, d.getCodedepart());
            st.executeUpdate();
        } catch (SQLException e) {
        }
    }

    public Department getDepartByID(UUID checkID) {
        String sql = "SELECT [id]\n"
                + "      ,[departname]\n"
                + "      ,[codedepart]\n"
                + "  FROM [dbo].[Department] where id = ?";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setObject(1, checkID);
            ResultSet rs = st.executeQuery();
            if (rs.next()) {
                UUID id = UUID.fromString(rs.getString("id"));
                Department d = new Department(id, rs.getString("departname"), rs.getString("codedepart"));
                return d;
            }
        } catch (SQLException e) {
        }

        return null;
    }

    public Department getDepartCodeDepart(String code) {
        String sql = "SELECT [id]\n"
                + "      ,[departname]\n"
                + "      ,[codedepart]\n"
                + "  FROM [dbo].[Department] where codedepart = ?";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setObject(1, code);
            ResultSet rs = st.executeQuery();
            if (rs.next()) {
                UUID id = UUID.fromString(rs.getString("id"));
                Department d = new Department(id, rs.getString("departname"), rs.getString("codedepart"));
                return d;
            }
        } catch (SQLException e) {
        }

        return null;
    }

    public static void main(String[] args) {
        DepartDAO dd = new DepartDAO();
        List<Department> list = dd.getAllDepart();
        System.out.println(list.get(0).getDepartname());
        UUID id = UUID.randomUUID();

        Department d = new Department(id, "Nhân Sự", "HR");
        dd.insert(d);

    }
}
