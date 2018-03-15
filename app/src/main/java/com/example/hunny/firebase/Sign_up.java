package com.example.hunny.firebase;

import android.app.ProgressDialog;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

import java.util.regex.Pattern;

public class Sign_up extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
    }

    public void sign_up(View view) {

        EditText email_et = findViewById(R.id.email);
        EditText password_et = findViewById(R.id.password);

        String email = email_et.getText().toString();

        if(Patterns.EMAIL_ADDRESS.matcher(email).matches())
        {

        }
        else
        {
            Toast.makeText(Sign_up.this,"invaild Email", Toast.LENGTH_SHORT).show();
            return;
        }

        String password = password_et.getText().toString();

        if(password.length() >= 8 && password.length()< 24)
        {

        }

        else
        {
            Toast.makeText(Sign_up.this,"Password must be between 8 to 24 Character", Toast.LENGTH_SHORT).show();
            return;
        }

        final ProgressDialog progress = new ProgressDialog(Sign_up.this);

        progress.setTitle("Please Wait");
        progress.setMessage("Creating Account....");
        progress.show();


        FirebaseAuth authenticate = FirebaseAuth.getInstance();

        OnCompleteListener<AuthResult> listener = new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task)
            {
                progress.hide();
              if(task.isSuccessful())
              {
                  Toast.makeText(Sign_up.this, "done", Toast.LENGTH_SHORT).show();
              }
              else
              {
                 Toast.makeText(Sign_up.this, "error try again", Toast.LENGTH_SHORT).show();
              }
            }
        };

        authenticate.createUserWithEmailAndPassword(email,password).addOnCompleteListener(listener);
    }

}
