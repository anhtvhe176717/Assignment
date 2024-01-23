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
import model.Personnel;
import java.util.UUID;

/**
 *
 * @author admin
 */
public class PersonDAO extends DBContext {

    public List<Personnel> getAll() {
        List<Personnel> list = new ArrayList<>();
        String sql = "SELECT [id]\n"
                + "      ,[psname]\n"
                + "      ,[phonenum]\n"
                + "      ,[dob]\n"
                + "      ,[status]\n"
                + "      ,[sex]\n"
                + "      ,[codepersonnel]\n"
                + "      ,[roleid]\n"
                + "      ,[departid]\n"
                + "  FROM [dbo].[Personnel]";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                UUID id = UUID.fromString(rs.getString("id"));
                UUID roleid = UUID.fromString(rs.getString("roleid"));
                UUID departid = UUID.fromString(rs.getString("departid"));

                Personnel p = new Personnel(rs.getString("psname"), rs.getString("phonenum"), rs.getString("dob"), rs.getString("codepersonnel"), rs.getBoolean("status"), rs.getBoolean("sex"), id, roleid, departid);
                list.add(p);
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return list;
    }

    public List<Personnel> getAllFromDepartid(String code) {
        List<Personnel> list = new ArrayList<>();
        String sql = "SELECT [id]\n"
                + "      ,[psname]\n"
                + "      ,[phonenum]\n"
                + "      ,[dob]\n"
                + "      ,[status]\n"
                + "      ,[sex]\n"
                + "      ,[codepersonnel]\n"
                + "      ,[roleid]\n"
                + "      ,[departid]\n"
                + "  FROM [dbo].[Personnel]"
                + "where codepersonnel like '%" + code + "%' order by codepersonnel asc";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                UUID id = UUID.fromString(rs.getString("id"));
                UUID roleid = UUID.fromString(rs.getString("roleid"));
                UUID departid = UUID.fromString(rs.getString("departid"));
                Personnel p = new Personnel(rs.getString("psname"), rs.getString("phonenum"), rs.getString("dob"), rs.getString("codepersonnel"), rs.getBoolean("status"), rs.getBoolean("sex"), id, roleid, departid);
                list.add(p);
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return list;
    }

