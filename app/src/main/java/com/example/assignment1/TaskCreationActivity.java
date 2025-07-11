package com.example.assignment1;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class TaskCreationActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_task_creation);

        EditText titleInput = findViewById(R.id.taskTitleInput);
        EditText descriptionInput = findViewById(R.id.taskDescriptionInput);
        Button saveButton = findViewById(R.id.saveButton);

        saveButton.setOnClickListener(v -> {
            String title = titleInput.getText().toString();
            String description = descriptionInput.getText().toString();

            if (!title.isEmpty() && !description.isEmpty()) {
                Intent resultIntent = new Intent();
                resultIntent.putExtra("TASK_TITLE", title);
                resultIntent.putExtra("TASK_DESCRIPTION", description);
                setResult(RESULT_OK, resultIntent);
                finish();
            } else {
                Toast.makeText(this, "Please fill all fields", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
