package com.example.room_recyclerview_integration.ui.activity;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.room_recyclerview_integration.R;
import com.example.room_recyclerview_integration.constants.AppConstants;
import com.example.room_recyclerview_integration.model.ProjectModel;
import com.example.room_recyclerview_integration.repository.ProjectRepository;

public class MainActivity extends AppCompatActivity implements AppConstants {

    private Button submit, viewRecords;
    private EditText enterText;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getSupportActionBar().setTitle("Insert Text");
        enterText = (EditText) findViewById(R.id.enter_text);
    }

    public void onClickSubmit(View view) {
        submit = (Button) findViewById(R.id.button_submit);
        new ProjectRepository(getApplicationContext()).insertTask(enterText.getText().toString());
        Toast.makeText(this, "Record Saved", Toast.LENGTH_SHORT).show();
    }

    public void onClickViewRecords(View view) {
        viewRecords = (Button) findViewById(R.id.button_view_records);
        Intent intent = new Intent(this, ViewRecordsActivity.class);
        startActivity(intent);
    }
}
