package com.example.cms.entity;

import javax.persistence.*;
import java.io.Serializable;

@Entity
public class Content implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

    private String description;

    private String filePath;

    private boolean adminOnly;

    // getter / setter
    public Long getId() { return id; }
    public void setId(Long Id) { this.id = id; }
    
    public String getTitle() { return title; }
    public void setTitle(String t) { this.title = t; }

    public String getDescription() { return description; }
    public void setDescription(String d) { this.description = d; }

    public String getFilePath() { return filePath; }
    public void setFilePath(String f) { this.filePath = f; }

    public boolean isAdminOnly() { return adminOnly; }
    public void setAdminOnly(boolean a) { this.adminOnly = a; }
}
