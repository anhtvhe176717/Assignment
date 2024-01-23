/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;
import java.util.UUID;
/**
 *
 * @author admin
 */
public class Personnel {
    
private String psname, phonenum, dob, codepersonnel;
    private boolean status, sex;
    private UUID id, roleid, departid;

    public Personnel(String psname, String phonenum, String dob, String codepersonnel, boolean status, boolean sex, UUID id, UUID roleid, UUID departid) {
        this.psname = psname;
        this.phonenum = phonenum;
        this.dob = dob;
        this.codepersonnel = codepersonnel;
        this.status = status;
        this.sex = sex;
        this.id = id;
        this.roleid = roleid;
        this.departid = departid;
    }

    public Personnel(String psname, String phonenum, String dob, String codepersonnel, boolean status, boolean sex) {
        this.psname = psname;
        this.phonenum = phonenum;
        this.dob = dob;
        this.codepersonnel = codepersonnel;
        this.status = status;
        this.sex = sex;
    }
    
    

    public String getPsname() {
        return psname;
    }

    public void setPsname(String psname) {
        this.psname = psname;
    }

    public String getPhonenum() {
        return phonenum;
    }

    public void setPhonenum(String phonenum) {
        this.phonenum = phonenum;
    }

    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    public String getCodepersonnel() {
        return codepersonnel;
    }

    public void setCodepersonnel(String codepersonnel) {
        this.codepersonnel = codepersonnel;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public boolean isSex() {
        return sex;
    }

    public void setSex(boolean sex) {
        this.sex = sex;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public UUID getRoleid() {
        return roleid;
    }

    public void setRoleid(UUID roleid) {
        this.roleid = roleid;
    }

    public UUID getDepartid() {
        return departid;
    }

    public void setDepartid(UUID departid) {
        this.departid = departid;
    }
    
    

    
    
    
}
