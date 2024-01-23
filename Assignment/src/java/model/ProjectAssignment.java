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
public class ProjectAssignment {
    /*
    [id] [uniqueidentifier] NOT NULL,
	[projectid] [uniqueidentifier] NOT NULL,
	[personid] [uniqueidentifier] NOT NULL,
     */
    
    private UUID id,projectid,personid;

    public ProjectAssignment(UUID id, UUID projectid, UUID personid) {
        this.id = id;
        this.projectid = projectid;
        this.personid = personid;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public UUID getProjectid() {
        return projectid;
    }

    public void setProjectid(UUID projectid) {
        this.projectid = projectid;
    }

    public UUID getPersonid() {
        return personid;
    }

    public void setPersonid(UUID personid) {
        this.personid = personid;
    }
    
    
   
}
