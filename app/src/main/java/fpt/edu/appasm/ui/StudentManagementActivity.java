package fpt.edu.appasm.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.List;

import fpt.edu.appasm.Adapter.AdapterSpinner;
import fpt.edu.appasm.R;
import fpt.edu.appasm.database.ClassesDao;
import fpt.edu.appasm.database.StudentDao;
import fpt.edu.appasm.model.Classes;
import fpt.edu.appasm.model.Student;

public class StudentManagementActivity extends AppCompatActivity  implements View.OnClickListener{
    private List<Classes> listClasses;
    private List<Student> litsStudent;
    private Spinner spinnerClass;
    private ListView listViewStudent;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_management);

        spinnerClass = findViewById(R.id.spinnerClasses);
        listViewStudent = findViewById(R.id.lv_student);
        fillSpinner();
        findViewById(R.id.btn_saveStudent).setOnClickListener(this);
        findViewById(R.id.btn_deleteStudent).setOnClickListener(this);
    }

    @SuppressLint("NonConstantResourceId")
    @Override
    public void onClick(View view) {
       switch (view.getId()){
           case R.id.btn_saveStudent:
               break;
           case R.id.btn_deleteStudent:
               Toast.makeText(this, "Xoa thanh cong ", Toast.LENGTH_SHORT).show();
               break;
       }
    }

    public void fillSpinner(){
        ClassesDao dao = new ClassesDao(this);
        listClasses = dao.getAll();
        AdapterSpinner adapterSpinner = new AdapterSpinner(StudentManagementActivity.this, listClasses);
        spinnerClass.setAdapter(adapterSpinner);
    }
}