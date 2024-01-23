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
public class Project {
    /*
    [id] [uniqueidentifier] NOT NULL,
	[projectname] [nvarchar](100) NOT NULL,
	[endDate] [date] NULL,
	[startDate] [date] NOT NULL,
	[describe] [nvarchar](200) NULL,
	[status] [bit] NOT NULL,
    */
    private UUID id;
    private String projectname, startdate, enddate, describe;
    private boolean status;

    public Project(UUID id, String projectname, String startdate, String enddate, String describe, boolean status) {
        this.id = id;
        this.projectname = projectname;
        this.startdate = startdate;
        this.enddate = enddate;
        this.describe = describe;
        this.status = status;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getProjectname() {
        return projectname;
    }

    public void setProjectname(String projectname) {
        this.projectname = projectname;
    }

    public String getStartdate() {
        return startdate;
    }

    public void setStartdate(String startdate) {
        this.startdate = startdate;
    }

    public String getEnddate() {
        return enddate;
    }

    public void setEnddate(String enddate) {
        this.enddate = enddate;
    }

    public String getDescribe() {
        return describe;
    }

    public void setDescribe(String describe) {
        this.describe = describe;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }
    
}
