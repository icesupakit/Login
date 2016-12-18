package com.example.login;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.login.DB.DatabaseHelper;

public class LoginActivity extends AppCompatActivity {
    DatabaseHelper db ;
    SQLiteDatabase da;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        
        Button login  = (Button)findViewById(R.id.button_login);
        Button regis  = (Button)findViewById(R.id.button_Regis);



        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(LoginActivity.this,MainActivity.class);
                Toast toast = Toast.makeText ( LoginActivity.this, "Invaild username or password", Toast.LENGTH_SHORT );
                toast.show ( );
                startActivity(intent);
            }
        });


        regis.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(LoginActivity.this,RegisterActivity.class);
                startActivity(intent);

            }
        });


    }
}
