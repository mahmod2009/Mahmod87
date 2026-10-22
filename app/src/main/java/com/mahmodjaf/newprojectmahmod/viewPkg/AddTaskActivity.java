package com.mahmodjaf.newprojectmahmod.viewPkg;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.mahmodjaf.newprojectmahmod.R;

import org.w3c.dom.Text;

public class AddTaskActivity extends AppCompatActivity {
    private TextView TextView;
    private EditText etTitle;
    private EditText etDescription;
    private EditText etPriority;
    private Button btnSaveTask;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_add_task);
        TextView=findViewById(R.id.TextView);
        etTitle=findViewById(R.id.etTitle);
        etDescription=findViewById(R.id.etDescription);
        etPriority=findViewById(R.id.etPriority);
        btnSaveTask=findViewById(R.id.btnSaveTask);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
}