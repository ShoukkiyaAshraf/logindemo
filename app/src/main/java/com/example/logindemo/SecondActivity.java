package com.example.logindemo;

import android.content.Intent;
import android.nfc.Tag;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.security.PrivateKey;

public class SecondActivity extends AppCompatActivity {

    private static  final String TAG = "SecondActivity" ;
    DatabaseHelper  mDatabaseHelper ;
    private Button btnAdd,btnView;
    private EditText editText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        editText = (EditText)findViewById(R.id.editText);
        btnAdd = (Button)findViewById(R.id.btnAdd);
        btnView = (Button)findViewById(R.id.btnView);
        mDatabaseHelper = new DatabaseHelper(this);

        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String newEntry = editText.getText().toString();
                if(editText.length()!=0){
                    AddData(newEntry);
                    editText.setText("");
                }else {
                    toastMessage("You must put something in the text field!");
                }
            }
        });

        btnView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SecondActivity.this,ListDataActivity.class);
                startActivity(intent);
            }
        });

    }
     public void AddData(String newEntry){
        boolean insertData = mDatabaseHelper.addData(newEntry);

        if(insertData){
            toastMessage("Data Successfully Inserted");
        }else {
            toastMessage("Something Went wrong");
        }

    }

    private void toastMessage(String message){
        Toast.makeText(this,message,Toast.LENGTH_SHORT).show();
    }
}
