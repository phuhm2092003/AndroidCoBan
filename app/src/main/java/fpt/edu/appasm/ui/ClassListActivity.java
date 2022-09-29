package fpt.edu.appasm.ui;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.List;

import fpt.edu.appasm.Adapter.AdapterClasses;
import fpt.edu.appasm.R;
import fpt.edu.appasm.database.ClassesDao;
import fpt.edu.appasm.model.Classes;

public class ClassListActivity extends AppCompatActivity {
    private List<Classes> list;
    private ListView lvClasses;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_class_list);
        lvClasses = findViewById(R.id.listViewClasses);

        fillListViewClasses();

        lvClasses.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long l) {
                confirmDeleteClasses(i);
                return false;
            }
        });

    }
    public void confirmDeleteClasses(int position){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage("Do you want delete the classes ?");
        builder.setPositiveButton("Delete", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                ClassesDao dao = new ClassesDao(ClassListActivity.this);
                Classes cl = list.get(position);
                dao.delete(cl.getId());
                Toast.makeText(ClassListActivity.this, "Delete classes successful !", Toast.LENGTH_SHORT).show();
                fillListViewClasses();
            }
        });

        builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {

            }
        });
        builder.show();

    }

    public void fillListViewClasses(){
        ClassesDao dao = new ClassesDao(this);
        list = dao.getAll();
        AdapterClasses adapterClasses = new AdapterClasses(this, list);
        lvClasses.setAdapter(adapterClasses);
    }
}