    public void insert(Personnel p) {
        String sql = "INSERT INTO [dbo].[Personnel]\n"
                + "           ([id]\n"
                + "           ,[psname]\n"
                + "           ,[phonenum]\n"
                + "           ,[dob]\n"
                + "           ,[status]\n"
                + "           ,[sex]\n"
                + "           ,[codepersonnel]\n"
                + "           ,[roleid]\n"
                + "           ,[departid])\n"
                + "     VALUES\n"
                + "           (?, ?, ?, ?, ?, ? ,? ,? , ?)";
        try {
            PreparedStatement st = connection.prepareStatement(sql);

            st.setObject(1, p.getId());
            st.setString(2, p.getPsname());
            st.setString(3, p.getPhonenum());
            st.setString(4, p.getDob());
            st.setBoolean(5, p.isStatus());
            st.setBoolean(6, p.isSex());
            st.setString(7, p.getCodepersonnel());
            st.setObject(8, p.getRoleid());
            st.setObject(9, p.getDepartid());

            st.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e);
        }
    }

    public void update(Personnel p) {
        String sql = "UPDATE [dbo].[Personnel]\n"
                + "   SET [psname] = ?\n"
                + "      ,[phonenum] = ?\n"
                + "      ,[dob] = ?\n"
                + "      ,[status] = ?\n"
                + "      ,[sex] = ?\n"
                + "      ,[codepersonnel] = ?\n"
                + "      ,[roleid] = ?\n"
                + "      ,[departid] = ?\n"
                + " WHERE id = ?";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setString(1, p.getPsname());
            st.setString(2, p.getPhonenum());
            st.setString(3, p.getDob());
            st.setBoolean(4, p.isStatus());
            st.setBoolean(5, p.isSex());
            st.setString(6, p.getCodepersonnel());
            st.setObject(7, p.getRoleid());
            st.setObject(8, p.getDepartid());
            st.setObject(9, p.getId());
            st.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e);
        }
    }

    public void delete(UUID id) {
        String sql = "DELETE FROM [dbo].[Personnel]\n"
                + "      WHERE id = '" + id + "'";

        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e);
        }
    }

    public Personnel getPersonByID(String checkId) {
        String sql = "SELECT [id]\n"
                + "      ,[psname]\n"
                + "      ,[phonenum]\n"
                + "      ,[dob]\n"
                + "      ,[status]\n"
                + "      ,[sex]\n"
                + "      ,[codepersonnel]\n"
                + "      ,[roleid]\n"
                + "      ,[departid]\n"
                + "  FROM [dbo].[Personnel] where codepersonnel = ?";

        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setString(1, checkId);
            ResultSet rs = st.executeQuery();
            if (rs.next()) {
                UUID id = UUID.fromString(rs.getString("id"));
                UUID roleid = UUID.fromString(rs.getString("roleid"));
                UUID departid = UUID.fromString(rs.getString("departid"));

                Personnel p = new Personnel(rs.getString("psname"), rs.getString("phonenum"), rs.getString("dob"), rs.getString("codepersonnel"), rs.getBoolean("status"), rs.getBoolean("sex"), id, roleid, departid);
                return p;
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return null;
    }

    public List<Personnel> searchPerson(String code) {
        List<Personnel> list = new ArrayList<>();
        String sql = "SELECT [id]\n"
                + "      ,[psname]\n"
                + "      ,[phonenum]\n"
                + "      ,[dob]\n"
                + "      ,[status]\n"
                + "      ,[sex]\n"
                + "      ,[codepersonnel]\n"
                + "      ,[roleid]\n"
                + "      ,[departid]\n"
                + "  FROM [dbo].[Personnel]"
                + "where 1 = 1";

        if (!code.isEmpty()) {
            sql += "and codepersonnel = '" + code + "' or psname like '%" + code + "%'";
        }
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                UUID id = UUID.fromString(rs.getString("id"));
                UUID roleid = UUID.fromString(rs.getString("roleid"));
                UUID departid = UUID.fromString(rs.getString("departid"));
                Personnel p = new Personnel(rs.getString("psname"), rs.getString("phonenum"), rs.getString("dob"), rs.getString("codepersonnel"), rs.getBoolean("status"), rs.getBoolean("sex"), id, roleid, departid);
                list.add(p);
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return list;
    }

    public List<Personnel> searchPersonByDepart(String code, UUID depart) {
        List<Personnel> list = new ArrayList<>();
        String sql = "SELECT [id]\n"
                + "      ,[psname]\n"
                + "      ,[phonenum]\n"
                + "      ,[dob]\n"
                + "      ,[status]\n"
                + "      ,[sex]\n"
                + "      ,[codepersonnel]\n"
                + "      ,[roleid]\n"
                + "      ,[departid]\n"
                + "  FROM [dbo].[Personnel]"
                + "where (codepersonnel = '" + code + "' or psname like '%" + code + "%') and departid = '" + depart + "' order by codepersonnel asc";

        try {
            PreparedStatement st = connection.prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                UUID id = UUID.fromString(rs.getString("id"));
                UUID roleid = UUID.fromString(rs.getString("roleid"));
                UUID departid = UUID.fromString(rs.getString("departid"));
                Personnel p = new Personnel(rs.getString("psname"), rs.getString("phonenum"), rs.getString("dob"), rs.getString("codepersonnel"), rs.getBoolean("status"), rs.getBoolean("sex"), id, roleid, departid);
                list.add(p);
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return list;
    }

    public Personnel getPersonByDepartName(String departname) {
        String sql = "SELECT top 1 [id]\n"
                + "      ,[psname]\n"
                + "      ,[phonenum]\n"
                + "      ,[dob]\n"
                + "      ,[status]\n"
                + "      ,[sex]\n"
                + "      ,[codepersonnel]\n"
                + "      ,[roleid]\n"
                + "      ,[departid]\n"
                + "  FROM [dbo].[Personnel] where codepersonnel like '%" + departname + "%' order by codepersonnel desc";

        try {
            PreparedStatement st = connection.prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            if (rs.next()) {
                UUID id = UUID.fromString(rs.getString("id"));
                UUID roleid = UUID.fromString(rs.getString("roleid"));
                UUID departid = UUID.fromString(rs.getString("departid"));

                Personnel p = new Personnel(rs.getString("psname"), rs.getString("phonenum"), rs.getString("dob"), rs.getString("codepersonnel"), rs.getBoolean("status"), rs.getBoolean("sex"), id, roleid, departid);
                return p;
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return null;
    }

    public static void main(String[] args) {
        PersonDAO pd = new PersonDAO();
//        List<Personnel> list = pd.getAllPersonnel();
//        System.out.println(list.get(0).getPsname());
//        UUID id = UUID.randomUUID();
//    String n = "it";
//    Personnel p = pd.getPersonByDepartName(n);
//        System.out.println(p.getCodepersonnel());
//        UUID roleid = UUID.fromString("9F07AD32-E157-4FDD-9639-E58C3E0231ED"); // nhân viên
//        UUID roleid1 = UUID.fromString("081043CD-BB1E-42E6-AFCD-12BF88D2E4FD"); // role bao ve 
//        UUID roleid = UUID.fromString("FE6AD771-7F81-425B-9EE5-B9DB824D6FDE"); // role truong phong
//        UUID roleid = UUID.fromString("095D7FB5-8AD5-49C9-B39B-2F75759AB8FA"); // role thuc tap

//        UUID departid = UUID.fromString("4729A783-455B-477C-B7E5-76A618FF53F2"); // depart Marketing
//        UUID departid = UUID.fromString("0C7A4FE1-6B12-430C-BC3B-9D5C57EBB263"); // depart IT
//        UUID departid = UUID.fromString("2285BBE0-8D0A-4851-AB97-3E7FF4630E91"); // depart Nhân sự
//        UUID departid = UUID.fromString("C7362F06-93B0-41A4-BC92-395192AF8614"); // depart kế toán và tài chính
//        UUID departid = UUID.fromString("a3114335-8597-497f-8b1a-07541510a982"); // depart bảo vệ
        //
        //        
        ////        String s = "6B70E85E-527E-486C-9F37-B14807E5A0B7";
        ////        UUID checkID = UUID.fromString(s);
        //UUID id = UUID.randomUUID();
        //        
        //        
        ////        pd.getPersonByID(checkID);
//                UUID id = UUID.randomUUID();
//System.out.println(id);
//        UUID roleid = UUID.fromString("9F07AD32-E157-4FDD-9639-E58C3E0231ED"); // nhân viên
//        UUID departid = UUID.fromString("0C7A4FE1-6B12-430C-BC3B-9D5C57EBB263"); // depart IT
//        UUID roleid = UUID.fromString("095D7FB5-8AD5-49C9-B39B-2F75759AB8FA"); // role thuc tap
//
//        UUID departid = UUID.fromString("4729A783-455B-477C-B7E5-76A618FF53F2"); // depart Marketing
////
//        UUID roleid = UUID.fromString("095D7FB5-8AD5-49C9-B39B-2F75759AB8FA"); // role thuc tap
//        //        UUID departid = UUID.fromString("C7362F06-93B0-41A4-BC92-395192AF8614"); // depart kế toán và tài chính
//        UUID id1 = UUID.fromString("8B21F6CE-DE11-4689-9BF6-41238E18293D"); // hung anh
//        UUID id2 = UUID.fromString("CBF2E872-2D16-4A90-85AF-CD2C5585942B"); // thien huong
//        UUID id3 = UUID.fromString("6D8CE7A3-AC86-416B-8F25-0135E00A5994"); // thien huong
//        UUID departid = UUID.fromString("0C7A4FE1-6B12-430C-BC3B-9D5C57EBB263"); // depart IT
//        Personnel p = new Personnel("Pham Hung Anh", "0989123489",
//                "2003-06-29", "IT2", true, true, id1, roleid, departid);
//        pd.update(p);
//        Personnel p1 = new Personnel("Trinh Thien Huong", "0912345678",
//                "2003-08-16", "IT3", true, false, id2, roleid, departid);
//        pd.update(p1);
//        Personnel p2 = new Personnel("Nguyen Thi Dung", "0912451252",
//                "2002-12-18", "MA2", true, false, id3, roleid, departid);
//        pd.update(p2);
        String code = "ngu";
        UUID departid = UUID.fromString("0C7A4FE1-6B12-430C-BC3B-9D5C57EBB263"); // depart IT

        List<Personnel> list = pd.searchPersonByDepart(code, departid);
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i).getPsname());

        }

//        //        Personnel p = 
//        //        System.out.println(p.getPsname());
//        pd.insert(p);
//String codedepart = "MA2";
//        Personnel checkCodePerson = pd.getPersonByDepartName(codedepart);
    }
}
