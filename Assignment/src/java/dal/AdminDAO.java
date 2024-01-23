/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dal;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import model.Admin;

/**
 *
 * @author admin
 */
public class AdminDAO extends DBContext{
    public Admin check(String u, String p) {
        String sql = "SELECT [username]\n"
                + "      ,[password]\n"
                + "      ,[displayname]\n"
                + "  FROM [dbo].[Admin]\n"
                + "  where username = ? and password = ?";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setString(1, u);
            st.setString(2, p);
            ResultSet rs = st.executeQuery();
            if (rs.next()) {
                Admin a = new Admin(rs.getString("Username"), rs.getString("Password"), rs.getString("displayname"));
                return a;
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return null;

    }
}
