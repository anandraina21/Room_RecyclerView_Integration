package com.example.room_recyclerview_integration.database;

import androidx.room.Database;
import androidx.room.RoomDatabase;

import com.example.room_recyclerview_integration.dao.ProjectDao;
import com.example.room_recyclerview_integration.model.ProjectModel;

@Database(entities = {ProjectModel.class}, version = 1, exportSchema = false)
public abstract class ProjectDatabase extends RoomDatabase {
    public abstract ProjectDao projectDao();
}
