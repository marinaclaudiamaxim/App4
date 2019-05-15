package com.example.app4;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class user extends AppCompatActivity {

    private static Button bp, bd,be;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_user );
        People();
        Description();
    }

    public void startService(View view) {
        Intent intent = new Intent( this, TheService.class );
        startService( intent );
    }


    public void stopService(View view) {
        Intent intent = new Intent( this, TheService.class );
        stopService( intent );
    }


    public void People(){
        bp = findViewById( R.id.button_people );

        bp.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(".people");
                startActivity( intent );
            }
        } );
    }

    public void Description(){
        bd = findViewById( R.id.button_description );

        bd.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent( ".description" );
                startActivity( intent );
            }
        } );
    }

}



