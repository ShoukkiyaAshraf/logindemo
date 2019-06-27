package com.example.logindemo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private EditText name ;
    private EditText password ;
    private TextView info ;
    private Button Login ;
    private int counter = 5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        name = (EditText)findViewById(R.id.etname);
        password = (EditText)findViewById(R.id.etpassword);
        info = (TextView)findViewById(R.id.etattempt);
        Login = (Button)findViewById(R.id.btnlogint);

        info.setText("no of attempts remaining: 5");

        Login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                validate(name.getText().toString(),password.getText().toString());
            }
        });

    }

    private void validate(String username,String userpassword){
        if((username.equals("Admin")) && (userpassword.equals("123"))){
            Intent intent1 = new Intent(MainActivity.this,SecondActivity.class);
            startActivity(intent1);
        }else {
            counter--;
            info.setText("no of attempts remaining: "+ String.valueOf(counter));
            if (counter == 0) {
                Login.setEnabled(false);
            }
        }
    }
}
