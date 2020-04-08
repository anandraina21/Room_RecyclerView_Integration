package com.example.room_recyclerview_integration.ui.activity;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.room_recyclerview_integration.R;
import com.example.room_recyclerview_integration.constants.AppConstants;
import com.example.room_recyclerview_integration.model.ProjectModel;
import com.example.room_recyclerview_integration.repository.ProjectRepository;
import com.example.room_recyclerview_integration.ui.adapter.ViewRecordsAdapter;

import java.util.List;

public class ViewRecordsActivity extends AppCompatActivity implements AppConstants {

    private ProjectRepository projectRepository;
    private RecyclerView recyclerView;
    private ViewRecordsAdapter viewRecordsAdapter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_records);

        getSupportActionBar().setTitle("Records");
        projectRepository = new ProjectRepository(getApplicationContext());
        recyclerView = (RecyclerView) findViewById(R.id.recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        updateList();
    }

    public void updateList() {
        projectRepository.getAllTasks().observe(this, new Observer<List<ProjectModel>>() {
            @Override
            public void onChanged(@Nullable List<ProjectModel> projectModels) {
                if (viewRecordsAdapter == null) {
                    viewRecordsAdapter = new ViewRecordsAdapter(projectModels);
                    recyclerView.setAdapter(viewRecordsAdapter);
                } else {
                    viewRecordsAdapter.addUpdatedList(projectModels);
                }
            }
        });
    }
}
