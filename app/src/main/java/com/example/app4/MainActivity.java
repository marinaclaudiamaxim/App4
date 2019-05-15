package com.example.app4;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private static EditText username ;
    private static EditText password;
    private static TextView attempts;
    private static Button login_button;
    int attempt_counter = 5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_main );
        LoginButton();
    }

    @SuppressLint("WrongViewCast")
    public void LoginButton(){
        username = findViewById( R.id.editText_name );
        password = findViewById( R.id.editText_pass);
        attempts = findViewById( R.id.textView_attempt_counter );
        login_button = findViewById( R.id.button );

        attempts.setText( Integer.toString( attempt_counter ) );

        login_button.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (username.getText().toString().equals( "user" ) && password.getText().toString().equals( "user" )) {
                    Toast.makeText(MainActivity.this, "User and Password are correct", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent( ".user" );
                    startActivity( intent );

                } else {
                    Toast.makeText(MainActivity.this, "User and Password are not correct!", Toast.LENGTH_SHORT).show();
                    attempt_counter--;
                    attempts.setText( Integer.toString( attempt_counter ) );
                    if (attempt_counter == 0) {
                        login_button.setEnabled( false );
                    }
                }
            }
        } );
    }


}
