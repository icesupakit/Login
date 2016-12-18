package com.example.login;

import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.login.DB.DatabaseHelper;

public class RegisterActivity extends AppCompatActivity {
    private EditText NameEditText, UNameEditText, PassEditText;
    private static final String TAG = DatabaseHelper.class.getSimpleName();


    private DatabaseHelper mHelper;
    private SQLiteDatabase mDb;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        mHelper = new DatabaseHelper(this);
        mDb = mHelper.getWritableDatabase();

        NameEditText = (EditText) findViewById(R.id.editText_name);
        UNameEditText = (EditText) findViewById(R.id.editText_use);
        PassEditText = (EditText) findViewById(R.id.editText_pass);
        Button Regis  = (Button)findViewById(R.id.Create_AC);



        Regis.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = NameEditText .getText().toString();
                String use = UNameEditText.getText().toString();
                String pass = PassEditText.getText().toString();

                ContentValues cv = new ContentValues();
                cv.put(DatabaseHelper.COL_NAME, name);
                cv.put(DatabaseHelper.COL_Use, use);
                cv.put(DatabaseHelper.COL_Pass, pass);
                mDb.insert(DatabaseHelper.TABLE_NAME, null, cv);

                Log.i(TAG,"เข้าแล้วนะ");

                finish();
                Intent intent=new Intent(RegisterActivity.this,LoginActivity.class);
                Toast toast = Toast.makeText ( RegisterActivity.this, "CREATE account successfully", Toast.LENGTH_SHORT );
                toast.show ( );
                startActivity(intent);

            }
        });
    }
}
