package com.example.room_recyclerview_integration.dao;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import com.example.room_recyclerview_integration.model.ProjectModel;

import java.util.List;

@Dao
public interface ProjectDao {
    @Insert
    Long insertTask(ProjectModel projectModel);

    @Query("SELECT * from ProjectModel order by id desc")
    LiveData<List<ProjectModel>> fetchAllTasks();
}
