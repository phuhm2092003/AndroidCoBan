package fpt.edu.appasm.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import fpt.edu.appasm.R;
import fpt.edu.appasm.dialog.Dialog_class;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewById(R.id.btn_add_new_class).setOnClickListener(this);
        findViewById(R.id.btn_see_list_class).setOnClickListener(this);
        findViewById(R.id.btn_student_managemet).setOnClickListener(this);
    }

    @SuppressLint("NonConstantResourceId")
    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.btn_add_new_class:
                Dialog_class dialog_class = new Dialog_class(this);
                dialog_class.show();
                break;
            case R.id.btn_see_list_class:
                Intent intent = new Intent(this, ClassListActivity.class);
                startActivity(intent);
                break;
            case R.id.btn_student_managemet:
                Intent intent1 = new Intent(this, StudentManagementActivity.class);
                startActivity(intent1);
                break;
        }
    }
}