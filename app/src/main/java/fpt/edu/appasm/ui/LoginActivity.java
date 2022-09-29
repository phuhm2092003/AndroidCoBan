package fpt.edu.appasm.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import fpt.edu.appasm.R;

public class LoginActivity extends AppCompatActivity {
    EditText edtUser, edtPass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        edtUser = findViewById(R.id.edtUser);
        edtPass = findViewById(R.id.edtPass);
    }

    @SuppressLint("ShowToast")

    public void btn_login(View view) {
        StringBuilder tb = new StringBuilder();
        checkDataLogin(tb);
        if (tb.length() > 0) {
            Toast.makeText(this, tb.toString(), Toast.LENGTH_SHORT).show();
        } else {
            if (edtUser.getText().toString().equals("admin") && edtPass.getText().toString().equals("admin")) {
                Intent intent = new Intent(this, MainActivity.class);
                Toast.makeText(this, "Login system successful!", Toast.LENGTH_SHORT).show();
                startActivity(intent);
            } else {
                Toast.makeText(this, "Login system unsuccessful!", Toast.LENGTH_SHORT).show();
            }
        }
    }

    private void checkDataLogin(StringBuilder tb) {
        if (edtUser.getText().toString().equals("")) {
            tb.append("Username underfined!\n");
        }
        if (edtPass.getText().toString().equals("")) {
            tb.append("Password underfined!");
        }
    }
}