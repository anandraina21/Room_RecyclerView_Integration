package com.example.room_recyclerview_integration.repository;

import android.content.Context;
import android.os.AsyncTask;

import androidx.lifecycle.LiveData;
import androidx.room.Room;

import com.example.room_recyclerview_integration.database.ProjectDatabase;
import com.example.room_recyclerview_integration.model.ProjectModel;

import java.util.List;

public class ProjectRepository {
    private static final String DB_NAME = "db_task";
    private ProjectDatabase projectDatabase;

    public ProjectRepository(Context context) {
        projectDatabase = Room.databaseBuilder(context, ProjectDatabase.class, DB_NAME).build();
    }

    public void insertTask(String textData) {
        ProjectModel projectModel = new ProjectModel();
        projectModel.setTextData(textData);
        insertTask(projectModel);
    }

    public void insertTask(final ProjectModel projectModel) {
        new AsyncTask<Void, Void, Void>() {
            protected Void doInBackground(Void... voids) {
                projectDatabase.projectDao().insertTask(projectModel);
                return null;
            }
        }.execute();
    }

    // Used to show all records in DB
    public LiveData<List<ProjectModel>> getAllTasks() {
        return projectDatabase.projectDao().fetchAllTasks();
    }
}
