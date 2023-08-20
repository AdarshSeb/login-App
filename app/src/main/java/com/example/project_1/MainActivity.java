package com.example.project_1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.util.Objects;

public class MainActivity extends AppCompatActivity {
    EditText e1, e2;
    CDB db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        e1 = (EditText) findViewById(R.id.e1);
        e2 = (EditText) findViewById(R.id.e2);
        db = new CDB(this);
    }

    public void onreg(View v) {
        Intent obj = new Intent("act.reg");
        startActivity(obj);
    }

    public void onlog(View v) {
            String uname, upass;
            String a[];

            uname = e1.getText().toString();
            upass = e2.getText().toString();
            a = db.getuser(uname);
            if (Objects.equals(a[0], uname) && Objects.equals(a[1], upass))
            {
                Toast.makeText(this, "Login Succesfull", 2).show();
                e1.setText("");
                e2.setText("");
                Intent obj = new Intent("act.login");
                obj.putExtra("uname", uname);
                obj.putExtra("upass", upass);
                startActivity(obj);

            }
            else
            {
                Toast.makeText(this, "Username and Password doesn't match", Toast.LENGTH_LONG).show();
            }



    }
}