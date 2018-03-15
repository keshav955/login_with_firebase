package com.example.hunny.firebase;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void login(View view)
    {
        EditText email_et = (findViewById(R.id.email));
        EditText password_et = (findViewById(R.id.password));

        String email = email_et.getText().toString();
        String password = password_et.getText().toString();
    }

    public void sign_up(View view)
    {
        Intent i = new Intent(MainActivity.this, Sign_up.class );

        startActivity(i);
    }
}
