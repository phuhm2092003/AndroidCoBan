package fpt.edu.appasm.dialog;

import android.annotation.SuppressLint;
import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;

import fpt.edu.appasm.R;
import fpt.edu.appasm.database.ClassesDao;
import fpt.edu.appasm.model.Classes;
import fpt.edu.appasm.ui.MainActivity;

public class Dialog_class extends Dialog implements View.OnClickListener {
    private Context context;
    private EditText edtIdClass, edtNameClass;

    public Dialog_class(@NonNull Context context) {
        super(context);
        this.context = context;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_dialog_add_class);

        findViewById(R.id.btn_close).setOnClickListener(this);
        findViewById(R.id.btn_save).setOnClickListener(this);
        findViewById(R.id.btn_reset).setOnClickListener(this);

        edtIdClass = findViewById(R.id.edt_id_class);
        edtNameClass = findViewById(R.id.edt_name_class);

    }


    @SuppressLint("NonConstantResourceId")
    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_save:
                StringBuilder tb = new StringBuilder();
                checkDataInput(tb);
                if(tb.length()>0){
                    Toast.makeText(context, tb.toString(), Toast.LENGTH_SHORT).show();
                }else {
                    ClassesDao dao = new ClassesDao(context);
                    Classes cl = new Classes();
                    cl.setId(edtIdClass.getText().toString());
                    cl.setName(edtNameClass.getText().toString());
                    dao.insert(cl);
                    Toast.makeText(context, "Lưu thành công", Toast.LENGTH_SHORT).show();
                    resetForm();
                }
                break;
            case R.id.btn_reset:
                resetForm();
                break;
            case R.id.btn_close:
                dismiss();
                break;
        }
    }

    private void checkDataInput(StringBuilder tb) {
        if(edtIdClass.getText().toString().equals("")){
            tb.append("Class Id underfined!\n");
        }
        if(edtNameClass.getText().toString().equals("")){
            tb.append("Class Name underfined!");
        }
    }

    private void resetForm() {
        edtIdClass.setText("");
        edtNameClass.setText("");
    }


}
