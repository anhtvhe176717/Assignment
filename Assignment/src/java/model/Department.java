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
public class Department {
    /*
    [id] [uniqueidentifier] NOT NULL,
	[departname] [nvarchar](100) NOT NULL,
	[codedepart] [varchar](2) NOT NULL,
    */
    
    private UUID id;
    private String departname, codedepart;

    public Department(UUID id, String departname, String codedepart) {
        this.id = id;
        this.departname = departname;
        this.codedepart = codedepart;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getDepartname() {
        return departname;
    }

    public void setDepartname(String departname) {
        this.departname = departname;
    }

    public String getCodedepart() {
        return codedepart;
    }

    public void setCodedepart(String codedepart) {
        this.codedepart = codedepart;
    }

    

  

   

   
    
}
