package com.example.project_1;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class RegisterActivity extends AppCompatActivity {
    EditText e1,e2,e3;
    CDB db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        e1 = (EditText) findViewById(R.id.e1);
        e2 = (EditText) findViewById(R.id.e2);
        e3 = (EditText) findViewById(R.id.e3);
        db = new CDB(this);
    }

    public void onreg(View v){
        String uname,upass,ucpass;
        String a[];
        try{
            uname = e1.getText().toString();
            upass = e2.getText().toString();
            ucpass = e3.getText().toString();
            a = db.getuser(uname);
            if(uname.equals(a[0])){
                Toast.makeText(this, "User Exists", Toast.LENGTH_SHORT).show();
            }

            else if(upass.equals(ucpass))
            {
                db.adduser(uname,upass);
                Toast.makeText(this,"Registered Successfully", Toast.LENGTH_SHORT).show();
                finish();
            }
            else{
                Toast.makeText(this,"Password Not Match", Toast.LENGTH_SHORT).show();
            }
        }
        catch (Exception e)
        {
            System.out.println(e);
        }
    }

    public void onback(View view){
        finish();
    }
}