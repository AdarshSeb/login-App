package com.example.project_1;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

public class ChangeActivity extends AppCompatActivity {
    CDB db;
    String uname,upass;
    EditText e1,e2,e3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_change);
        db = new CDB(this);
        e1 = (EditText) findViewById(R.id.e1);
        e2 = (EditText) findViewById(R.id.e2);
        e3 = (EditText) findViewById(R.id.e3);
        Bundle b = getIntent().getExtras();
        uname = b.getString("name");
        upass = b.getString("upass");

    }

    public void onChange(View view){
        String userop,usernp,usercp;
        userop = e1.getText().toString();
        usernp = e2.getText().toString();
        usercp = e3.getText().toString();
        try{
            if(userop.equals(upass)){
                if(usernp.equals(usercp)){
                    db.updatePassword(uname,usernp);
                    Toast.makeText(this, "Password Updated Successfully", Toast.LENGTH_LONG).show();
                    finish();
                }
                else{
                    Toast.makeText(this, "Please Re-Enter Password Correctly", Toast.LENGTH_SHORT).show();
                }
            }
            else{
                Toast.makeText(this, "Old Password is Wrong", Toast.LENGTH_SHORT).show();
            }
        }
        catch(Exception e){
            System.out.println(e);
        }
    }

    public void onback(View view){
        finish();
    }

}



