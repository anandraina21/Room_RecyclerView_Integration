package com.example.room_recyclerview_integration.model;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.io.Serializable;

@Entity
public class ProjectModel implements Serializable {

    @PrimaryKey(autoGenerate = true)
    private int id;

    private String textData;


    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setTextData(String textData) {
        this.textData = textData;
    }

    public String getTextData() {
        return textData;
    }
}
